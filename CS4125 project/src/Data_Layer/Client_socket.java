/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Layer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 *
 * @author donal
 */
public class Client_socket 
{
    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private final String ip = "10.52.32.141";
  //  private String [] interim;
    
    public Client_socket()
    {
        listenSocket();       
    }
    
    public void listenSocket() 
    {
        //Create socket connection
        try 
        {
            socket = new Socket(ip, 4444);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } 
        catch (UnknownHostException e) 
        {
            System.out.println("Unknown host: " + ip);
            System.exit(1);
        } 
        catch  (IOException e) 
        {
            System.out.println("No I/O");
            System.exit(1);
        }
    }

    public String sendInfo(String request)
    {
        String hold = "";
            try
            {
                if(request != null)
                {
                    request = request.toLowerCase();
                    //interim = request.split(",");
                    out.println(request);
                    request = in.readLine();
                   // System.out.println(request);
                   // interim = request.split(",");
                    //request = "";
                   /* if(interim.length > 1)
                    {
                        for(int i = 0; i < interim.length - 4; i = i + 4)
                        {
                            request += interim[i] + " | " + interim[i + 1] + " | " + interim[i + 2] + " | " + interim[i + 3] + "\n";
                        }
                    }
                    else
                    {
                        request = interim[0];
                    }
                    interim = null;*/ 
                }
                else
                {
                    request = "Please provide request";
                }
            }
            catch(IOException e)
            {
                request = "Error taking request!";
                request += "\n" + e.getMessage();
                
            }
            return request;
    }
}

