package Control;

import java.util.ArrayList;

import Bean.BuildingBean;
import Entity.Edificio;
import Entity.Room;
import dao.daoBuildings;
import dao.daoRooms;

public class BuildingController {

	private String text;

	public BuildingController(){

    }

	public void createBuilding(BuildingBean bb) throws Exception{

		String nome = bb.getNomeEdificio();
		String macroarea = bb.getMacroarea();
		daoBuildings dbb = new daoBuildings();
		dbb.insertBuilding(nome,macroarea);
		bb.setText(dbb.printBuildings());
	}


	public void buildingModifyName(BuildingBean bb) throws Exception{
		String oldName = bb.getNomeEdificio();
		String macroarea = bb.getMacroarea();
		String newName = bb.getNewNomeEdificio();
	    daoBuildings dbb = new daoBuildings();
		dbb.updateNomeEdificio(oldName, macroarea, newName);
		bb.setText(dbb.printBuildings());
    }

    public void buildingModifyMacroarea(BuildingBean bb) throws Exception{
    	String name = bb.getNomeEdificio();
		String oldMacroarea = bb.getMacroarea();
		String newMacroarea = bb.getNewMacroarea();
	    daoBuildings dbb = new daoBuildings();
		dbb.updateMacroareaEdificio(name,oldMacroarea,newMacroarea);
		bb.setText(dbb.printBuildings());
    }

    public void deleteBuilding(BuildingBean bb) throws Exception{

    	Edificio building = getBuilding(bb.getNomeEdificio(), bb.getMacroarea());
    	daoRooms dr = new daoRooms();
    	dr.addRoomsToBuildingArray(building);
    	ArrayList<Room> roomList = building.getRoomList();
    	for (int count = 0; count < roomList.size(); count ++){
    		Room deletingRoom = roomList.get(count);
    		dr.deleteRoom(deletingRoom.getCodiceStanza());
    	}
    	daoBuildings db = new daoBuildings();
    	String nomeEdificio = bb.getNomeEdificio();
    	String macroarea = bb.getMacroarea();
	    db.deleteEdificio(nomeEdificio,macroarea);
    }


    public Edificio getBuilding(String name, String macro){

		Edificio edificio = new Edificio(name,macro);
		return edificio;
	}

    public void viewBuildings(BuildingBean bb) throws Exception{
    	daoBuildings db = new daoBuildings();
    	bb.setText(db.printBuildings());
    }


	public String getText(){
		return text;
	}



}