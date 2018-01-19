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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreazioneStanzeController implements Initializable {

	@FXML
	private Label lblCreazioneStanza;
	@FXML
	private Label lblClickToView;
	@FXML
	private Label lblInsertName;
	@FXML
	private Label lblInsertRoomGroup;
	@FXML
	private Label lblInsertNomeEdificio;
	@FXML
	private Label lblInsertMacroArea;
	@FXML
	private TextField txtInsertName;
	@FXML
	private TextField txtInsertRoomGroup;
	@FXML
	private TextField txtInsertNomeEdificio;
	@FXML
	private TextArea txtscrollbarArea;
	@FXML
	private TextField txtInsertMacroarea;



	public void initialize(URL url, ResourceBundle rb){


	}

	public void back(ActionEvent event) throws Exception{

		Parent gestioneStanze_parent = FXMLLoader.load(getClass().getResource("GestioneStanze.fxml"));
		Scene gestioneStanze_scene = new Scene(gestioneStanze_parent);
		Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		app_stage.setScene(gestioneStanze_scene);
		app_stage.show();
	}

	public void view(ActionEvent event) throws Exception{
		RoomBean roombean = new RoomBean();
		RoomController rc = new RoomController();
		rc.viewRooms(roombean);
		txtscrollbarArea.setText(roombean.getText());

	}


	public void creazioneStanza(ActionEvent event) throws Exception{

		RoomBean roombean = new RoomBean();
		roombean.setName(txtInsertName.getText());
		roombean.setRoomGroup(txtInsertRoomGroup.getText());
		roombean.setNomeEdificio(txtInsertNomeEdificio.getText());
		roombean.setMacroarea(txtInsertMacroarea.getText());

		RoomController rc = new RoomController();
		rc.createRoom(roombean);
		txtscrollbarArea.setText(roombean.getText());
		txtInsertName.setText("");
		txtInsertRoomGroup.setText("");
		txtInsertNomeEdificio.setText("");
		txtInsertMacroarea.setText("");

	}

	public void visualizzaStanze() throws Exception{
		RoomBean roombean = new RoomBean();
		RoomController rc = new RoomController();
		rc.viewRooms(roombean);
		txtscrollbarArea.setText(roombean.getText());

	}

	public void visualizzaStanze(ActionEvent event) throws Exception{
		RoomBean roombean = new RoomBean();
		RoomController rc = new RoomController();
		rc.viewRooms(roombean);
		txtscrollbarArea.setText(roombean.getText());

	}


}