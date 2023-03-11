package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Ticket;

public class ticketdao {

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
	
	public static int insertticket(Ticket ticket) {
		int status = 0;
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into ticket (titre,description,departement,etat) values (?,?,?,?)" );
			ps.setString(1, ticket.getTitre());
			ps.setString(2, ticket.getDescription());
			ps.setString(3, ticket.getDepartement());
			String vetat = "recu"; 
			ps.setString(4,vetat );
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static void update(Ticket ticket) {
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update ticket set  etat=? where idticket =? " );
			ps.setString(1, ticket.getEtat());

			ps.setInt(2, ticket.getIdticket());
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void delete(int id) {
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" delete from ticket where idticket = ?" );
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static Ticket getbyid(int id) {
		
		Ticket ticket = new Ticket();
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from ticket where idticket = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ticket.setIdticket(rs.getInt(1));
				ticket.setTitre(rs.getString(2));
				ticket.setDescription(rs.getString(3));
				ticket.setDepartement(rs.getString(4));
				ticket.setEtat(rs.getString(5));
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return ticket;
	}
	
	public static List<Ticket> getAll(){
		
		List<Ticket> liste = new ArrayList<Ticket>();
		
	try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from Ticket" );
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setIdticket(rs.getInt(1));
				ticket.setTitre(rs.getString(2));
				ticket.setDescription(rs.getString(3));
				ticket.setDepartement(rs.getString(4));
				ticket.setEtat(rs.getString(5));
				liste.add(ticket);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	
	public static void encours(int id) {
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update ticket set  etat=? where idticket =? " );
			String vetat = "en cours";
			ps.setString(1, vetat);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
    public static void attente(int id) {
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update ticket set  etat=? where idticket =? " );
			String vetat = "en attente";
			ps.setString(1, vetat);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	}
    
    public static void nepastraiter(int id) {
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update ticket set  etat=? where idticket =? " );
			String vetat = "ne pas traiter";
			ps.setString(1, vetat);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}

	}
    
    public static void termine(int id) {
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update ticket set  etat=? where idticket =? " );
			String vetat = "termine";
			ps.setString(1, vetat);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
    
    public static void cloture(int id) {
		
		try {
			
			Connection con = ticketdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update ticket set  etat=? where idticket =? " );
			String vetat = "cloture";
			ps.setString(1, vetat);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
    
    
}
