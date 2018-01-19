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

public class ModificaEdificioController implements Initializable {

    @FXML
    private Label lblModificaEdificio;
    @FXML
    private Label lblNewName;
    @FXML
    private Label lblNewMacroarea;
    @FXML
    private Label lblClicktoView;
    @FXML
    private Label lblOldName;
    @FXML
    private Label lblOldMacroarea;
    @FXML
    private TextField txtOldName;
    @FXML
    private TextField txtNewName;
    @FXML
    private TextField txtOldMacroarea;
    @FXML
    private TextField txtnewMacroarea;
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

    public void visualizzaEdifici() throws Exception{
        BuildingBean bb = new BuildingBean();
        BuildingController bc = new BuildingController();
        bc.viewBuildings(bb);
        scrollbartxtArea.setText(bb.getText());
    }

    public void ModificaEdificioNome(ActionEvent event) throws Exception{

    	 BuildingBean buildingbean = new BuildingBean();
         buildingbean.setNomeEdificio(txtOldName.getText());
         buildingbean.setMacroarea(txtOldMacroarea.getText());
         buildingbean.setNewNomeEdificio(txtNewName.getText());
         BuildingController bc = new BuildingController();
         bc.buildingModifyName(buildingbean);
         scrollbartxtArea.setText(buildingbean.getText());
         txtOldName.setText("");
         txtOldMacroarea.setText("");
         txtNewName.setText("");
    }

    public void ModificaEdificioNome() throws Exception{

    	BuildingBean buildingbean = new BuildingBean();
        buildingbean.setNomeEdificio(txtOldName.getText());
        buildingbean.setMacroarea(txtOldMacroarea.getText());
        buildingbean.setNewNomeEdificio(txtNewName.getText());
        BuildingController bc = new BuildingController();
        bc.buildingModifyName(buildingbean);
    }

    public void ModificaEdificioMacroarea(ActionEvent event) throws Exception{

    	BuildingBean buildingbean = new BuildingBean();
        buildingbean.setNomeEdificio(txtOldName.getText());
        buildingbean.setMacroarea(txtOldMacroarea.getText());
        buildingbean.setNewMacroarea(txtnewMacroarea.getText());
        BuildingController bc = new BuildingController();
        bc.buildingModifyMacroarea(buildingbean);
        scrollbartxtArea.setText(buildingbean.getText());
        txtOldName.setText("");
        txtOldMacroarea.setText("");
        txtnewMacroarea.setText("");
    }

    public void ModificaEdificioMacroarea() throws Exception{

    	BuildingBean buildingbean = new BuildingBean();
        buildingbean.setNomeEdificio(txtNewName.getText());
        buildingbean.setMacroarea(txtOldMacroarea.getText());
        buildingbean.setNewMacroarea(txtnewMacroarea.getText());
        BuildingController bc = new BuildingController();
        bc.buildingModifyMacroarea(buildingbean);

    }

    public void ApplyBoth(ActionEvent event) throws Exception{
    	ModificaEdificioNome();
    	ModificaEdificioMacroarea();
    	visualizzaEdifici();

    	txtOldName.setText("");
        txtOldMacroarea.setText("");
        txtNewName.setText("");
        txtnewMacroarea.setText("");

    }



}