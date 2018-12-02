/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Layer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;
/**
 *
 * @author donal
 */
public class Client_socket 
{
    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private InetAddress ip;

    
    public Client_socket()
    {
        listenSocket();       
    }
    
    public void listenSocket() 
    {
        //Create socket connection
        try 
        {
            ip = InetAddress.getLocalHost();
            String hostname = ip.getHostName();
            socket = new Socket(hostname, 4444);
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
                    out.println(request);
                    request = in.readLine();
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

