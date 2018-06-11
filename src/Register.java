//package com.netenrich;
import java.sql.*;
public class Register {
 private String first_name;
 private String last_name;
 private String email_id;
 private String password;
 public Register(String first,String last,String email,String pass){
  this.first_name = first;
  this.last_name = last;
  this.email_id = email;
  this.password = pass;

 }
 public String InsertDetails(){
  String output=null;
  DatabaseDetails main = new DatabaseDetails();
  String database_url = main.Databaseurl();
  String database_username = main.Databaseusername();
  String database_password = main.Databasepassword();
  Databaseconnection db_connection = new Databaseconnection(database_username,database_password,database_url);
  java.sql.Connection connection = db_connection.Access_Database();
  Statement stmnt1 = null;
  try {
   String stmnt = "INSERT INTO register (first_name,last_name,email_id,password) VALUES (?,?,?,?)";
   PreparedStatement ps = connection.prepareStatement(stmnt);
   ps.setString(1, first_name);
   ps.setString(2, last_name);
   ps.setString(3, email_id);
   ps.setString(4, password);
   String query = "SELECT * FROM register WHERE email_id=\""+email_id+"\"";
   stmnt1 = connection.createStatement();
   ResultSet rs = stmnt1.executeQuery(query);
   int count = 0;
   while (rs.next()){
    String user_name = rs.getString("email_id");
    if (user_name.equals(email_id)){
     count = count+1;
    }
   }
   if (count==0){
    int result = ps.executeUpdate();
    if (result==1){
     output = "You are Successfully Registered.";
    }
    else{
     output = "Your Registration Failed.";
    }
   }
   else{
    output= "Email ID is Already Registered.";
   }
  } catch (SQLException e) {
   // TODO Auto-generated catch block
  }
 return output;
 }
 public String checkDetails(){
          String output=null;
          DatabaseDetails main = new DatabaseDetails();
          String database_url = main.Databaseurl();
          String database_username = main.Databaseusername();
          String database_password = main.Databasepassword();
          Databaseconnection db_connection = new Databaseconnection(database_username,database_password,database_url);
          java.sql.Connection connection = db_connection.Access_Database();
          Statement stmnt1 = null;
          try {
           String sql = "SELECT email_id FROM register WHERE email_id=\""+email_id+"\"";
           stmnt1 = connection.createStatement();
           ResultSet rs = stmnt1.executeQuery(sql);
           int count = 0;
           while(rs.next()){
                 //Retrieve by column name
                 String email = rs.getString("email_id");
                 count=count+1;
              }
           if (count>0){
                   output= "Email ID is Already Registered.";
                    }
            else{
             output = "Your can Register.";
            }
          } catch (SQLException e) {
           // TODO Auto-generated catch block
          }
         return output;
         }
}
