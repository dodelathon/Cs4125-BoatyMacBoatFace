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
      p1 = "[A-Za-z]";
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
            
        }
        else
        {
            while(((line = in.readLine()) != null))
            {
                line = line.toLowerCase();
                interim = line.split(",");
                switch(interim[0])
                {
                case "adduser": 
                    addUser(interim);
                    break;
                case "getall":
                    getAll(interim[1]);
                    break;
                case "getuser":
                    if(interim[1].matches(p1))
                    {
                        getUser(interim[1], interim[2]);
                    }
                    else if(interim[1].matches(p2))
                    {
                        getUser(Integer.parseInt(interim[1]), interim[2]);
                    }
                    else
                    {
                        output = "Invalid input";
                    }
                    break;
                case "setonlinestatus":
                    setOnlineStatus(Integer.parseInt(interim[1]), Integer.parseInt(interim[2]));
                    break;
                case "setelo":
                    setElo(Integer.parseInt(interim[1]), Integer.parseInt(interim[2]));
                    break;
                }
            }
        }

        // Now write to the client

        out.println(output);

        server.close();
      } 
      catch (IOException ioe) 
      {
        System.out.println("IOException on socket listen: " + ioe);
        ioe.printStackTrace();
      }
    }
    
    private void addUser(String [] interim)
    {
        try
        {
            conn.insertRowIntoLoginInfo(interim[1], interim[2], Integer.parseInt(interim[3]));
            output = "Insertion successful!";
        }
        catch(Exception e)
        {
            output = e.toString();
        }
    }
    
    private void getAll(String db)
    {
        try
        {
            output = conn.readAllFromDB(db);
        }
        catch(Exception e)
        {
            output  = e.toString();
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
            output  = e.toString();
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
            output  = e.toString();
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
           output = e.toString();
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
            output = e.toString();
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
