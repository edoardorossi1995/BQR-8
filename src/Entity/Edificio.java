package Entity;

import java.util.ArrayList;

public class Edificio {

    private String name;
    private String macroarea;
    private ArrayList<Room> roomList;

    public Edificio(String nome, String macro) {
        name = nome;
        macroarea = macro;
        roomList = new ArrayList<Room>(30);
    }

    //set methods
    public void setName(String name) {
        this.name = name;
    }
    public void setMacroarea(String macroarea) {
        this.macroarea = macroarea;
    }

    //get methods
    public String getName() {
        return name;
    }
    public String getMacroArea() {
        return macroarea;
    }

    public ArrayList<Room> getRoomList(){
    	return roomList;
    }



    public void addRoom(Room room){
    	roomList.add(room);
    }

    public void removeRoom(Room room){
    	roomList.remove(room);

    }
}
