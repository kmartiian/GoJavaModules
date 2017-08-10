package mp3PlayerBase;

import java.util.Random;

public class PlayerNoSix extends PlayerNoThree{

    public PlayerNoSix(int price) {
        super(price);
    }


    public void shuffle(){
        String[] newList = new String[playlist.length];
        Random random = new Random();

        int ind = random.nextInt(playlist.length);
        newList[ind] = playlist[0];

        for (int i=1; i<playlist.length; i++){
            while (newList[ind] != null && newList[ind].length()>0){
                ind = random.nextInt(playlist.length);
            }
            newList[ind] = playlist[i];
        }

        for (int i=0; i<newList.length; i++) {
            playlist[i] = newList[i];
        }
    }
}
