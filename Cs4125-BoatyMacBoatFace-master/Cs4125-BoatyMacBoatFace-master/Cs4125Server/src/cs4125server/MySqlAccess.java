/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class MySqlAccess 
{
  final static MySqlAccess access = getInstance();
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  private MySqlAccess()throws Exception
  {
      connectDB("localhost","root","", "userdetails");
  }
  private MySqlAccess(String user, String Pass, String db, String domain)throws Exception
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
  
  public boolean insertRowIntoLoginInfo(String uName, String password, int isDev) throws Exception
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
            return true;
        }
        else if(isDev == 1)
        {
            preparedStatement = connect.prepareStatement("insert into login_info values (default, ?, ?, ?)");
            preparedStatement.setString(1, uName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, isDev + "");
            preparedStatement.executeUpdate();
            insertRowIntoMatchmakingInfo(uName, 0);
            return true;
        }
        else
        {
            return false;
        }
      }
      else
      {
          return false;
      }
  }
  
  private void insertRowIntoMatchmakingInfo(String uName, double rating) throws Exception
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
      else if(db.equalsIgnoreCase("matchmaker_info"))
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
  
  public boolean isPlayerDev(String name) throws Exception
  {
     String result = searchDBByName(name, "login_info");
     String interim[] = result.split(",");
     if(Integer.parseInt(interim[3].trim()) == 0)
     {
         return false;
     }
     else if(Integer.parseInt(interim[3].trim()) == 1)
     {
        return true; 
     }
     else
     {
        return false;
     }
  }
  
  public String searchDBByName(String name, String db) throws Exception
  {
      String res = "";
      if(db.equalsIgnoreCase("login_info"))
      {
        preparedStatement = connect.prepareStatement("SELECT * from " + db + " where usernameLog=?");
        //preparedStatement.setString(1, db);
        preparedStatement.setString(1, name);
        resultSet = preparedStatement.executeQuery();
        res = writeResultSet(resultSet, 1);
        return res;
      }
      else if(db.equalsIgnoreCase("matchmaker_info"))
      {
        preparedStatement = connect.prepareStatement("SELECT * from " + db + " where usernameMatch=?");
       // preparedStatement.setString(1, db);
        preparedStatement.setString(1, name);
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
  
  public static MySqlAccess getInstance()
  {
      if(access == null)
      {
        try
        {
            return new MySqlAccess();
        }
        catch(Exception e)
        {
            return null;        
        }
      }
      else
      {
          return access;
      }
  }
  
  
  public void updateElo(int playerID, double newElo) throws SQLException
  {
      preparedStatement  = connect.prepareStatement("update matchmaker_info set rating = ? where userIDMatch = ?");
      preparedStatement.setString(1, newElo + "");
      preparedStatement.setString(2, playerID + "");
      preparedStatement.executeUpdate();
  }
  
  public void updateOnlineStatus(int playerID, int status) throws SQLException
  {
      preparedStatement  = connect.prepareStatement("update matchmaker_info set is_online = ? where userIDMatch = ?");
      preparedStatement.setString(1, status + "");
      preparedStatement.setString(2, playerID + "");
      preparedStatement.executeUpdate();
  }
  
  public String readAllFromDB(String Db) throws Exception 
  {
    try 
    {
      // Result set get the result of the SQL query
      resultSet = statement.executeQuery("select * from " + Db);
      if(Db.equalsIgnoreCase("login_info"))
      {
          return writeResultSet(resultSet, 1);
      }
      else if(Db.equalsIgnoreCase("matchmaker_info"))
      {
          return writeResultSet(resultSet, 2);
      }
      else 
      {
          return "";
      }
      
    } 
    catch (Exception e) 
    {
       return e.getMessage();
    }
  }
  
  public void deleteUser(String user) throws Exception
  {
      preparedStatement = connect.prepareStatement("delete from login_info where usernameLog=?;");
      preparedStatement.setString(1, user);
      preparedStatement.executeUpdate();
      System.out.println("User has been deleted!");
  }
  
  public String getPassword(String userName) throws Exception
  {
      String res = searchDBByName(userName, "login_info");
      String [] interim = res.split(",");
      //System.out.println(res);
      return interim[2].trim();
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
                String clearance = resultSet.getString("isDev");
               // System.out.println("ID: " + id + " | Username: " + username + " | Password: " + pass + " | Is Dev: " + clearance);
                hold += id + "," + username + "," + pass + "," + clearance + ",";
            }
            break;
        
        case 2: 
            while (resultSet.next()) 
            {
                String id = resultSet.getString("userIDMatch");
                String Uname = resultSet.getString("usernameMatch");
                String rating = resultSet.getString("rating");
                String online = resultSet.getString("is_online");
                //System.out.println("ID: " + id +" | Username: " + Uname + " | Rating: " + rating + " | Online status: " + online );
                hold += id + "," + Uname + "," + rating + "," + online + "\n";
            } 
            break; 
        }
    return hold;
  }
  
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


    
