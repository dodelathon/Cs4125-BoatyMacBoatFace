/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySqlAccess 
{
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public MySqlAccess()throws Exception
  {
      connectDB("localhost","sqluser","donal", "users");
  }
  public MySqlAccess(String user, String Pass, String db, String domain)throws Exception
  {
      connectDB(domain,user,Pass,db);
  }
   
  private void connectDB(String domain, String user, String Pass, String db) throws Exception
  {
       // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager.getConnection("jdbc:mysql://" + domain + "/" + db + "?" + "user=" +  user +"&password=" + Pass);
      statement = connect.createStatement();
  }
  
  public void insertRowIntoUser(String name, String surname, String username, String password, String email, int access) throws Exception
  {
      preparedStatement = connect.prepareStatement("insert into  users.user values (default, ?, ?, ?, PASSWORD(?) , default, ?)");
      preparedStatement.setString(1, name);
      preparedStatement.setString(2, surname);
      preparedStatement.setString(3, username);
      preparedStatement.setString(4, password);
      preparedStatement.setString(5, email);
      preparedStatement.setString(6, access + "");
      preparedStatement.executeUpdate();
      System.out.println("Item has been added to the Database!");
  }
  
  public void insertRowIntoGames(int id1, int id2) throws Exception
  {
      if(id1 != id2)
      {
        preparedStatement = connect.prepareStatement("insert into games values (default, ?, ?, default)");
        preparedStatement.setString(1, id1 + "");
        preparedStatement.setString(2, id2 + "");
        preparedStatement.executeUpdate();
        System.out.println("Item has been added to the Database!");
      }
      else
      {
          System.out.println("Player cannot play against self");
      }
  }
  
  public void insertRowIntoMoves(int gameId, int playerId, int x, int y) throws SQLException
  {
      if(moveMade(x, y) == false)
      {
        preparedStatement = connect.prepareStatement("insert into moves values (default, ?, ?, ?, ?)");
        preparedStatement.setString(1, gameId + "");
        preparedStatement.setString(2, playerId + "");
        preparedStatement.setString(3, x + "");
        preparedStatement.setString(4, y + "");
        preparedStatement.executeUpdate();
        System.out.println("Item has been added to the Database!");
      }
      else
      {
          System.out.println("cannot insert as this move has already been played!");
      }
  }
 
  public void searchDBByID(int id, String db) throws Exception
  {
      preparedStatement = connect.prepareStatement("SELECT * from ? where autoID=?");
      preparedStatement.setString(1, db);
      preparedStatement.setString(2, id + "");
      resultSet = preparedStatement.executeQuery();
      if(db.equalsIgnoreCase("user"))
      {
        writeResultSet(resultSet, 1);
      }
      else if(db.equals("games"))
      {
          writeResultSet(resultSet, 2);
      }
      else if(db.equals("moves"))
      {
          writeResultSet(resultSet, 3);
      }
  }
  
  public void readAllFromDB(String Db) throws Exception 
  {
    try 
    {
      // Result set get the result of the SQL query
      resultSet = statement.executeQuery("select * from " + Db);
      if(Db.equalsIgnoreCase("user"))
      {
        writeResultSet(resultSet, 1);
      }
      else if(Db.equals("games"))
      {
          writeResultSet(resultSet, 2);
      }
      else if(Db.equals("moves"))
      {
          writeResultSet(resultSet, 3);
      }
      
    } 
    catch (Exception e) 
    {
      throw e;
    }
  }
  
  public void deleteFromDB(String db, int input) throws Exception
  {
      preparedStatement = connect.prepareStatement("delete from " + db + " where autoID=?;");
      preparedStatement.setInt(1, input);
      preparedStatement.executeUpdate();
  }
  
  private void writeMetaData(ResultSet resultSet) throws SQLException 
  {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for(int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++)
    {
      System.out.println("Column " + i + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }
  
  private boolean moveMade(int newX, int newY) throws SQLException
  {
      resultSet = statement.executeQuery("select * from moves;");
      while (resultSet.next()) 
      {
            int x = Integer.parseInt(resultSet.getString("x"));
            //System.out.println(x);
            int y = Integer.parseInt(resultSet.getString("y"));
            //System.out.println(y);
            
            if(x == newX && y == newY)
            {
                //System.out.println("Herer");
               return true; 
            }
      }
      return false;
  }

  private void writeResultSet(ResultSet resultSet, int db) throws SQLException 
  {
    // ResultSet is initially before the first data set
    switch(db)
    {
        case 1:
            while (resultSet.next()) 
            {
        // It is possible to get the columns via name
        // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("autoID");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String username = resultSet.getString("username");
            String pass = resultSet.getString("password");
            String email = resultSet.getString("email");
            String state = resultSet.getString("isactive");
            String clearance = resultSet.getString("access_level");
            System.out.println("ID: " + id + " | Name: " + name +" | Surname: " + surname + " | Username: " + username + " | Password: " + pass + " | Email: " + email + " | Is Online: " + state + " | Access level: " + clearance);
            }
            break;
        
        case 2: 
            while (resultSet.next()) 
            {
        // It is possible to get the columns via name
        // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("autoID");
            String player1 = resultSet.getString("p1");
            String player2 = resultSet.getString("p2");
            String state = resultSet.getString("gameState");
            System.out.println("ID: " + id +" | Player 1: " + player1 + " | Player 2: " + player2 + " | Game State: " + state);
            }
            break;
            
        case 3: 
            while (resultSet.next()) 
            {
        // It is possible to get the columns via name
        // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("autoID");
            String player = resultSet.getString("pID");
            String game = resultSet.getString("gID");
            String x = resultSet.getString("x");
            String y = resultSet.getString("y");
            System.out.println("ID: " + id +" | Player: " + player + " | GameID: " + game + " | Box X-axis: " + x + " | Box Y-axis: " + y);
            }
            break;
    }
  }

  // You need to close the resultSet
  private void close() 
  {
    try {
      if (resultSet != null) 
      {
        resultSet.close();
      }

      if (statement != null) 
      {
        statement.close();
      }

      if (connect != null) 
      {
        connect.close();
      }
    } catch (Exception e) 
    {

    }
  }
}


    
