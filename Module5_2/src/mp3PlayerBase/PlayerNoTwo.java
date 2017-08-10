package mp3PlayerBase;

public class PlayerNoTwo extends Player {

    public PlayerNoTwo(final int price){
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("error");
    }
}
