/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125server;

import BusinessLayer.Client_Handling.*;
import java.io.*;
import java.net.*;
import java.security.*;
/**
 *
 * @author donal
 */
public class Cs4125Server 
{



/**
     * Title:        Sample Server
     * Description:  This utility will accept input from a socket, posting back to the socket before closing the link.
     * It is intended as a template for coders to base servers on. Please report bugs to brad at kieser.net
     * Copyright:    Copyright (c) 2002
     * Company:      Kieser.net
     * @author B. Kieser
     * @version 1.0
     */
    private static final int port = 4444;
    private static final int maxConnections = 0;
  // Listen for incoming connections and handle them
  public static void main(String[] args) 
  {
    int i=0;

    try
    {
      ServerSocket listener = new ServerSocket(port);
      Socket server;

      while((i++ < maxConnections) || (maxConnections == 0))
      {
        server = listener.accept();
        doComms conn_c = new doComms(server);
        conn_c.start();
        System.out.println(i);
      }
    } 
    catch (Exception e) 
    {
      System.out.println("Client has diconnected");
    }
  }

}


