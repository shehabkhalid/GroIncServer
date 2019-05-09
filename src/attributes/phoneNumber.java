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
public class phoneNumber implements Serializable
        
  {
 private static final long serialVersionUID = 2L;
    private String pString = new String("");

    public phoneNumber()
      {
      }

    public phoneNumber(String phoneString)
      {
        pString = phoneString;
      }

    public void setpString(String pString)
      {
        this.pString = pString;
      }

    public String getpString()
      {
        return pString;
      }

    public static boolean isValid(String phone)
      {
       
        for(char i : phone.toCharArray())
            if(Character.isAlphabetic(i))
                return false;
            
        return (phone.length() == 11 && (phone.charAt(0) == '0' && phone.charAt(1) == '1'
                && (phone.charAt(2) == '1' || phone.charAt(2) == '2' || phone.charAt(2) == '0'
                || phone.charAt(2) == '5')))
                        ? true : false;
      }
   
  }
