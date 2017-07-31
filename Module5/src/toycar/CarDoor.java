package toycar;

public class CarDoor {
    private String doorState;
    private String doorWindowState;

    public CarDoor (){
        doorState = "closed";
        doorWindowState = "closed";
    }

    public CarDoor(String doorState, String doorWindowState) {
        this.doorState = doorState;
        this.doorWindowState = doorWindowState;
    }

    public String getDoorState(){
        return doorState;
    }

    public void openDoor (){
        doorState = "opened";
    }

    public void closeDoor (){
        doorState = "closed";
    }

    public void operateDoor (){
        if (doorState == "closed"){
            doorState = "opened";
        }else{
            doorState = "closed";
        }
    }

    public void openDWindow (){
        doorWindowState = "opened";
    }

    public void closeDWindow (){
        doorWindowState = "closed";
    }

    public void operateDWindow (){
        if (doorWindowState=="closed"){
            doorWindowState = "opened";
        }else{
            doorWindowState = "closed";
        }
    }

    public void print(){
        System.out.printf("This CarDoor is %s and its window is %s\n", doorState, doorWindowState);
    }

}
