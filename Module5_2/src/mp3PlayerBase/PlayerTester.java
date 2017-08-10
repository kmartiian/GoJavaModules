package mp3PlayerBase;

public class PlayerTester {

    public static void main(String[] args){
        PlayerNoFour player4 = new PlayerNoFour(100);
        player4.playAllSongs();
        player4.playSong();

        System.out.println();

        PlayerNoFive player5 = new PlayerNoFive(1100);
        player5.playAllSongs();
        player5.playSong();

        System.out.println();

        PlayerNoSix player6 = new PlayerNoSix(6000);
        player6.shuffle();
        player6.playAllSongs();

    }
}
