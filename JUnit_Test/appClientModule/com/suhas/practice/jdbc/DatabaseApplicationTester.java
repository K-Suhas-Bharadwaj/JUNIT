package com.suhas.practice.jdbc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class DatabaseApplicationTester {
	
   //@InjectMocks annotation is used to create and inject the mock object
   @InjectMocks 
   DatabaseApplication databaseApplication = new DatabaseApplication();

   //@Mock annotation is used to create the mock object to be injected
   @Mock
   Database database;

   @Test
   public void testAdd() throws SQLException{
	   
	   Scanner scan = new Scanner(System.in);
	   int user_id = scan.nextInt();
	   String user_password = scan.next();
	   
      //add the behavior of database to identify successfull login
      when(database.isLoginSuccessfull(user_id, user_password)).thenReturn(databaseApplication.isLoginSuccessfull(user_id, user_password));
		
      //test the isLoginSuccessfull() functionality
      Assert.assertEquals(database.isLoginSuccessfull(user_id, user_password),databaseApplication.isLoginSuccessfull(user_id, user_password));
       
      //verify the behavior
      verify(database).isLoginSuccessfull(user_id, user_password);
      
      scan.close();
      
   }
   
}
