/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groincserver;

import Backend_skeleton.Password;
import Backend_skeleton.dataBaseConnector;
import Backend_skeleton.person;
import Backend_skeleton.member;
import Backend_skeleton.request;
import Backend_skeleton.task;
import attributes.email;
import attributes.userNameAndPassword;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.InputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Member;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author shehab
 */
abstract class serverCore
  {

    protected ObjectOutputStream output;
    protected ObjectInputStream input;
    protected Socket ClientSocket;
    protected String ipString;
    protected Object curObject;

    protected void receiveData() throws IOException, ClassNotFoundException
      {

        curObject = input.readObject();

      }

    protected void sendData(Object yourObject) throws IOException
      {

        output.writeObject(yourObject);
        output.flush();
        output.reset();

      }

    protected boolean makeOpreation(userNameAndPassword uPassword)
      {

        if (uPassword.getCommand().equals("USERNAME"))

          {
            return dataBaseConnector.checkUserName(uPassword.getUserName());
          }

        return dataBaseConnector.loginCheck(uPassword.getUserName(), Password.Encrypt(new StringBuilder(uPassword.getPassword())));
      }

    protected boolean makeOpreation(request myRequest) throws IOException
      {

        boolean ans = false;
        switch (myRequest.getCommand())
          {
            case "getWorkSpaceTasks":
              {

                ArrayList<String> myData = dataBaseConnector.getWorkSpaceTasks(myRequest.getWorkSpaceName());

                sendData(myData);
                ans = true;
                break;

              }
            case "getUserWorkSpaces":
              {

                ArrayList<String> myData = dataBaseConnector.getUserWorkSpaces(myRequest.getUserName());

                sendData(myData);
                ans = true;
                break;

              }

            case "getRole":
              {
                ArrayList<String> myData = new ArrayList<>();
                myData.add(dataBaseConnector.getRole(myRequest.getUserName(), myRequest.getWorkSpaceName()));
                sendData(myData);
                ans = true;
                break;
              }
            case "getTaskInfo":
              {
                task myTask = dataBaseConnector.getTaskInfo(myRequest.getWorkSpaceName(), myRequest.getTaskTitle());
                sendData(myTask);
                ans = true;
                break;
              }
            case "addTask":
                return dataBaseConnector.AddTask(myRequest.getWorkSpaceName(), myRequest.getTaskTitle(), myRequest.getDescription(), myRequest.getDeadLine());
            case "addUserToWorkSpace":
                return dataBaseConnector.addUserToWorkSpace(myRequest.getUserName(), myRequest.getWorkSpaceName());
            case "createWorkSpace":
                return dataBaseConnector.createWorkSpace(myRequest.getWorkSpaceName(),myRequest.getUserName());

          }
        return ans;

      }

    protected boolean makeOpreation(person user)

      {
        user.setPassword(Password.Encrypt(new StringBuilder(user.getPassword())));
        return dataBaseConnector.addUserToDataBase(user);
      }

    protected boolean makeOpreation(email mail)
      {
        return dataBaseConnector.emailChecker(mail.getMailString());
      }

    protected Boolean serverWork() throws IOException
      {

        switch (curObject.getClass().getSimpleName())
          {

            case "userNameAndPassword":
                return makeOpreation((userNameAndPassword) curObject);

            case "member":
                return makeOpreation((person) curObject);

            case "email":
                return makeOpreation((email) curObject);
            case "request":
              {

                return makeOpreation((request) curObject);
              }
            // case "task":
            //return makeOpreation((task) curObject));

          }

        return false;

      }

  }
