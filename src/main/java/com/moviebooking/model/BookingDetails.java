package com.moviebooking.model;

import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class BookingDetails {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int bookingId;
	@OneToOne
	private Movie movie;
	private int seatNumbers;
	private Date bookingDate;
	private String gallery;
	private int price;
	
	
	public String getGallery() {
		return gallery;
	}
	public void setGallery(String gallery) {
		this.gallery = gallery;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public int getSeatNumbers() {
		return seatNumbers;
	}
	public void setSeatNumbers(int seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
}
