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
/**
 *
 * @author donal
 */
public class Client_socket 
{
    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    
    public Client_socket()
    {
        
    }
    
    public void listenSocket() 
    {
        //Create socket connection
        try 
        {
            socket = new Socket("Donals-PC", 4444);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } 
        catch (UnknownHostException e) 
        {
            System.out.println("Unknown host: 192.168.0.97.eng");
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

