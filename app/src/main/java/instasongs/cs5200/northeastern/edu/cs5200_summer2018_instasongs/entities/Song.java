package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class Song {

	private int id;
	private String name;
	private Long playCount;
	private String imageUrl;
	private String streamUrl;
	

	private Album album;
	

	private List<Review> reviewsRecieved;
	

	private List<Playlist> playlists;
	

	private List<Artist> artists;
	
	
	public Song() {
		playlists =new ArrayList<>();
		artists = new ArrayList<>();
		reviewsRecieved = new ArrayList<>();
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	
	public void addPlaylistToSong(Playlist playlist) {
		this.playlists.add(playlist);
		if(!playlist.getSongs().contains(this)) {
			playlist.getSongs().add(this);
		}	
	}
	
	
	
	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	
	public List<Review> getReviewsRecieved() {
		return reviewsRecieved;
	}

	public void setReviewsRecieved(List<Review> reviewsRecieved) {
		this.reviewsRecieved = reviewsRecieved;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getStreamUrl() {
		return streamUrl;
	}

	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}

	public Long getPlayCount() {
		return playCount;
	}

	public void setPlayCount(Long playCount) {
		this.playCount = playCount;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Song) {
			Song song = (Song) obj;
			if(this.id == song.id) {
				return true;
			}
		}
		return false;
	}

	public void set(Song song) {
		this.setAlbum(song.getAlbum() != null ? song.getAlbum() : this.getAlbum());
		this.setPlayCount(song.getPlayCount() != null ? song.getPlayCount() : this.getPlayCount());
		this.setName(song.getName() != null ? song.getName() : this.getName());
		this.setImageUrl(song.getImageUrl() != null ? song.getImageUrl() : this.getImageUrl());
		this.setStreamUrl(song.getStreamUrl() != null ? song.getStreamUrl() : this.getStreamUrl());

		if(song.getPlaylists() != null) {
			if(this.getPlaylists() == null) {
				this.setPlaylists(song.getPlaylists());
			}
			else if(!song.getPlaylists().equals(this.getPlaylists())) {
				this.setPlaylists(song.getPlaylists());
			}
		}
		
		if(song.getArtists() != null) {
			if(this.getArtists() == null) {
				this.setArtists(song.getArtists());
			}
			else if(!song.getArtists().equals(this.getArtists())) {
				this.setArtists(song.getArtists());
			}
		}
	}
	
	
	
	

}
