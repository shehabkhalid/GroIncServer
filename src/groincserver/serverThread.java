/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groincserver;

import Backend_skeleton.member;
import Backend_skeleton.person;
import attributes.userNameAndPassword;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shehab
 */
public class serverThread extends serverCore implements Runnable
  {

    private Socket ClientSocket;

    public serverThread(Socket socket) throws IOException
      {
        ClientSocket = socket;

      }

    @Override
    public void run()
      {

        try
          {

            output = new ObjectOutputStream(ClientSocket.getOutputStream());
            input = new ObjectInputStream(ClientSocket.getInputStream());
            curObject = null;
            while (true)
              {
               
                receiveData();
                boolean x = serverWork();
                System.out.println(x);
                String ans = x ? "true" : "false";
                sendData(ans);
               
              

              }
          } catch (Exception e)  
          {

              try
                {
                  ClientSocket.close();
                  
                } catch (Exception s)
                  {}
               
           
            System.out.println(e + " ServerThread");
          }

      }

  }
