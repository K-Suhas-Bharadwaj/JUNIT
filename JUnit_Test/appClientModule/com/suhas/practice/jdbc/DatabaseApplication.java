package com.suhas.practice.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseApplication {
	
	private Database database;
	
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	public boolean isLoginSuccessfull(int user_id, String user_password) throws SQLException {
		
		Connection connection = Connector.getConnection();
		
		String sql = "SELECT user_password FROM users WHERE user_id=?";
		
		PreparedStatement executor = connection.prepareStatement(sql);
		
		executor.setInt(1, user_id);
		
		ResultSet user = executor.executeQuery();
		
		if(user.next())
			return user_password.equals(user.getString(1));
		else
			return false;
		
	}
	
}
