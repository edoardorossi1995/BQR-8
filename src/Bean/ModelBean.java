package Bean;

public class ModelBean {
    private String nomeModello;
    private String roomGroup;
    private String text;

    public void setNomeModello(String nomeModello){
        this.nomeModello = nomeModello;
    }

    public void setRoomGroup(String roomGroup){
        this.roomGroup = roomGroup;

    }

    public String getName(){
        return nomeModello;
    }

    public String getRoomGroup(){
        return roomGroup;
    }

    public String getText(){
        return text;
    }

}