/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributes;

import java.io.Serializable;

/**
 *
 * @author shehab
 */
public class email implements Serializable
  {
    
     private static final long serialVersionUID = 6L;

    private String mailString;

    public void setMailString(String mailString)
      {
        this.mailString = mailString;
      }

    public String getMailString()
      {
        return mailString;
      }
    //two functions validIfonline , validIfOffline

  }


