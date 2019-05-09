/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;

import java.io.IOException;
import java.sql.*;
import java.sql.CallableStatement;
import javax.imageio.IIOException;
import attributes.*;
import com.mysql.cj.Session;
import java.util.ArrayList;

public class dataBaseConnector
  {

    private static Connection myConnection;

    public static void closeDataBase()

      {
        try
          {
            myConnection.close();
          } catch (Exception e)
          {
            System.out.println(e);
          }

      }

    public static void openDataBase()
      {

        try
          {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://groinc.cofcwbekphsc.us-east-1.rds.amazonaws.com:3306/groincdatabase", "groinc", "groincisthebest");

          } catch (Exception e)
          {
            System.out.println(e);
          }

      }

    public static boolean addUserToDataBase(person myUser)
      {

        try
          {
            CallableStatement myCallableStatement = myConnection.prepareCall("{call insertUser(?,?,?,?,?,?,?,?)}");
            myCallableStatement.setString(1, myUser.getFullName().getNaString());
            myCallableStatement.setString(2, myUser.getFullName().getLaString());
            myCallableStatement.setString(3, myUser.getPhoneNumber1().getpString());
            myCallableStatement.setString(4, myUser.getMail().getMailString());
            myCallableStatement.setString(5, myUser.getPassword());
            myCallableStatement.setString(6, myUser.getBirthDate());
            myCallableStatement.setString(7, myUser.getGender());
            myCallableStatement.setString(8, myUser.getUserName());
            myCallableStatement.execute();

            return true;

          } catch (Exception e)
          {

            System.out.println(e);
            return false;
          }

      }

    public static boolean loginCheck(String userString, String passString)
      {
        //  openDataBase();
        try
          {

            // dataBaseConnector.openDataBase();
            CallableStatement myStatement = myConnection.prepareCall("{call logIN(?,?)}");

            myStatement.setString(1, userString);
            myStatement.setString(2, passString);

            ResultSet answser = myStatement.executeQuery();

            String ok = "false";
            while (answser.next())
              {
                ok = answser.getString(1);
              }

            //  myConnection.close();
            //  closeDataBase();
            return (ok.equals("true")) ? true : false;

          } catch (Exception e)
          {
            System.out.println(e);
          }

        return false;
      }

    public static boolean checkUserName(String userNameString)
      {

        try
          {

            CallableStatement myCallableStatement = myConnection.prepareCall("{call checkUserName(?)}");
            myCallableStatement.setString(1, userNameString);

            ResultSet rs = myCallableStatement.executeQuery();

            String ans = "false";
            while (rs.next())
              {
                ans = rs.getString(1);
              }

            return (ans.equals("true")) ? true : false;

          } catch (Exception e)
          {
            System.out.println(e);
          }
        return false;
      }

    public static boolean phoneNumberChecker(String phoneNumberString)
      {

        try
          {

            CallableStatement myCallableStatement = myConnection.prepareCall("{call phoneNumberChecker(?)}");
            myCallableStatement.setString(1, phoneNumberString);

            ResultSet rs = myCallableStatement.executeQuery();

            String ans = "false";
            while (rs.next())
              {
                ans = rs.getString(1);
              }

            return (ans.equals("true")) ? true : false;

          } catch (Exception e)
          {
            System.out.println(e);
          }
        return false;
      }

    public static boolean emailChecker(String emailString)
      {

        try
          {

            CallableStatement myCallableStatement = myConnection.prepareCall("{call emailChecker(?)}");
            myCallableStatement.setString(1, emailString);

            ResultSet rs = myCallableStatement.executeQuery();

            String ans = "false";
            while (rs.next())
              {
                ans = rs.getString(1);
              }

            return (ans.equals("true")) ? true : false;

          } catch (Exception e)
          {
            System.out.println(e + " hena");
          }
        return false;
      }

    public static ArrayList<String> getWorkSpaceTasks(String workSpaceName)
      {

        try
          {
            CallableStatement myCallableStatement = myConnection.prepareCall("{call GetWorkSpaceTasks(?)}");
            myCallableStatement.setString(1, workSpaceName);

            ResultSet rs = myCallableStatement.executeQuery();
            ArrayList<String> tasksTitles = new ArrayList<String>();

            while (rs.next())
              {
                tasksTitles.add(rs.getString(1));
              }
            return tasksTitles;

          } catch (Exception e)
          {
            System.out.println(e + " hena");
          }

        return null;

      }

    public static ArrayList<String> getUserWorkSpaces(String userName)
      {

        try
          {
            CallableStatement myCallableStatement = myConnection.prepareCall("{call GetUserWorkSpaces(?)}");
            myCallableStatement.setString(1, userName);
            ResultSet rs = myCallableStatement.executeQuery();
            ArrayList<String> workSpaces = new ArrayList<String>();

            while (rs.next())
              {
                System.out.println(rs.getString(1));
                workSpaces.add(rs.getString(1));
              }
            return workSpaces;
          } catch (Exception e)
          {
            System.out.println(e + " hena");

          }
        return null;
      }

    public static String getRole(String userName, String workSpaceName)
      {
        try
          {
            CallableStatement myCallableStatement = myConnection.prepareCall("{call getRole(?,?)}");
            myCallableStatement.setString(1, userName);
            myCallableStatement.setString(2, userName);
            ResultSet rs = myCallableStatement.executeQuery();

            while (rs.next())
              {
                return rs.getString(1);
              }

          } catch (Exception e)
          {
            System.out.println(e);

          }
        return null;

      }

    public static task getTaskInfo(String workSpaceName, String taskTitle)
      {

        try
          {
            CallableStatement myCallableStatement = myConnection.prepareCall("{call GetTaskInfo(?,?)}");
            myCallableStatement.setString(1, workSpaceName);
            myCallableStatement.setString(2, taskTitle);
            ResultSet rs = myCallableStatement.executeQuery();

            task temp = new task();
            date myDate;

            while (rs.next())
              {
                temp.setTitle(rs.getString(2));
                temp.setDescription(rs.getString(3));
                temp.setDeadLine(rs.getString(5));
                temp.setWorkSpaceName(workSpaceName);
                temp.setStatus(rs.getString(4));

              }
            return temp;

          } catch (Exception e)
          {
            System.out.println(e);

          }
        return null;
      }

    public static boolean AddTask(String workSpaceName, String TaskName, String TaskDescription, String deadLine)

      {

        try
          {
            CallableStatement myCallableStatement = myConnection.prepareCall("{call AddTask(?,?,?,?)}");
            myCallableStatement.setString(1, workSpaceName);
            myCallableStatement.setString(2, TaskName);
            myCallableStatement.setString(3, TaskDescription);
            myCallableStatement.setString(4, deadLine);

            ResultSet rs = myCallableStatement.executeQuery();

            String ans = "false";
            while (rs.next())
              {
                ans = rs.getString(1);
              }

            return (ans.equals("true")) ? true : false;

          } catch (Exception e)
          {
            System.out.println(e);

          }
        return false;

      }

    public static boolean AssignTaskToUser(String workSpaceName, String taskName, String deadLine)
      {
        try
          {
            CallableStatement myCallableStatement = myConnection.prepareCall("{call AssignTaskToUser(?,?,?)}");
            myCallableStatement.setString(1, workSpaceName);
            myCallableStatement.setString(2, taskName);
            myCallableStatement.setString(3, deadLine);
            ResultSet rs = myCallableStatement.executeQuery();

            String ans = "false";
            while (rs.next())
              {
                ans = rs.getString(1);
              }

            return (ans.equals("true")) ? true : false;

          } catch (Exception e)
          {
            System.out.println(e);

          }
        return false;
      }

    public static boolean addUserToWorkSpace(String userName, String workSpace)
      {
        try
          {
            CallableStatement myCallableStatement = myConnection.prepareCall("{call addUserToWorkspace(?,?)}");
            myCallableStatement.setString(1, userName);
            myCallableStatement.setString(2, workSpace);

            ResultSet rs = myCallableStatement.executeQuery();

            String ans = "false";
            while (rs.next())
              {
                ans = rs.getString(1);
              }

            return (ans.equals("true")) ? true : false;

          } catch (Exception e)
          {
            System.out.println(e);

          }
        return false;
      }

    public static int getId(String userName)
      {
        try
          {

            CallableStatement myCallableStatement = myConnection.prepareCall("{call getId(?)}");
            myCallableStatement.setString(1, userName);

            ResultSet rs = myCallableStatement.executeQuery();

            int s = 0;

            String ans = "false";
            while (rs.next())
              {
                return rs.getInt(1);
              }
          } catch (Exception e)
          {
            System.out.println(e);

          }
        return 0;

      }

    public static boolean createWorkSpace(String workSpace, String name)
      {

        try
          {
            CallableStatement myCallableStatement2 = myConnection.prepareCall("{call createWorkSpace(?,?)}");
            myCallableStatement2.setString(1, workSpace);
            myCallableStatement2.setInt(2, getId(name));

            ResultSet rss = myCallableStatement2.executeQuery();
            String ans = "false";
            while (rss.next())
              {
                ans = rss.getString(1);
              }

            return (ans.equals("true")) ? true : false;
          } catch (Exception e)
          {
          }

        return false;
      }

    public static void main(String[] args)
      {
        dataBaseConnector.openDataBase();

        createWorkSpace("ayHaga", "Amir");

      }
  }
