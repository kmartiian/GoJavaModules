package mp3PlayerBase;

public class PlayerNoOne extends Player {

    public PlayerNoOne(final int price){
        super(price);
    }

    @Override
    public void playSong() {
        System.out.printf("Playing: %s\n", song);
    }
}
