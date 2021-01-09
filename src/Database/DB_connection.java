package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import application.Apprenant;
import application.Gestion_user_competance;
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
	public List<Gestion_user_competance> G_cmp;
	
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
		 System.out.println("entree_2");
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
	
	public List<Gestion_user_competance> getuser_comp(String req,String name){
		    String sql = req;
		    G_cmp = new ArrayList<Gestion_user_competance>();
			Connection();
		    try{
		    	 java.sql.PreparedStatement prestmt = con.prepareStatement(req);
		    	 prestmt.setString(1,name);
			     ResultSet rs = prestmt.executeQuery();
			     while (rs.next()) {
			    	 G_cmp.add(new Gestion_user_competance(rs.getInt("id_user"),rs.getInt("id_com"),rs.getBoolean("N1"),rs.getBoolean("N2"),rs.getBoolean("N3"),rs.getString("title")));
			        }
			     con.close();  
		    }catch(Exception e){
		    	System.out.println(e.getMessage());	
		    }
		     
		    	return G_cmp;
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
	
	public void competance_to_user(List<compétance> cmpt,String Promo) throws SQLException{
		
		Connection();
		
		   String query = "SELECT id from user where Role = \"Apprenant\" order by id DESC LIMIT 1 ";
			java.sql.Statement statement = con.createStatement();
		    ResultSet rs = statement.executeQuery(query);
		    while (rs.next()) {
	             id = rs.getInt("id");
	        }
		    
			if(Promo.equals("1 er annee")) {
				for(int i=0;i<cmpt.size();i++) {
					
					if(cmpt.get(i).getId()>=1 && cmpt.get(i).getId()<=8) {
						String RequeteAjout = "INSERT INTO `user_compétance`(`id_user`, `id_com`, `N1`, `N2`, `N3`) VALUES (?,?,?,?,?)";
				        java.sql.PreparedStatement PreparedStmt = con.prepareStatement(RequeteAjout);
				        PreparedStmt.setInt(1,id);
				        PreparedStmt.setInt(2,cmpt.get(i).getId());
				        PreparedStmt.setBoolean(3,false);
				        PreparedStmt.setBoolean(4,false);
				        PreparedStmt.setBoolean(5,false);
				        PreparedStmt.executeUpdate();
					}
					
					
				}
				
			}else if(Promo.equals("2 eme annee")){
				
               for(int i=0;i<cmpt.size();i++) {
            	   
            	   if(cmpt.get(i).getId()>=1 && cmpt.get(i).getId()<=8) {
						String RequeteAjout = "INSERT INTO `user_compétance`(`id_user`, `id_com`, `N1`, `N2`, `N3`) VALUES (?,?,?,?,?)";
				        java.sql.PreparedStatement PreparedStmt = con.prepareStatement(RequeteAjout);
				        PreparedStmt.setInt(1,id);
				        PreparedStmt.setInt(2,cmpt.get(i).getId());
				        PreparedStmt.setBoolean(3,true);
				        PreparedStmt.setBoolean(4,true);
				        PreparedStmt.setBoolean(5,true);
				        PreparedStmt.executeUpdate();
					}else {
						
						String RequeteAjout = "INSERT INTO `user_compétance`(`id_user`, `id_com`, `N1`, `N2`, `N3`) VALUES (?,?,?,?,?)";
				        java.sql.PreparedStatement PreparedStmt = con.prepareStatement(RequeteAjout);
				        PreparedStmt.setInt(1,id);
				        PreparedStmt.setInt(2,cmpt.get(i).getId());
				        PreparedStmt.setBoolean(3,false);
				        PreparedStmt.setBoolean(4,false);
				        PreparedStmt.setBoolean(5,false);
				        PreparedStmt.executeUpdate();
						
					}

					
				}
				
				
			}
			
		
        con.close();
		
	}
	
	
	public void Gestioncompétance(String query,String name,boolean N1,boolean N2,boolean N3,int id){
		
		    String sql = query;
		    System.out.println(id);
			Connection();
		    try{
		    	 java.sql.PreparedStatement prestmt = con.prepareStatement(sql);
		    	 prestmt.setBoolean(1, N1);
		    	 prestmt.setBoolean(2, N2);
		    	 prestmt.setBoolean(3, N3);
		    	 prestmt.setInt(4,id);
		    	 prestmt.setString(5,name);
			     int rs = prestmt.executeUpdate();
			     System.out.println(rs);
			     con.close();  
		    }catch(Exception e){
		    	System.out.println(e.getMessage());	
		    }
		
	}
	
	

	
	public void Delete(String deletequery){

		
		
		
		
	}
	
	

	public void Affichage(String req){
		// TODO Auto-generated method stub

	}
	
	

}
