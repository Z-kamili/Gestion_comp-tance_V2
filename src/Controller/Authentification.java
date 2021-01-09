package Controller;

import java.awt.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.sun.glass.ui.Window;

import Database.DB_connection;
import application.Apprenant;
import application.Main;
import application.compétance;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Authentification implements Initializable  {
	@FXML   ComboBox<String> comboBox;   
	@FXML   javafx.scene.control.TextField txt_nom_insc;
	@FXML   PasswordField txt_pwd_insc;
	@FXML   javafx.scene.control.TextField txt_age_insc;
	@FXML   javafx.scene.control.TextField txt_email_insc;
	@FXML   javafx.scene.control.TextField username;
	String nom,password,query,email,filier,Role;
	int age;
	List<compétance> cmpt;
	DB_connection db;
	
	@Override
	public void initialize(URL url,ResourceBundle rb) {
		comboBox.getItems().addAll("1 er annee","2 eme annee");
	}
	
	@FXML 
	public void Inscription() {
		
		 db = new DB_connection();
		 cmpt = new ArrayList<compétance>();
		// System.out.println(txt_pwd.getText());
		 if(!txt_nom_insc.getText().equals("") && !txt_pwd_insc.getText().equals("") && !txt_age_insc.getText().equals("") && !txt_email_insc.getText().equals("") && !comboBox.getValue().equals(" ")){
				 query = "select * from competences";
				 cmpt = db.getCompt(query);
				 Role = "Apprenant";
				 Apprenant app = new Apprenant(txt_nom_insc.getText(),txt_email_insc.getText(),Integer.parseInt(txt_age_insc.getText()),comboBox.getValue(),txt_pwd_insc.getText(),Role);
				 
				 try {
					  db.Add_Apprenant(app);
					  db.competance_to_user(cmpt,comboBox.getValue()); 
					  Main.window.close();
					 Parent root = FXMLLoader.load(getClass().getResource("../View/ConsulterApprenant.fxml"));
					 Scene scene = new Scene(root,700,400);
					 Stage primaryStage = new Stage();
					 scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
					 primaryStage.setScene(scene);
					 Main.window = primaryStage;
					 primaryStage.show();
					  
				 }catch (Exception e){
					 
					 System.out.println(e.getMessage());
					 
				 }
			
		}	 
		
		
	}
	
	@FXML
	public void nextScene(){
		

		
	}
	

}
