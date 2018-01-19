package Boundary.control;

import java.net.URL;
import java.util.ResourceBundle;

import Bean.BuildingBean;
import Control.BuildingController;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreazioneEdificioController implements Initializable {

	@FXML
	private Label lblCreazioneEdificio;
	@FXML
	private Label lblInsertName;
	@FXML
	private Label lblInsertMacroarea;
	@FXML
	private TextField txtInsertName;
	@FXML
	private TextField txtInsertMacroarea;
	@FXML
	private TextArea scrollbartxtArea;



	public void initialize(URL url, ResourceBundle rb){

	}

	public void back(ActionEvent event) throws Exception{

		Parent gestioneEdifici_parent = FXMLLoader.load(getClass().getResource("GestioneEdifici.fxml"));
		Scene gestioneEdifici_scene = new Scene(gestioneEdifici_parent);
		Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		app_stage.setScene(gestioneEdifici_scene);
		app_stage.show();
	}

	public void creazioneEdificio(ActionEvent event) throws Exception{

		BuildingBean buildingbean = new BuildingBean();
		buildingbean.setNomeEdificio(txtInsertName.getText());
		buildingbean.setMacroarea(txtInsertMacroarea.getText());
		BuildingController bc = new BuildingController();
		bc.createBuilding(buildingbean);
		scrollbartxtArea.setText(buildingbean.getText());
		txtInsertName.setText("");
		txtInsertMacroarea.setText("");
	}




}