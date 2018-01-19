package Entity;
import java.util.ArrayList;

public class Modello {
    protected String name;
    protected String roomGroup;
    protected ArrayList<Feature> features;


    public Modello(String name, String roomGroup){
        this.name = name;
        int lenght = 30;
        features = new ArrayList<Feature>(lenght);
    }


    //Getter methods
    public String getName() {
        return this.name;
    }

    public String getroomGroup(){
     return this.roomGroup;
    }


    //Setter methods
    public void setName(String nuovoNome) {
        this.name = nuovoNome;
    }

    public void setroomGroup(String nuovoRoomGroup) {
        this.roomGroup = nuovoRoomGroup;
    }




    //Edit Model

    public void addFeatures(String name, int numberOfInstances){
     Feature feature = new Feature(name, numberOfInstances);
     features.add(feature);

     for (int count = 0; count < features.size()-1 ; count ++){
      Feature comparingFeature = features.get(count);
      String comparingString = comparingFeature.getName();
      if ( comparingString == name){
       feature.addInstances(comparingFeature.getNumberOfInstances());
       features.remove(count);
       break;
      }
     }
    }




    public void removeFeatures(String name, int numberOfInstances){
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




}


