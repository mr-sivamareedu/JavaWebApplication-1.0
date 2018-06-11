//package com.netenrich;
import java.util.*;
import java.sql.*;
public class FirstApp {
        private static Scanner input;
        public static void main(String args[]) throws SQLException{
                input = new Scanner(System.in);
                System.out.println("1.Register");
                System.out.println("2.Login");
                System.out.println("Enter A Number Corresponding To Your Option:");
                int choice = input.nextInt();
                if (choice == 1){
                        System.out.println("Enter First Name:");
                        String first_name = input.next();
                        System.out.println("Enter Last Name:");
                        String last_name = input.next();
                        System.out.println("Enter Email ID:");
                        String email_id = input.next();
                        System.out.println("Enter Password:");
                        String password = input.next();
                        Register register = new Register(first_name,last_name,email_id,password);
                        String result1 = register.InsertDetails();
                        System.out.println(result1);
        }
                else if (choice==2){
                        System.out.println("Enter UserName:\t");
                        String user_name = input.next();
                        System.out.println("Enter Password:\t");
                        String password = input.next();
                        Login login = new Login(user_name,password);
                        String result2 = login.validate();
                        System.out.println(result2);
                }
                else{
                        System.out.println("No Choice found.");
                }
        }
}
