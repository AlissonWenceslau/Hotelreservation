package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	
	Integer roomNumber;
	Date checkIn;
	Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		//Programação defensiva = 
		if(!checkOut.after(checkIn)) {
			throw new DomainException("CheckOut date must be after checkIn date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNUmber() {
		return roomNumber;
	}

	public void setRoomNUmber(Integer roomNUmber) {
		this.roomNumber = roomNUmber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			//throw new IllegalArgumentException("Reservation dates for updates must be future dates");
			throw new DomainException("Reservation dates for updates must be future dates");
		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return 
				"Rservation: "
				+ roomNumber
				+ ", "
				+"CheckIn: "
				+sdf.format(checkIn)
				+", "
				+"CheckOut: "
				+sdf.format(checkOut)
				+", "
				+duration()
				+" nights";
	}
	
}
