package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class userdao {
	
	public static Connection getconnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devops_bd?characterEncoding=utf8","root","");
		}catch( Exception e)
		{
			System.out.println(e);
		}
		
		return connection;
	}
	
	public static int insertUser(User user) {
		int status = 0;
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into user (email,password,role) values (?,?,?)" );
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static void updateUser(User user) {
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update user set  email=?, password=?,role=?,where iduser =? " );
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			ps.setInt(4, user.getIduser());
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void deleteUser(int id) {
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" delete from user where iduser = ?" );
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static User getbyid(int id) {
		
		User user = new User();
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from user where iduser = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user.setIduser(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return user;
	}
	
	public static List<User> getAllUser(){
		
		List<User> liste = new ArrayList<User>();
		
	try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from user" );
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setIduser(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				
				liste.add(user);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	
	
	public static User getMedecinBylogin(String login,String password) {
		
		Connection con = userdao.getconnection();
		User user = null;
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(" select * from user where email = ?  and password = ? " );
			
			ps.setString(1, login);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			User user1 = new User();
			if(rs.next()) {
				
				user1.setIduser(rs.getInt(1));
				user1.setEmail(rs.getString(2));
				user1.setPassword(rs.getString(3));
				user1.setRole(rs.getString(4));			
				
				user = user1;
				con.close();
				return user1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
}
