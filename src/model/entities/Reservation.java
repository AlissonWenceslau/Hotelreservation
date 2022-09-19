package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	Integer roomNumber;
	Date checkIn;
	Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
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
	
	public void updateDates(Date checkIn, Date checkOut) {
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
