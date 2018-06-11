//package com.netenrich;

import java.sql.*;

public class Login {
        private String user_name;
        private String password;
        public Login(String user,String pass){
                this.user_name = user;
                this.password = pass;
        }
        public String validate(){
                String output="";
                DatabaseDetails main = new DatabaseDetails();
                String database_url = main.Databaseurl();
                String database_username = main.Databaseusername();
                String database_password = main.Databasepassword();
                Databaseconnection db_connection = new Databaseconnection(database_username,database_password,database_url);
                java.sql.Connection connection = db_connection.Access_Database();
                String query = "SELECT * FROM register WHERE email_id=\""+user_name+"\" && password=\""+password+"\"";
                try {
                        Statement stmnt = connection.createStatement();
                        ResultSet rs = stmnt.executeQuery(query);
                        int count=0;
                        while (rs.next()){
                                count = count+1;
                        }
                        if (count>0){
                                output = "You are logged in.";
                        }
                        else{
                                output = "Login Failed.";
                        }
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                return output;
        }
}
