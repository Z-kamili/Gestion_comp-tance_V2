package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Database.DB_connection;
import application.Apprenant;
import application.Gestion_user_competance;
import application.Main;
import application.User;
import application.compétance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewCompetances implements Initializable{

	private List<compétance> getuser_comp;
	private List<Apprenant> getuser;
	private String query;
	private DB_connection db;
	@FXML   ComboBox<String> comboBox_nom;
	@FXML   ComboBox<String> comboBox_competance;
   public	String competance;
   public	String user,nom;
   public List<Gestion_user_competance> competance_user;
   @FXML Label label_1_title;
   @FXML Label label_2_title;
   @FXML Label label_1;
   @FXML Label label_2;
   @FXML Label label_3;
   @FXML Label label_4;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Remplir_combo_competance();
		Remplir_combo_user();
		 /* query = "select id_user,id_com,N1,N2,N3,title from user_compétance inner join user inner join competences  ON  user.id = user_compétance.id_user And user_compétance.id_com = competences.id  where user.nom = ?";
	      getuser_comp = db.getuser_comp(query,Main.nom_session);	*/
	}
	
	public void Remplir_combo_competance() {
		
		getuser_comp = new ArrayList<compétance>();
		query = "select * from competences";
		db    =   new DB_connection();
		getuser_comp   =  db.getCompt(query);
		 for(int i=0;i<getuser_comp.size();i++) {
			 comboBox_competance.getItems().addAll(getuser_comp.get(i).getTitle()); 
		 }
		
	}
	
	public void Remplir_combo_user() {
		getuser = new ArrayList<Apprenant>();
		query = "select * from user where Role = 'Apprenant' And Promo = '" + Main.Promo + "'";
		db    =   new DB_connection();
		getuser   =  db.getUsers_Promo(query);
		 for(int i=0;i<getuser.size();i++) {
			 comboBox_nom.getItems().addAll(getuser.get(i).getNom());
			 System.out.println(getuser.get(i).getNom());
		 }
		
	}
	
	@FXML
 public	void Select_combo_competance(javafx.event.ActionEvent event){
		
		competance = comboBox_competance.getSelectionModel().getSelectedItem().toString();
	 	
		
	}
	
	@FXML
 public	void Select_combo_user(javafx.event.ActionEvent event){
		
		
		nom = comboBox_nom.getSelectionModel().getSelectedItem().toString();
		System.out.println(nom);
	}
	
	public void Search() {
		
		String query = "select id_user,id_com,N1,N2,N3 from user_compétance inner join competences inner join user on user_compétance.id_com = competences.id And user.id = user_compétance.id_user where user.nom  ='" + nom + "' And competences.title = '" + competance + "'";
		competance_user = db.getuser_comp_2(query);
		System.out.println(competance);
		label_1.setText(competance);
		
		for(int i = 0;i<competance_user.size();i++) {
			
			if(competance_user.get(i).isN1()) {
				label_2.setStyle("-fx-background-color: green;");
				label_2.setText("Valider");
				
			}else {
				label_2.setStyle("-fx-background-color: rgb(240, 240, 240);");
				label_2.setText("In Valider");
				
			}
if(competance_user.get(i).isN2()) {
	            label_3.setStyle("-fx-background-color: green;");
				label_3.setText("Valider");
				
			}else {
				label_3.setStyle("-fx-background-color: rgb(240, 240, 240);");
				label_3.setText("In Valider");
				
			}
if(competance_user.get(i).isN3()) {
	label_4.setStyle("-fx-background-color: green;");
	label_4.setText("Valider");
	
}else {
	label_4.setStyle("-fx-background-color: rgb(240, 240, 240);");
	label_4.setText("In Valider");
	
}
			
			
			
		}
		
	}
	
	@FXML 
	public void  NextScene(){
		Main.Promo = "";
		Main.nom_session = "";
		Main.window.close();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
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

}
