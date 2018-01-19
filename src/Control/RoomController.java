package Control;

import Bean.RoomBean;
import Bean.BuildingBean;
import Entity.Room;
import Entity.RoomFactory;
import dao.daoBuildings;
import dao.daoRooms;

public class RoomController {

	private String text;


	public RoomController(){
	}


	public void createRoom(RoomBean rb) throws Exception{

		String nome = rb.getName();
		String roomGroup = rb.getRoomGroup();
		String nomeEdificio = rb.getNomeEdificio();
		String macroarea = rb.getMacroarea();

		daoBuildings dbb = new daoBuildings();

		if (dbb.isThere(nomeEdificio,macroarea) == true){
			daoRooms db = new daoRooms();
			db.insertRoom(nome,roomGroup,nomeEdificio,macroarea);
			rb.setText(db.printRooms());
		}
		else{
			BuildingController bc = new BuildingController();
			BuildingBean bb = new BuildingBean();
			bb.setNomeEdificio(nomeEdificio);
			bb.setMacroarea(macroarea);
			bc.createBuilding(bb);
			daoRooms db = new daoRooms();
			db.insertRoom(nome,roomGroup,nomeEdificio,macroarea);
			rb.setText(db.printRooms());
		}
	}

	public int getRoomCode(RoomBean rb) throws Exception{
		String nome = rb.getName();
		String roomGroup = rb.getRoomGroup();
		String nomeEdificio = rb.getNomeEdificio();
		String macroarea = rb.getMacroarea();
		daoRooms db = new daoRooms();
		return db.getRoomCode(nome,roomGroup,nomeEdificio,macroarea);
	}


	public void deleteRoom(int codiceStanza) throws Exception{
		daoRooms db = new daoRooms();
		db.deleteRoom(codiceStanza);
	}

	public void modifyRoom(int codiceStanza) throws Exception{

	}


	public Room getRoom(int codiceStanza) throws Exception{

//		Scegliendo una stanza dal menu a tendina chiamo il metodo getRoomCode
//		(con i dovuti passaggi architetturali), che passo a questo metodo,
//		che usa la factory e crea una stanza, pronta a essere "caratterizzata".

		daoRooms db = new daoRooms();
		BuildingController bc = new BuildingController();
		Room stanza = creazioneStanza(db.getRoomroomgroup(codiceStanza));
		stanza.setName(db.getRoomName(codiceStanza));
		stanza.setBuilding(bc.getBuilding(db.getRoomNomeEdificio(codiceStanza),db.getRoomMacroarea(codiceStanza)));
		stanza.setCodiceStanza(codiceStanza);
		return stanza;
	}

	public void deleteAll(RoomBean roombean) throws Exception{
		daoRooms dr = new daoRooms();
		dr.deleteAllRooms();
		roombean.setText(dr.printRooms());
	}


	public void viewRooms(RoomBean rb) throws Exception{
		daoRooms db = new daoRooms();
		rb.setText(db.printRooms());
	}


	public void insertFeature(String name, int numberOfInstances)throws Exception{





	}


	public String getText(){
		return text;
	}


	public void setText(String testo){
		text = testo;
	}


	//USECASE METHODS

	public Room creazioneStanza(String roomGroup) throws Exception {
		int type = 0;

		switch (roomGroup){
		case "Classroom" :
			type = 1;
			break;
		case "Laboratory" :
			type = 2;
			break;
		case "ConferenceRoom" :
			type = 3;
			break;
		}

		RoomFactory factory = new RoomFactory();
		return factory.createRoom(type);
	}


}
