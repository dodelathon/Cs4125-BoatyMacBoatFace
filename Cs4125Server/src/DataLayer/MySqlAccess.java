/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

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
            if(insertRowIntoMatchmakingInfo(uName, 0) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(isDev == 1)
        {
            preparedStatement = connect.prepareStatement("insert into login_info values (default, ?, ?, ?)");
            preparedStatement.setString(1, uName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, isDev + "");
            preparedStatement.executeUpdate();
            if(insertRowIntoMatchmakingInfo(uName, 0) == true)
            {
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
      else
      {
          return false;
      }
  }
  
  private boolean insertRowIntoMatchmakingInfo(String uName, double rating) 
  {
    System.out.println("here");
    try
    {
        preparedStatement = connect.prepareStatement("insert into matchmaker_info values (LAST_INSERT_ID(), ?, ?, default, default)");
        preparedStatement.setString(1, uName );
        preparedStatement.setString(2, rating + "");
        if(preparedStatement.executeUpdate() == 0)
        {
            return false; 
        }
        else 
        {
            return true;
        }
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
        return false;
    }
    
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
      else if(db.equalsIgnoreCase("matches"))
      {
        preparedStatement = connect.prepareStatement("SELECT * from ? where gID=?");
        preparedStatement.setString(1, db);
        preparedStatement.setInt(2, id);
        resultSet = preparedStatement.executeQuery();
        res = writeResultSet(resultSet, 3);
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
  
  public void updateQueuedStatus(int playerID, int status) throws SQLException
  {
      preparedStatement  = connect.prepareStatement("update matchmaker_info set queued = ? where userIDMatch = ?");
      preparedStatement.setString(1, status + "");
      preparedStatement.setString(2, playerID + "");
      preparedStatement.executeUpdate();
  }
  
  public String getQueuedPlayers() throws SQLException
  {
      preparedStatement  = connect.prepareStatement("select * matchmaker_info where queued = 1");
      resultSet = preparedStatement.executeQuery();
      return writeResultSet(resultSet, 3);
  }
  
  public String getOnlinePlayers() throws SQLException
  {
      preparedStatement  = connect.prepareStatement("select * matchmaker_info where is_online = 1");
      resultSet = preparedStatement.executeQuery();
      return writeResultSet(resultSet, 3);
  }
  
  public String readAllFromDB(String Db) 
  {
    try 
    {
      // Result set get the result of the SQL query
      Db = Db.toLowerCase();
      resultSet = statement.executeQuery("select * from " + Db);
      if(Db.equalsIgnoreCase("login_info"))
      {
          return writeResultSet(resultSet, 1);
      }
      else if(Db.equalsIgnoreCase("matchmaker_info"))
      {
          return writeResultSet(resultSet, 2);
      }
      else if(Db.equalsIgnoreCase("matches"))
      {
          return writeResultSet(resultSet, 3);
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
  
  public int newGame(int p1, String p1name, int p2, String p2name, int p3, String p3name, int p4, String p4name, int p5, String p5name )
  {
      try
      {
        preparedStatement = connect.prepareStatement("insert into matches values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, p1 );
        preparedStatement.setString(2, p1name);
        preparedStatement.setInt(3, p2);
        preparedStatement.setString(4, p2name);
        preparedStatement.setInt(5, p3);
        preparedStatement.setString(6, p3name);
        preparedStatement.setInt(7, p4);
        preparedStatement.setString(8, p4name);
        preparedStatement.setInt(9, p5);
        preparedStatement.setString(10, p5name);
        int executeUpdate = preparedStatement.executeUpdate();
        return executeUpdate;
      }
      catch(Exception e)
      {
          return 0;
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
                String queued = resultSet.getString("queued");
                //System.out.println("ID: " + id +" | Username: " + Uname + " | Rating: " + rating + " | Online status: " + online );
                hold += id + "," + Uname + "," + rating + "," + online +  "," + queued +",";
            } 
            break;
            
        case 3:
            while(resultSet.next())
            {
                String gID = resultSet.getString("MatchID");
                
                String P1ID = resultSet.getString("p1");
                String P1Name = resultSet.getString("p1Name");
                
                String P2ID = resultSet.getString("p2");
                String P2Name = resultSet.getString("p2Name");
                
                String P3ID = resultSet.getString("p3");
                String P3Name = resultSet.getString("p3Name");
                
                String P4ID = resultSet.getString("p4");
                String P4Name = resultSet.getString("p4Name");
                
                String P5ID = resultSet.getString("p5");
                String P5Name = resultSet.getString("p5Name");
                
                hold += gID + "," + P1ID + "," + P1Name + "," + P2ID + "," + P2Name + "," + P3ID  + P3Name + "," + P4ID + "," + P4Name + "," + P5ID + "," + P5Name + ",";
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


    
