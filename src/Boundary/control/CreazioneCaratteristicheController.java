package Boundary.control;

import java.net.URL;
import java.util.ResourceBundle;

import Bean.FeatureBean;
import Control.FeatureController;
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

public class CreazioneCaratteristicheController implements Initializable {

	@FXML
	private Label lblCreazioneCaratteristiche;
	@FXML
	private Label lblInsertName;
	@FXML
	private Label lblInsertDescription;
	@FXML
	private TextField txtInsertName;
	@FXML
	private TextArea txtInsertDescription;
	@FXML
	private TextArea txtscrollbarArea;



	public void initialize(URL url, ResourceBundle rb){


	}

	public void back(ActionEvent event) throws Exception{

		Parent gestioneCaratteristiche_parent = FXMLLoader.load(getClass().getResource("GestioneCaratteristiche.fxml"));
		Scene gestioneCaratteristiche_scene = new Scene(gestioneCaratteristiche_parent);
		Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		app_stage.setScene(gestioneCaratteristiche_scene);
		app_stage.show();
	}

	public void creazioneCaratteristica(ActionEvent event) throws Exception{

		FeatureBean featurebean = new FeatureBean();
		featurebean.setName(txtInsertName.getText());
		featurebean.setDescription(txtInsertDescription.getText());

		FeatureController fc = new FeatureController();
		fc.createNewFeature(featurebean);

		txtscrollbarArea.setText(featurebean.getText());
		txtInsertName.setText("");
		txtInsertDescription.setText("");
	}

	public void visualizzaCaratteristiche(ActionEvent event) throws Exception{
		FeatureBean featurebean = new FeatureBean();
		FeatureController fc = new FeatureController();
		fc.viewFeatures(featurebean);
		txtscrollbarArea.setText(featurebean.getText());

	}


}