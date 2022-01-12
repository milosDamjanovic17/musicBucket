package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tracks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTrack;
	private String artist;
	private String title;
	private String bpm;
	private String genre;
	private String label;
	private String year;
	private Double price;
	
	public Integer getIdTrack() {
		return idTrack;
	}
	public void setIdTrack(Integer idTrack) {
		this.idTrack = idTrack;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBpm() {
		return bpm;
	}
	public void setBpm(String bpm) {
		this.bpm = bpm;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
