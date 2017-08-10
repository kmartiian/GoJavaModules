package mp3PlayerBase;

public class PlayerNoFour extends PlayerNoThree {

    public PlayerNoFour(int price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.printf("Playing: %s\n", playlist[playlist.length-1]);
    }

}
