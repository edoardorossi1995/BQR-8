package Control;

import Entity.Modello;
import dao.daoModels;

public class ModelController {


	public ModelController(){
	}

	//MANCA IL METODO updateFeaturesModel(...)....


	public void modelCreator(String nome,String roomGroup) throws Exception{
		daoModels dbb = new daoModels();
		dbb.insertModel(nome,roomGroup);
	}

	public boolean modelDestroyer(Modello model) throws Exception{
		daoModels dbb = new daoModels();
		dbb.deleteModel(model);

		return true;
	}


	public Modello updateNameModel(Modello model, String newName) throws Exception{
		daoModels dbb = new daoModels();

		dbb.updateNameModello(model,newName);

		return model;
	}


	public Modello updateRoomGroupModel(Modello model, String newRoomGroup) throws Exception{
		daoModels dbb = new daoModels();

		dbb.updateRoomGroupModello(model,newRoomGroup);

		return model;
	}

}



