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
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class EliminazioneCaratteristicheController implements Initializable {

	@FXML
	private Label lblEliminazioneCaratteristica;
	@FXML
	private Label lblInserisciNome;
	@FXML
	private Label lblInserisciDescrizione;
	@FXML
	private Label lblView;
	@FXML
	private TextField txtInserisciNome;
	@FXML
	private TextField txtInserisciDescrizione;
	@FXML
	private TextArea txtArea;



	public void initialize(URL url, ResourceBundle rb){

	}

	public void back(ActionEvent event) throws Exception{

		Parent gestioneCaratteristiche_parent = FXMLLoader.load(getClass().getResource("GestioneCaratteristiche.fxml"));
		Scene gestioneCaratteristiche_scene = new Scene(gestioneCaratteristiche_parent);
		Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		app_stage.setScene(gestioneCaratteristiche_scene);
		app_stage.show();
	}


	public void eliminaCaratteristica(ActionEvent event) throws Exception{
		FeatureBean featurebean = new FeatureBean();
		featurebean.setName(txtInserisciNome.getText());
		featurebean.setDescription(txtInserisciDescrizione.getText());
		FeatureController fc = new FeatureController();
		fc.deleteFeature(featurebean);
		fc.viewFeatures(featurebean);
		txtArea.setText(featurebean.getText());
		txtInserisciNome.setText("");
		txtInserisciDescrizione.setText("");
	}

	public void eliminaTutto(ActionEvent event) throws Exception{
		FeatureBean featurebean = new FeatureBean();
		FeatureController fc = new FeatureController();
		fc.deleteAll();
		fc.viewFeatures(featurebean);
		txtArea.setText(featurebean.getText());

	}

	public void visualizzaFeatures(ActionEvent event) throws Exception{
		FeatureBean featurebean = new FeatureBean();
		FeatureController fc = new FeatureController();
		fc.viewFeatures(featurebean);
		txtArea.setText(featurebean.getText());

	}




}