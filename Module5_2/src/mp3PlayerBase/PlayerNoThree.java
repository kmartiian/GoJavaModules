package mp3PlayerBase;

public class PlayerNoThree extends Player implements IPlayAllSongs{

    public PlayerNoThree(final int price){
        super(price);
    }

    @Override
    public void playSong() {
        System.out.printf("Playing: %s\n", playlist[0]);
    }

    @Override
    public void playAllSongs() {
        for (String song:playlist) {
            System.out.printf("Playing: %s\n", song);
        }
    }
}
