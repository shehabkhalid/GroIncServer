/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groincserver;


import Backend_skeleton.dataBaseConnector;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author shehab
 */
public class GroIncServer
  {

    public static void main(String[] args)
      {
        
        
         dataBaseConnector.openDataBase();
        try (ServerSocket groIncServer = new ServerSocket(8165))
          {

            while (true)
              {
                  Socket groIncClient = groIncServer.accept();
                  System.out.println(groIncClient.getInetAddress().toString()+" is connected");

                  Thread muliThread = new Thread(new serverThread(groIncClient));
                  muliThread.start();
             
              }

          } catch (Exception e)
          {
            System.out.println(e+"here");
          }
      }

  }
