package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import application.Apprenant;
import application.User;
import application.compétance;

public class DB_connection{
	private String url;
	private String user = "";
	private String pwd;
	Connection con;
	int id = 0 ;
	public  List<Apprenant> users;
	public  List<compétance> cmpt;
	
	public DB_connection() {
		
		this.url = "jdbc:mysql://localhost:3306/tree";
		this.user = "root";
		this.pwd = "";
		
		users = new ArrayList<Apprenant>();
		cmpt = new ArrayList<compétance>();
		
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
	            String email = rs.getString("email");
	            String Filiaire = rs.getString("Promo");
	            String Role = rs.getString("Role");
	            int id  = rs.getInt("id");
	            users.add(new Apprenant(id,name,email,age,Filiaire,password,Role));
	        }
	        con.close();     
			}catch(Exception e){ 
				
				System.out.println(e);
				
			}
		
		return users;
		
	}
	
	
	
	public List<compétance> getCompt(String req){
		
		try{  
            Connection();
			java.sql.Statement statement = con.createStatement();
		    ResultSet rs = statement.executeQuery(req);
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String Filiere = rs.getString("filiere");
	            cmpt.add(new compétance(id,title,Filiere));
	        }
	        con.close();     
			}catch(Exception e){ 
				
				System.out.println(e);
				
			}
		
		return cmpt;
		
	}
	
	public void Add_Apprenant(Apprenant app) throws SQLException{
		
		Connection();
		
		String RequeteAjout = "INSERT INTO `user`(`nom`, `Email`, `age`, `Promo`, `Role`, `password`) VALUES (?,?,?,?,?,?)";
        java.sql.PreparedStatement PreparedStmt = con.prepareStatement(RequeteAjout);
        PreparedStmt.setString(1,app.getNom());
        PreparedStmt.setString(2,app.getPrenom());
        PreparedStmt.setInt(3,app.getAge());
        PreparedStmt.setString(4,app.getFiliaire());
        PreparedStmt.setString(5,app.getRole());
        PreparedStmt.setString(6,app.getPassword());
        PreparedStmt.executeUpdate();
        con.close();
		
	}
	
	public void competance_to_user(List<compétance> cmpt) throws SQLException{
		
		Connection();
		
		   String query = "SELECT id from user where Role = \"Apprenant\" order by id DESC LIMIT 1 ";
			java.sql.Statement statement = con.createStatement();
		    ResultSet rs = statement.executeQuery(query);
		    while (rs.next()) {
	             id = rs.getInt("id");
	        }
			for(int i=0;i<cmpt.size();i++) {
				
				String RequeteAjout = "INSERT INTO `user_compétance`(`id_user`, `id_com`, `N1`, `N2`, `N3`) VALUES (?,?,?,?,?)";
		        java.sql.PreparedStatement PreparedStmt = con.prepareStatement(RequeteAjout);
		   
		        PreparedStmt.setInt(1,id);
		        PreparedStmt.setInt(2,cmpt.get(i).getId());
		        PreparedStmt.setBoolean(3,false);
		        PreparedStmt.setBoolean(4,false);
		        PreparedStmt.setBoolean(5,false);
		        PreparedStmt.executeUpdate();
				
			}
		
        con.close();
		
	}
	
	
	public void Gestioncompétance(String query){
		

		
	}
	
	

	
	public void Delete(String deletequery){

		
		
		
		
	}
	
	

	public void Affichage(String req){
		// TODO Auto-generated method stub

	}
	
	

}
