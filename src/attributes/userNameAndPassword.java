package attributes;

import java.io.Serializable;

/**
 *
 * @author shehab
 */
public class userNameAndPassword implements Serializable
  {

    private static final long serialVersionUID = 1L;
    private String userName, password;
    private String command;

    public userNameAndPassword(String userName, String password)
      {
        this.userName = userName;
        this.password = password;
      }

    public String getPassword()
      {
        return password;
      }

    public String getUserName()
      {
        return userName;
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
