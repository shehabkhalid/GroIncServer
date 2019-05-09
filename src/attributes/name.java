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
public class name implements Serializable
  {

     private static final long serialVersionUID = 4L;
    private String naString = new String(""), laString = new String("");

    
  
    public name(String naString, String laString)
      {
        this.naString = naString;
        this.laString = laString;
        format();
      }

    public name()
      {
      }

    public String getLaString()
      {
        return laString;
      }

    public String getNaString()
      {
        return naString;
      }

    public void setLaString(String laString)
      {
        this.laString = new String(laString);
       // format();
      }

    public void setNaString(String naString)
      {
        this.naString = new String(naString);
       // format();
      }

    public static boolean isNameValid(String naString, String LaNString)
      {
        return (naString.length() >= 2 && LaNString.length() >= 2) ? true : false;
      }

    private void format()
      {

        char[] temp = naString.toCharArray();
        for (int i = 0; i < naString.length(); i++)
          {
            temp[i] = (i == 0) ? Character.toUpperCase(temp[i]) : Character.toLowerCase(temp[i]);
              
          }
        naString = new String(temp);
        temp = laString.toCharArray();
        
        for (int i = 0; i < laString.length(); i++)
          {
            temp[i] = (i == 0) ? Character.toUpperCase(temp[i]) : Character.toLowerCase(temp[i]);
          }
        laString = new String(temp);
      }
  }
