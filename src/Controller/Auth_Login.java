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
	@FXML 
	public void  Login(){
		
		Main.window.close();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../View/Inscription.fxml"));
			Scene scene = new Scene(root,700,400);
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
			 nom = txt_nom.getText();
			 password = txt_pwd.getText();
			 query = "select * from User";
		     users = db.getUsers(query);
		    // System.out.println("hello");
		//System.out.println(users.size());
		for(int i=0;i<users.size();i++) {
			System.out.println(password + "" + users.get(i).getPassword().equals(password));
			if(users.get(i).getNom().equals(nom) && users.get(i).getPassword().equals(password)){
				this.etats = true;
				break;
				
			}
			
		}	 
		 }else {
			 
			 //erreur
			 
		 }
		 
		if(this.etats == true) {
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
			
		}else {
			
			//erreur
			
		}
		 
		 
	 }
	
	
}



