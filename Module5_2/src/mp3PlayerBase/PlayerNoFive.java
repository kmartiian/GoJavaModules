package mp3PlayerBase;

public class PlayerNoFive extends PlayerNoThree{

    public PlayerNoFive(int price) {
        super(price);
    }

    @Override
    public void playAllSongs() {
        for (int i=playlist.length-1; i>(-1); i--) {
            System.out.printf("Playing: %s\n", playlist[i]);
        }
    }
}
