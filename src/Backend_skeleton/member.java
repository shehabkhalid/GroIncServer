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
public class member extends person implements Serializable
  {

     private static final long serialVersionUID = 5L;
    
    private member(){}
     
    public static class Builder{
     name Builderfullname;
     phoneNumber Builderphone;
     email Buildermail;
     String Buildergender;
     String BuilderBirthdate;
     String Builderpassword;
     String Builderusername;
     public Builder(name fullName){
     this.Builderfullname=fullName;
     }
     public Builder setBuilderphone(phoneNumber phone){
      this.Builderphone=phone;
      return this;
     }
     public Builder setBuildermail(email mail){
     this.Buildermail=mail;
     return this;
     }
     public Builder setBuildergender(String gender){
     this.Buildergender=gender;
     return this;
     }
     public Builder setBuilderbirthdate(String date){
     this.BuilderBirthdate=date;
     return this;
     }
     public Builder setBuilderpassword(String pass){
     this.Builderpassword=pass;
     return this;
     }
     public Builder setBuilderusername(String user){
     this.Builderusername=user;
     return this;
     } 
     public member build(){
      member m=new member();
      m.fullName=Builderfullname;
      m.phoneNumber1=Builderphone;
      m.gender=Buildergender;
      m.mail=Buildermail;
      m.birthDate=BuilderBirthdate;
      m.password=Builderpassword;
      m.userName=Builderusername;
      return m;
     }
     
    }
    
  }
