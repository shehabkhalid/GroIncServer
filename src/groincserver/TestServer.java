/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groincserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import jdk.nashorn.internal.ir.TryNode;

/**
 *
 * @author shehab
 */
public class TestServer
  {

    public static void main(String[] args)
      {
        try (ServerSocket s = new ServerSocket(8888))
          {
            while (true)
              {
                Socket groIncClient = s.accept();
                System.out.println(groIncClient.getInetAddress().toString() + " is connected");

                Thread muliThread = new Thread(new serverTestThread(groIncClient));
                muliThread.start();

              }

          } catch (Exception e)
          {
          }
      }

  }

class serverTestThread implements Runnable
  {

    private Socket cSocket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public serverTestThread(Socket csSocket)
      {
        this.cSocket = csSocket;
      }

    @Override
    public void run()
      {
        try
          {
            output = new ObjectOutputStream(cSocket.getOutputStream());
            input = new ObjectInputStream(cSocket.getInputStream());

            String a = " asdasdasd ";
            

            while (true)
              {
                a = (String) input.readObject();
                System.out.println(a);
                  output.writeObject(a);
                if(a.equals("SHIT"))
                    break;
              }
           

          } catch (Exception e)
          {
              System.out.println(e);
          }

      }

  }
