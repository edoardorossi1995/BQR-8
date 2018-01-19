package Entity;

import java.util.ArrayList;

public abstract class Room {

	protected String roomGroup;
    protected String name;
    protected Edificio edificio = null;
    protected ArrayList<Feature> features;
    protected int codiceStanza;


    //Builders
    public Room(){

    }

    public Room(String name, Edificio edificio){
        this.name = name;
        this.edificio = edificio;
        features = new ArrayList<Feature>(30);
    }


    public abstract String getRoomGroup();



    //Print methods
    public void view(){
    	System.out.println("Room Group: " + roomGroup +
    			"\nname: " + name +
    			"\nbuilding: " + edificio.getName() +
    			"\nmacroarea: " + edificio.getMacroArea() +
    			"\nfeatures of the Room:" );
    	for (int count = 0; count < features.size(); count ++){
    		Feature f = features.get(count);
    		System.out.println(f.view());
    	}
    	System.out.println("\n\n");
    }


    //Getter methods
    public String getName() {
        return this.name;
    }

    public Edificio getBuilding(){
    	return edificio;
    }

    public int getCodiceStanza(){
    	return codiceStanza;
    }

    public ArrayList<Feature> getFeatures(){
    	return features;
    }


    //Setter methods
    public void setName(String nuovoNome) {
        this.name = nuovoNome;
    }

    public void setCodiceStanza(int codiceStanza){
    	this.codiceStanza = codiceStanza;
    }

    public void setBuilding(Edificio edificio){
    	this.edificio = edificio;
    }


    //Features Methods

    public void addFeatures(Feature feature){
    	String name = feature.getName();
    	features.add(feature);

    	for (int count = 0; count < features.size()-1 ; count ++){
    		Feature comparingFeature = features.get(count);
    		String comparingString = comparingFeature.getName();
    		if ( comparingString == name){
    			feature.addInstances(comparingFeature.getNumberOfInstances());
    			feature.setNumberOfDamages(comparingFeature.getNumberOfDamages());
    			features.remove(count);
    			break;
    		}
    	}
    }




    public void removeFeatures(Feature feature){
    	String name = feature.getName();
    	int numberOfInstances = feature.getNumberOfInstances();
    	for (int count = 0; count < features.size(); count ++){
    		Feature candidate = features.get(count);
    		if (candidate.getName() == name){
    			candidate.removeInstances(numberOfInstances);
    			if (candidate.getNumberOfInstances() <= 0){
    				features.remove(count);
    			}
    			break;
    		}
    	}
    }


    public void updateDamages(String name, int n){
    	for (int count = 0; count < features.size(); count ++){
    		Feature f = features.get(count);
    		if (f.getName() == name){
    			for (int i = 0; i < n; i ++){
    				f.damage();
    			}
    			break;
    		}
    	}
    }


    public void repairDamages(String name, int n){
    	for (int count = 0; count < features.size(); count ++){
    		Feature f = features.get(count);
    		if (f.getName() == name){
    			for (int i = 0; i < n; i ++){
    				f.repair();
    			}
    			break;
    		}
    	}
    }




}
