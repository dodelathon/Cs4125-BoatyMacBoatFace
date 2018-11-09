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
    private final String ip = "192.168.43.1";
    Scanner cmd;
    String input;
    String [] interim;
    
    public Client_socket()
    {
        this.cmd = new Scanner(System.in);
        boolean stop = false;
        listenSocket();
        while(stop == false)
        {
            try
            {
                input = cmd.nextLine().toLowerCase();
                interim = input.split(",");
                switch(interim[0])
                {
                    case "quit": stop = false; break;
                    default : out.println(input); System.out.println(in.readLine()); interim = null; break;
                    
                }
            }
            catch(Exception e)
            {
                System.out.println("Error taking input!");
            }
        }
        
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

    public static void main(String[] args) 
    {
        Client_socket frame = new Client_socket();
	frame.listenSocket();
    }
}

