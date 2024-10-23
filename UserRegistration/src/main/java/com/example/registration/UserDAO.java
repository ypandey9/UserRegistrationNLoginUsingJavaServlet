// src/com/example/registration/UserDAO.java
package com.example.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	public boolean registerUser(User user) {
		boolean isRegistered = false;

		try {
			// Database connection setup
			String jdbcURL = "jdbc:mysql://localhost:3306/userdb";
			String dbUser = "root"; // change to your MySQL user
			String dbPassword = "Admin_2008"; // change to your MySQL password

			Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

			// Insert query
			String sql = "INSERT INTO users (fullname, username, password, email) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getFullName());
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());

			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				isRegistered = true;
			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isRegistered;
	}

	// Method to validate user by email or username and password
	public User validateUser(String emailOrUsername, String password) {
		User user = null;
		String query = "SELECT * FROM users WHERE (email = ? OR username = ?) AND password = ?";

		String jdbcURL = "jdbc:mysql://localhost:3306/userdb";
		String dbUser = "root"; // change to your MySQL user
		String dbPassword = "Admin_2008"; // change to your MySQL password

		try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			// Set parameters
			preparedStatement.setString(1, emailOrUsername);
			preparedStatement.setString(2, emailOrUsername);
			preparedStatement.setString(3, password);

			// Execute query
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = new User();
				//user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setUserName(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user; // Return user object if found, otherwise null
	}
}
