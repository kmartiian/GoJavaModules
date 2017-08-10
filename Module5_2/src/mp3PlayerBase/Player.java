package mp3PlayerBase;



public abstract class Player {

    private int price;
    String song = "mySong";

    public Player(final int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public abstract void playSong();
}
