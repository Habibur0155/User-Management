package com.xadmin.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xadmin.usermanagement.bean.User;

public class UserDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=flase";
	private String jdbcUsername = "root";
	private String jdbcPassword = "habib";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_USERS_SQL = "insert into users" + " (name, email, country) values " + " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id, name, email, country from users where id = ?;";
	private static final String SELECT_AL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ?, country = ? where id = ?;";
	
	public UserDao() {
		super();
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	// insert
	
	public void insertUser(User user) {
		System.out.println(INSERT_USERS_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			
			System.out.println(preparedStatement);
			preparedStatement.execute();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				
			}
		}
	}
	
	// select user
}
