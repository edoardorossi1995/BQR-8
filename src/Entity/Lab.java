package Entity;

import java.util.ArrayList;

public class Lab extends Room{

	public Lab(String name) {
        this.name = name;
        features = new ArrayList<Feature>();
        roomGroup = "Laboratory";
    }

    public Lab(String name, Edificio edificio) {
        this.name = name;
        this.edificio = edificio;
        features = new ArrayList<Feature>();
        roomGroup = "Laboratory";
    }

    @Override
    public String getRoomGroup(){
    	return roomGroup;
    }

}
