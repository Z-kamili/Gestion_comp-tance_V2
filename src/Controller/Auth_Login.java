package Controller;

import java.util.ArrayList;
import java.util.List;

import Database.DB_connection;
import application.Apprenant;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Auth_Login {
	@FXML   javafx.scene.control.TextField txt_nom;
	@FXML   PasswordField txt_pwd;
	@FXML   javafx.scene.control.TextField txt_age;
	@FXML   javafx.scene.control.TextField username;
	private DB_connection db;
	private boolean etats = false;
	private String  Role;
	@FXML 
	public void  Login(){
		
		Main.window.close();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../View/Inscription.fxml"));
			Scene scene = new Scene(root,700,600);
			Stage primaryStage = new Stage();
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			Main.window = primaryStage;
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	 @FXML 
	 public void Test() {
		 db = new DB_connection();
		 String nom,password,query;
		 List<Apprenant> users = new ArrayList<Apprenant>();
		// System.out.println(txt_pwd.getText());
		 if(!txt_nom.getText().equals("") && !txt_pwd.getText().equals("")){
			Main.nom_session = txt_nom.getText();
			 nom = txt_nom.getText();
			 password = txt_pwd.getText();
			 query = "select * from User";
		     users = db.getUsers(query);
             
		for(int i=0;i<users.size();i++) {
			
			if(users.get(i).getPrenom().equals(nom) && users.get(i).getPassword().equals(password)){
				this.etats = true;
				System.out.println("hello");
				Role = users.get(i).getRole();
				Main.nom_session =  users.get(i).getPrenom();
				Main.Promo = users.get(i).getFiliaire();
				System.out.println(Main.Promo);
				break;
			}
			
		}	 
		 }else {
			 
			 //erreur
			 
		 }
		 
		if(this.etats == true && Role.equals("Apprenant")){
			Main.window.close();
			
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../View/ConsulterApprenant.fxml"));
				Scene scene = new Scene(root,700,400);
				Stage primaryStage = new Stage();
				scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				Main.window = primaryStage;
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(this.etats == true && Role.equals("Staf")){
			Main.window.close();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../View/ViewCompetance.fxml"));
				Scene scene = new Scene(root,700,400);
				Stage primaryStage = new Stage();
				scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				Main.window = primaryStage;
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		 
		 
	 }
	
	
}



