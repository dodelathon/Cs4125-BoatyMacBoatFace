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

public class MySqlAccess 
{
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public MySqlAccess()throws Exception
  {
      connectDB("localhost","Donal","Zippingdonal07", "userdetails");
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
  
  public void insertRowIntoLoginInfo(String uName, String password, int isDev) throws Exception
  {
      if(isUsernameUsed(uName) == false)
      {
          if(isDev == 0)
        {
            preparedStatement = connect.prepareStatement("insert into login_info values (default, ?, ?, default)");
            preparedStatement.setString(1, uName);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            insertRowIntoMatchmakingInfo(uName, 0);
            System.out.println("User has been added to the login Database!");
        }
        else if(isDev == 1)
        {
            preparedStatement = connect.prepareStatement("insert into login_info values (default, ?, ?, ?)");
            preparedStatement.setString(1, uName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, isDev + "");
            preparedStatement.executeUpdate();
            insertRowIntoMatchmakingInfo(uName, 0);
            System.out.println("User has been added to the login Database!");
        }
      }
      else
      {
          System.out.println("Username is already take, Please enter another");
      }
  }
  
  private void insertRowIntoMatchmakingInfo(String uName, int rating) throws Exception
  {
      
    preparedStatement = connect.prepareStatement("insert into matchmaker_info values (LAST_INSERT_ID(), ?, ?, default)");
    preparedStatement.setString(1, uName );
    preparedStatement.setString(2, rating + "");
    preparedStatement.executeUpdate();
    System.out.println("User has been added to the Matchmaking Database!");
  }
 
  public String searchDBByID(int id, String db) throws Exception
  {
      String res = "";
      if(db.equalsIgnoreCase("login_info"))
      {
        preparedStatement = connect.prepareStatement("SELECT * from ? where userIDLog=?");
        preparedStatement.setString(1, db);
        preparedStatement.setString(2, id + "");
        resultSet = preparedStatement.executeQuery();
        res = writeResultSet(resultSet, 1);
        return res;
      }
      else if(db.equalsIgnoreCase("matchmaking_info"))
      {
        preparedStatement = connect.prepareStatement("SELECT * from ? where userIDMatch=?");
        preparedStatement.setString(1, db);
        preparedStatement.setString(2, id + "");
        resultSet = preparedStatement.executeQuery();
        res = writeResultSet(resultSet, 2);
        return res;
      }
      else
      {
          return res;
      }
  }
  
  private boolean isUsernameUsed(String uName) throws SQLException
  {
      preparedStatement = connect.prepareStatement("select * from login_info where usernameLog=?");
      preparedStatement.setString(1, uName);
      resultSet = preparedStatement.executeQuery();
      //System.out.println(resultSet.first());
      if(resultSet.first() == true)
      {
          return true;
      }
      else
      {
          return false;
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
  
  public void deleteUser(int input) throws Exception
  {
      preparedStatement = connect.prepareStatement("delete from login_info where userIDLog=?;");
      preparedStatement.setInt(1, input);
      preparedStatement.executeUpdate();
  }
  
  public String getPassword(int userID) throws Exception
  {
      String res = searchDBByID(userID, "login_info");
      String [] interim = res.split(" | ");
      return interim[1].trim();
  }

  private String writeResultSet(ResultSet resultSet, int db) throws SQLException 
  {
    // ResultSet is initially before the first data set
    String hold = "";
    switch(db)
    {
        case 1:
            while (resultSet.next()) 
            {
            String id = resultSet.getString("userIDLog");
            String username = resultSet.getString("usernameLog");
            String pass = resultSet.getString("password");
            String clearance = resultSet.getString("access_level");
            System.out.println("ID: " + id + " | Username: " + username + " | Password: " + pass + " | Is Dev: " + clearance);
            hold = id + " | " + username + " | " + pass + " | " + clearance;
            }
            break;
        
        case 2: 
            while (resultSet.next()) 
            {
            String id = resultSet.getString("userIDMatch");
            String Uname = resultSet.getString("usernameMatch");
            String rating = resultSet.getString("rating");
            String online = resultSet.getString("is_online");
            System.out.println("ID: " + id +" | Username: " + Uname + " | Rating: " + rating + " | Online status: " + online );
            hold = id + " | " + Uname + " | " + rating + " | " + online;
            } 
            break; 
        }
    return hold;
  }


  // You need to close the resultSet

    /**
     *
     */
  public void close() 
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


    
