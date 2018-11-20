/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author donal
 */
class doComms implements Runnable 
{
    private Socket server;
    private String line, output;
    private final String  p1, p2;
    private MySqlAccess conn;

    doComms(Socket server) 
    {
      this.server = server;
      p1 = "[A-Za-z]{1,30}";
      p2 = "[0-9]";
    }

    @Override
    public void run () 
    {

      output="";

      try 
      {
        // Get input from the client
        BufferedReader in = new BufferedReader (new InputStreamReader(server.getInputStream()));
        PrintStream out = new PrintStream(server.getOutputStream());
        String interim[];
        conn = connect();
        if(conn == null)
        {
            out.println("Database unavailable, Please try again later!");
        }
        else
        {
            
            while((line = in.readLine()) != null)
            {
                line = line.toLowerCase();
                interim = line.split(",");
                switch(interim[0])
                {
                    case "quit":
                        conn = null;
                        in = null;
                        out = null;
                        server.close();
                    break;
                    case "adduser":
                        if(interim.length == 4)
                        {
                            addUser(interim);
                            output = "Successful!";
                        }
                        else
                        {
                            output = "Incorrect amount arguments!";
                        }
                    break;
                    case "getall":
                        if(interim.length == 2)
                        {
                            getAll(interim[1].trim());
                        }
                        else
                        {
                            output = "Incorrect amount arguments!";
                        }
                    break;
                    case "getuser":
                        if(interim.length == 3)
                        {
                            if(interim[1].matches(p1))
                            {
                                getUser(interim[1].trim(), interim[2].trim());
                            }
                            else if(interim[1].matches(p2) )
                            {   
                                getUser(Integer.parseInt(interim[1].trim()), interim[2].trim());
                            }
                            else
                            {
                                output = "Invalid input";
                            }
                        }
                        else
                        {
                            output = "Incorrect amount arguments!";
                        }
                    break;
                    case "setonlinestatus":
                        if(interim.length == 3)
                        {
                            setOnlineStatus(Integer.parseInt(interim[1].trim()), Integer.parseInt(interim[2].trim()));
                        }
                        else
                        {
                            output = "Incorrect amount arguments!"; 
                        }
                    break;
                    case "setelo":
                        if(interim.length == 3)
                        {
                            setElo(Integer.parseInt(interim[1].trim()), Double.parseDouble(interim[2].trim()));
                        }
                        else
                        {
                            output = "Incorrect amount arguments!";
                        }
                    break;
                }
                out.println(output);
            }
        }
      } 
      catch (IOException ioe) 
      {
        System.out.println("IOException on socket listen: " + ioe);
      }
    }
    
    private void addUser(String [] interim)
    {
        try
        {
            boolean success = conn.insertRowIntoLoginInfo(interim[1].trim(), interim[2].trim(), Integer.parseInt(interim[3].trim()));
            if(success == true)
            {
                output = "Successful!";
            }
            else
            {
                output = "Unsuccessful";
            }
        }
        catch(Exception e)
        {
            output = "Failed";
        }
    }
    
    private void getAll(String db)
    {
        try
        {
            output = conn.readAllFromDB(db) + ".";
        }
        catch(Exception e)
        {
            output  = "Failed!";
        }
        
    }
    
    private void getUser(String user, String db)
    {
        try
        {
            output = conn.searchDBByName(user, db);
        }
        catch(Exception e)
        {
            output  = "Failed";
        }
    }
    
    private void getUser(int userID, String db)
    {
        try
        {
            output = conn.searchDBByID(userID, db);
        }
        catch(Exception e)
        {
            output  = "Failed";
        }
    }
    
    private void setOnlineStatus(int uiD, int status)
    {
        try
        {
            conn.updateOnlineStatus(uiD, status);
            output = "success!";
        }
        catch(Exception e)
        {
           output = "Failed";
        }
    }
    
    private void setElo(int uiD, double newElo)
    {
        try
        {
            conn.updateElo(uiD, newElo);
            output = "success";
        }
        catch(Exception e)
        {
            output = "Failed";
        }
    }
    
    private MySqlAccess connect()
    {
        try
        {
            return MySqlAccess.getInstance();
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
