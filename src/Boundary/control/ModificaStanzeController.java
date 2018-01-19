package Boundary.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificaStanzeController implements Initializable {

	@FXML
	private Label lblModificaStanza;

	@FXML
	private Label lblInsertName;
	@FXML
	private Label lblInsertmodifName;
	@FXML
	private Label lblInsertmodifRoomGroup;

	@FXML
	private MenuButton menubtnRoomGroup;
	@FXML
	private Label lblRoomGroup;

	@FXML
	private MenuButton menubtnModifRoomGroup;
	@FXML
	private Label lblModifRoomGroup;

	@FXML
	private MenuItem menuitemClassroom;
	@FXML
	private MenuItem menuitemLaboratory;
	@FXML
	private MenuButton menuitemConference;

	@FXML
	private MenuItem menuitemModifClassroom;
	@FXML
	private MenuItem menuitemModifLaboratory;
	@FXML
	private MenuButton menuitemModifConference;

	@FXML
	private Label lblViewfeatures;
	@FXML
	private Label lblViewRoom;

	@FXML
	private Label lblInsertCREATEfeatureNAME;
	@FXML
	private Label lblInsertCREATEDESCRIPTION;
	@FXML
	private Label lblInsertCREATEnumberOfInst;

	@FXML
	private Label lblInsertDELETEfeatureNAME;
	@FXML
	private Label lblInsertDELETEDESCRIPTION;
	@FXML
	private Label lblInsertDELETEnumberOfInst;

	@FXML
	private TextField txtInsertmodifName;

	@FXML
	private TextField txtInsertCREATEfeatureNAME;
	@FXML
	private TextField txtInsertCREATEDESCRIPTION;
	@FXML
	private TextField txtInsertCREATEnumberOfInst
	;
	@FXML
	private TextField txtInsertDELETEfeatureNAME;
	@FXML
	private TextField txtInsertDELETEDESCRIPTION;
	@FXML
	private TextField txtInsertDELETEnumberOfInst;

	@FXML
	private TextArea scrollbartxtAreaONE;
	@FXML
	private TextArea scrollbartxtAreaTWO;



	public void initialize(URL url, ResourceBundle rb){

	}

	public void back(ActionEvent event) throws Exception{

		Parent gestioneStanze_parent = FXMLLoader.load(getClass().getResource("GestioneStanze.fxml"));
		Scene gestioneStanze_scene = new Scene(gestioneStanze_parent);
		Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		app_stage.setScene(gestioneStanze_scene);
		app_stage.show();
	}




}