package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.Apprenant;
import application.User;
import application.compétance;

public class DB_connection{
	private String url;
	private String user = "";
	private String pwd;
	Connection con;
	public  List<Apprenant> users = new ArrayList<Apprenant>();
	public  List<compétance> cmpt = new ArrayList<compétance>();
	
	public DB_connection() {
		
		this.url = "jdbc:mysql://localhost:3306/tree";
		this.user = "root";
		this.pwd = "";
		
		
	}
	
	public void Connection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection(url,user,pwd);
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
	}
	public List<Apprenant> getUsers(String req){
		
		try{  
            Connection();
			java.sql.Statement statement = con.createStatement();
		    ResultSet rs = statement.executeQuery(req);
	        while (rs.next()) {
	            String name = rs.getString("nom");
	            String password = rs.getString("password");
	            Integer age = rs.getInt("age");
	            String prenom = rs.getString("prenom");
	            String Role = rs.getString("Role");
	            int id  = rs.getInt("id");
	            users.add(new Apprenant(id,name,prenom,age,Role,password));
	        }
	        con.close();     
			}catch(Exception e){ 
				
				System.out.println(e);
				
			}
		
		return users;
		
	}
	
	
	public void Gestioncompétance(String query){
		

		
	}
	
	

	
	public void Delete(String deletequery){

		
		
		
		
	}
	
	

	public void Affichage(String req){
		// TODO Auto-generated method stub

	}
	
	

}
