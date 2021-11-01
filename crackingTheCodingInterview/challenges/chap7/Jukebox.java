package chap7;

import java.util.HashMap;
import java.util.HashSet;


public class Jukebox {
    /**
     * Design a Jukebox. IDK what this is but imma search.
     * Alright, it's a machine that play a song that you choose
     * when you insert a Coin
     *
     */

    /**
     * I will add a JBMusic class so that I can put there
     * the attributes of each song, and here I will just
     * put a hashmap of the songs
     */

    HashMap<Integer, JBMusic> songs;
    int numberOfSongs;
    HashSet<JBMusic> songsSet;

    public Jukebox(){
        songs = new HashMap<>();
        numberOfSongs = 0;
        songsSet = new HashSet<>();
    }

    public void addSong(JBMusic song){
        numberOfSongs++;
        songs.put(numberOfSongs, song);
        songsSet.add(song);
    }
    /**
     * Now every song has a number, and that way we can configure the JukeBox
     */

    public void modifyNumberAndSong(int num, JBMusic song){
        songsSet.remove(songs.get(num));
        songs.put(num, song);
        songsSet.add(song);
    }

    public void removeSong(int num, JBMusic song){
        songsSet.remove(song);
        songs.put(num, song);
    }

    /**
     * Choose song with a number
     */
    public void chooseSong(int num, int money){
        if(!songs.keySet().contains(num)){
            throw new IllegalArgumentException();
        }
        JBMusic chosen = songs.get(num);
        if(money> chosen.cost){
            playSong(chosen);
        }
        else{
            System.out.println("Not enought money man");
        }
    }

    public void playSong(JBMusic song){
        /*
        Playing...
         */
    }


}
