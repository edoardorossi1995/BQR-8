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

public class EliminazioneEdificioController implements Initializable {

	@FXML
	private Label lblEliminazioneEdificio;
	@FXML
	private Label lblInsertName;
	@FXML
	private Label lblClickToView;
	@FXML
	private Label lblInsertMacroArea;
	@FXML
	private TextField txtInsertName;
	@FXML
	private TextArea txtscrollbarArea;
	@FXML
	private TextField txtInsertMacroarea;



	public void initialize(URL url, ResourceBundle rb){

	}

	public void back(ActionEvent event) throws Exception{

		Parent gestioneEdificio_parent = FXMLLoader.load(getClass().getResource("GestioneEdifici.fxml"));
		Scene gestioneEdificio_scene = new Scene(gestioneEdificio_parent);
		Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		app_stage.setScene(gestioneEdificio_scene);
		app_stage.show();
	}


	public void eliminazioneEdificio(ActionEvent event) throws Exception{

		BuildingBean bb = new BuildingBean();
		bb.setNomeEdificio(txtInsertName.getText());
		bb.setMacroarea(txtInsertMacroarea.getText());
		BuildingController bc = new BuildingController();
		bc.deleteBuilding(bb);
		txtInsertName.setText("");
		txtInsertMacroarea.setText("");
		visualizzaEdifici();

	}

	public void visualizzaEdifici() throws Exception{
		BuildingBean bb = new BuildingBean();
		BuildingController bc = new BuildingController();
		bc.viewBuildings(bb);
		txtscrollbarArea.setText(bb.getText());


	}

	public void visualizzaEdifici(ActionEvent event) throws Exception{
		BuildingBean bb = new BuildingBean();
		BuildingController bc = new BuildingController();
		bc.viewBuildings(bb);
		txtscrollbarArea.setText(bb.getText());

	}


}