package Control;


import Bean.FeatureBean;
import Entity.Feature;
import Entity.Room;
import dao.daoFeatures;



public class FeatureController {


	public Feature createFeature(){
		return new Feature();
	}


	public void createNewFeature(FeatureBean fb) throws Exception{

		String nomeFeature = fb.getName();
		String description = fb.getDescription();
		daoFeatures df = new daoFeatures();
		df.insertNewFeature(nomeFeature,description);
		viewFeatures(fb);
	}


	public void deleteFeature(FeatureBean fb) throws Exception{
		String nomeFeature = fb.getName();
		String description = fb.getDescription();
		daoFeatures df = new daoFeatures();
		int codiceFeature = df.getFeatureCode(nomeFeature,description);
		df.deleteFeature(codiceFeature);
	}

	public void deleteAll() throws Exception{
		daoFeatures df = new daoFeatures();
		df.deleteAllFeatures();
	}
	public void viewFeatures(FeatureBean fb) throws Exception{
		daoFeatures df = new daoFeatures();
		fb.setText(df.printFeatures());

	}

	public void insertFeatureIntoRoom(int codiceStanza, int codiceFeature,int numberOfInstances) throws Exception{


		RoomController rc = new RoomController();
		daoFeatures df = new daoFeatures();

		//ricreo la stanza inserendo tutte le caratteristiche che aveva già
		Room room = rc.getRoom(codiceStanza);
		df.addFeaturesToRoomArray(room);

		//prendo una feature dal cestino delle feature e la inserisco in una stanza
		Feature feature = getFeature(codiceFeature);
		feature.setName(df.getFeatureName(codiceFeature));
		feature.setNumberOfInstances(numberOfInstances);
		room.addFeatures(feature);
		df.insertFeatureIntoRoom(feature);

	}



	public Feature getFeature(int codiceFeature ) throws Exception {

		daoFeatures df = new daoFeatures();
		Feature feature = createFeature();
		feature.setName(df.getFeatureName(codiceFeature));
		feature.setDescription(df.getFeatureDescription(codiceFeature));
		feature.setCodiceFeature(codiceFeature);
		return feature;

	}

}
