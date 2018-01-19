package Boundary.control;

import java.net.URL;
import java.util.ResourceBundle;

import Bean.RoomBean;
import Control.RoomController;
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

public class EliminazioneStanzeController implements Initializable {

	@FXML
	private Label lblEliminazioneStanza;
	@FXML
	private Label lblInserisciNome;
	@FXML
	private Label lblInserisciRoomGroup;
	@FXML
	private Label lblInserisciNomeEdificio;
	@FXML
	private Label lblInserisciMacroarea;
	@FXML
	private Label lblVisualizzaStanze;
	@FXML
	private TextField txtInserisciMacroarea;
	@FXML
	private TextField txtInserisciNome;
	@FXML
	private TextField txtInserisciRoomGroup;
	@FXML
	private TextField txtInserisciNomeEdificio;
	@FXML
	private TextArea txtArea;



	public void initialize(URL url, ResourceBundle rb){

	}

	public void back(ActionEvent event) throws Exception{

		Parent secretaryMainPage_parent = FXMLLoader.load(getClass().getResource("GestioneStanze.fxml"));
		Scene secretaryMainPage_scene = new Scene(secretaryMainPage_parent);
		Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		app_stage.setScene(secretaryMainPage_scene);
		app_stage.show();
	}


	public void eliminaStanza(ActionEvent event) throws Exception{
		RoomBean roombean = new RoomBean();
		roombean.setName(txtInserisciNome.getText());
		roombean.setRoomGroup(txtInserisciRoomGroup.getText());
		roombean.setNomeEdificio(txtInserisciNomeEdificio.getText());
		roombean.setMacroarea(txtInserisciMacroarea.getText());
		RoomController rc = new RoomController();
		rc.deleteRoom(rc.getRoomCode(roombean));
		txtInserisciNome.setText("");
		txtInserisciNomeEdificio.setText("");
		txtInserisciRoomGroup.setText("");
		txtInserisciMacroarea.setText("");
		visualizzaStanze();

	}

	public void deleteAll(ActionEvent event) throws Exception{
		RoomBean roombean = new RoomBean();
		RoomController rc = new RoomController();
		rc.deleteAll(roombean);
		txtArea.setText(roombean.getText());
	}

	public void visualizzaStanze(ActionEvent event) throws Exception{
		RoomBean roombean = new RoomBean();
		RoomController rc = new RoomController();
		rc.viewRooms(roombean);
		txtArea.setText(roombean.getText());

	}

	public void visualizzaStanze() throws Exception{
		RoomBean roombean = new RoomBean();
		RoomController rc = new RoomController();
		rc.viewRooms(roombean);
		txtArea.setText(roombean.getText());

	}



}
