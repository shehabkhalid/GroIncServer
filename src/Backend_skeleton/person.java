/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;
import attributes.*;
import java.io.Serializable;


/**
 *
 * @author shehab
 */
public abstract class person implements Serializable
  {

   private static final long serialVersionUID = 3L;

    
    protected name fullName;
    protected email mail;
    protected String gender;
    protected  String birthDate;
    protected String password,userName;
    protected phoneNumber phoneNumber1;
    protected String command;

    public String getBirthDate()
      {
        return birthDate;
      }

    public void setPassword(String password)
      {
        this.password = password;
      }

    
    public name getFullName()
      {
        return fullName;
      }

    public String getGender()
      {
        return gender;
      }

    public email getMail()
      {
        return mail;
      }

    public String getPassword()
      {
        return password;
      }

    public String getUserName()
      {
        return userName;
      }

    public phoneNumber getPhoneNumber1()
      {
        return phoneNumber1;
      }

    public void setCommand(String command)
      {
        this.command = command;
      }

    public String getCommand()
      {
        return command;
      }

    
    
    
 
   

  }
