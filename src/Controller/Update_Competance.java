package Controller;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import Database.DB_connection;
import application.Gestion_user_competance;
import application.Main;
import application.compétance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class Update_Competance implements Initializable {
	@FXML   ComboBox<String> comboBox_cmpt;
	@FXML   ComboBox<String> comboBox_N1;
	@FXML   ComboBox<String> comboBox_N2;
	@FXML   ComboBox<String> comboBox_N3;
	List<compétance> cmp;
	@FXML javafx.scene.control.Label txt_label;
	@FXML javafx.scene.control.Label txt_label_N1;
	@FXML javafx.scene.control.Label txt_label_N2;
	@FXML javafx.scene.control.Label txt_label_N3;
    public 	List<Gestion_user_competance> getuser_comp;
	String query;
	DB_connection db;
	int id;
	
	@Override
	public void initialize(URL url,ResourceBundle rb) {
		
		cmp = new ArrayList<compétance>();
		query = "select * from competences";
		System.out.println("entree");
		db = new DB_connection();
		cmp =  db.getCompt(query);
		System.out.println(cmp.size());
		
		 for(int i=0;i<cmp.size();i++) {
			 
			 comboBox_cmpt.getItems().addAll(cmp.get(i).getTitle()); 
			 
		 }
		 query = "select id_user,id_com,N1,N2,N3,title from user_compétance inner join user inner join competences  ON  user.id = user_compétance.id_user And user_compétance.id_com = competences.id  where user.nom = ?";
	      getuser_comp = db.getuser_comp(query,Main.nom_session);
			
		
		
	}
	
	@FXML
	void Select(javafx.event.ActionEvent event){
		txt_label.setText(comboBox_cmpt.getSelectionModel().getSelectedItem().toString());
		//System.out.println(Main.nom_session + " " +comboBox_cmpt.getSelectionModel().getSelectedItem().toString());
		//System.out.println(getuser_comp.isN1());
		for(int i=0;i<getuser_comp.size();i++) {	
if(getuser_comp.get(i).getTitle().equals(comboBox_cmpt.getSelectionModel().getSelectedItem().toString())) {
	if(getuser_comp.get(i).isN1() == true){
		txt_label_N1.setText("Valider");
	}else {
		txt_label_N1.setText("Nom Valide");
	}
		
	if(getuser_comp.get(i).isN2() == true){
		txt_label_N2.setText("Valider");
	}
	else {
			txt_label_N2.setText("Nom Valide");
		}
			
	if(getuser_comp.get(i).isN3() == true) {
		txt_label_N3.setText("Valider");
	}else {
			txt_label_N3.setText("Nom Valide");
		
	
}
	break;
}
			
		}
				
		
		
	}
	
	public void click_Label_1() {
		
	if(txt_label_N1.getText().equals("Valider")) {
		
		txt_label_N1.setText("Nom Valide");
		txt_label_N2.setText("Nom Valide");
		txt_label_N3.setText("Nom Valide");
		
	}else {
		
		txt_label_N1.setText("Valider");
		
	}

	
/*	if(txt_label_N2.getText().equals("Valider")) {
		
		txt_label_N2.setText("Nom Valide");
		
	}else {
		
		txt_label_N2.setText("Valider");
		
	}
	
	if(txt_label_N3.getText().equals("Valider")) {
		
		txt_label_N3.setText("Nom Valide");
		
	}else {
		
		txt_label_N3.setText("Valider");
		
	}*/
		
	}
	
	public void click_Label_2() {
		
	if(txt_label_N2.getText().equals("Valider") ) {
		
		txt_label_N2.setText("Nom Valide");
		txt_label_N3.setText("Nom Valide");
		
		
	}else {
		
		txt_label_N2.setText("Valider");
		txt_label_N1.setText("Valider");
	}

	

		
	}
	
	public void click_Label_3() {
		
	if(txt_label_N3.getText().equals("Valider") ) {
		
		txt_label_N3.setText("Nom Valide");
		
	}else {
		txt_label_N3.setText("Valider");
		txt_label_N2.setText("Valider");
		txt_label_N1.setText("Valider");
	}

	

		
	}
	
	public void Update_Niveau(){
		boolean N1,N2,N3;
		if(txt_label_N1.getText().equals("Valider")) {
			
			N1 = true;
			
		}else {
			
			N1 = false;
			
		}
		if(txt_label_N2.getText().equals("Valider")) {
			
			N2 = true;
			
		}else {
			
			N2 = false;
			
		}
		if(txt_label_N3.getText().equals("Valider")) {
			
			N3 = true;
			
		}else {
			
			N3 = false;
			
		}

		String competance = txt_label.getText();

		for(int i = 0;i<getuser_comp.size();i++) {
			
			if(getuser_comp.get(i).getTitle().equals(competance)) {
				id = getuser_comp.get(i).getId_comp();
				break;
			}
			
		}
		String query = "UPDATE `user_compétance`  INNER JOIN user On user_compétance.id_user = user.id  SET `N1`=?,`N2`=?,`N3`=? WHERE user_compétance.id_com =? And user.nom = ?";
		db.Gestioncompétance(query,Main.nom_session,N1, N2, N3,id);
	    String query_1 = "select id_user,id_com,N1,N2,N3,title from user_compétance inner join user inner join competences  ON  user.id = user_compétance.id_user And user_compétance.id_com = competences.id  where user.nom = ?";
	    getuser_comp.clear();
	    getuser_comp = db.getuser_comp(query_1,Main.nom_session);
		
		
		
		
	}
	
	
	
	
	

}
