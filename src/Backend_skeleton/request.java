/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend_skeleton;
import java.io.Serializable;

/**
 *
 * @author shehab
 */
public class request implements Serializable
  {
    
     private static final long serialVersionUID = 122L;
    private String command;
    private String WorkSpaceName;
    private String userName;
    private String role;
    private String taskTitle;
    private String deadLine;
    private String description;

    public void setDescription(String description)
      {
        this.description = description;
      }

    public String getDescription()
      {
        return description;
      }
    
    

    public void setDeadLine(String deadLine)
      {
        this.deadLine = deadLine;
      }

    public String getDeadLine()
      {
        return deadLine;
      }
    
    

    public void setTaskTitle(String taskTitle)
      {
        this.taskTitle = taskTitle;
      }

    public String getTaskTitle()
      {
        return taskTitle;
      }
    

    public void setRole(String role)
      {
        this.role = role;
      }

    public String getRole()
      {
        return role;
      }
    
    

    public void setUserName(String userName)
      {
        this.userName = userName;
      }

    public String getUserName()
      {
        return userName;
      }
    

    public void setWorkSpaceName(String WorkSpaceName)
      {
        this.WorkSpaceName = WorkSpaceName;
      }

    
    public String getWorkSpaceName()
      {
        return WorkSpaceName;
      }

    
    public String getCommand()
      {
        return command;
      }

    public void setCommand(String command)
      {
        this.command = command;
      }
    
    
  }
