package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Gestion_user_competance;
import application.compétance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewCompetances implements Initializable{
	@FXML private TableView<Gestion_user_competance> table;
	@FXML private TableColumn<Gestion_user_competance,String> name;
	@FXML private TableColumn<Gestion_user_competance,String> N1; 
	@FXML private TableColumn<Gestion_user_competance,String> N2;
	@FXML private TableColumn<Gestion_user_competance,String> N3;
	ObservableList<Gestion_user_competance> oblist = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		N1.setCellValueFactory(new PropertyValueFactory<>("N1"));
		N2.setCellValueFactory(new PropertyValueFactory<>("N2"));
		N3.setCellValueFactory(new PropertyValueFactory<>("N3"));
		
		
	}

}
