package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.Singleton;

import java.util.List;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Playlist;

public class PlaylistSingleton {

    private List<Playlist> mPlaylists;

    private static PlaylistSingleton myObj;

    private int mSelecetedPlayList;
    /**
     * Create private constructor
     */
    private PlaylistSingleton(){

    }
    /**
     * Create a static method to get instance.
     */
    public static PlaylistSingleton getInstance(){
        if(myObj == null){
            myObj = new PlaylistSingleton();
        }
        return myObj;
    }

    public List<Playlist> getmPlaylists() {
        return mPlaylists;
    }

    public void setmPlaylists(List<Playlist> mPlaylists) {
        this.mPlaylists = mPlaylists;
    }

    public int getmSelecetedPlayList() {
        return mSelecetedPlayList;
    }

    public void setmSelecetedPlayList(int mSelecetedPlayList) {
        this.mSelecetedPlayList = mSelecetedPlayList;
    }
}
