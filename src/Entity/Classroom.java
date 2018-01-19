package Entity;

import java.util.ArrayList;

public class Classroom extends Room {

	public Classroom(String name) {
        this.name = name;
        features = new ArrayList<Feature>();
        roomGroup = "ClassRoom";
    }

    public Classroom(String name, Edificio edificio) {
        this.name = name;
        this.edificio = edificio;
        features = new ArrayList<Feature>();
        roomGroup = "ClassRoom";
    }

    @Override
    public String getRoomGroup(){
    	return roomGroup;
    }


}
