package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.Singleton;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Artist;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Critic;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.RegisteredUser;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.User;

public class UserSingleton {

    private static UserSingleton myObj;

    private String type;
    private RegisteredUser registeredUser;
    private Artist artist;
    private Critic critic;
    private User user;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.user = registeredUser;
        this.registeredUser = registeredUser;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.user = registeredUser;
        this.artist = artist;
    }

    public Critic getCritic() {
        return critic;
    }

    public void setCritic(Critic critic) {
        this.user = registeredUser;
        this.critic = critic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private UserSingleton(){

    }
    /**
     * Create a static method to get instance.
     */
    public static UserSingleton getInstance(){
        if(myObj == null){
            myObj = new UserSingleton();
        }
        return myObj;
    }

}
