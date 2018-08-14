package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class Playlist {
	

	private int id;
	private String name;
	private Date dateOfCreation;
	private String genre;


	private List<Song> songs;
	

	private RegisteredUser owner;
	
	public Playlist() {
		songs = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public RegisteredUser getOwner() {
		return owner;
	}

	public void setOwner(RegisteredUser owner) {
		this.owner = owner;
	}
	
	public void addSongToPlaylist(Song song) {
		this.songs.add(song);
		if(!song.getPlaylists().contains(this)) {
			song.getPlaylists().add(this);
		}
	}
	
	public void removeSongFromPlaylist(Song song) {
		
		this.songs.remove(song);
		if(song.getPlaylists().contains(this)) {
			song.getPlaylists().remove(this);
		}
		
	}
	
	public void set(Playlist playlist) {
		
		this.setDateOfCreation(playlist.getDateOfCreation() != null ? playlist.getDateOfCreation() : this.getDateOfCreation());
		this.setGenre(playlist.getGenre() != null ? playlist.getGenre() : this.getGenre());
		this.setName(playlist.getName() != null ? playlist.getName() : this.getName());
		this.setOwner(playlist.getOwner() != null ? playlist.getOwner() : this.getOwner());
		
		if(playlist.getSongs() != null) {
			if(this.getSongs() == null) {
				this.setSongs(playlist.getSongs());
			}
			else if(!playlist.getSongs().equals(this.getSongs())) {
				this.setSongs(playlist.getSongs());
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Playlist) {
			Playlist playlist = (Playlist) obj;
			if(this.id == playlist.id) {
				return true;
			}
		}
		return false;
	}
	
	
	
	

}
