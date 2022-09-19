package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("CheckIn date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("CheckOut date (dd/MM/yyyy): ");
		Date CheckOut = sdf.parse(sc.next());
		
		if(!CheckOut.after(checkIn)) {
			System.out.println("Error in reservatioin: CheckOut date must be after checkIn date");
		}else {
			Reservation reservation = new Reservation(number, checkIn, CheckOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			CheckOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if(checkIn.before(now) || CheckOut.before(now)) {
				System.out.println("Error in reservatioin: CheckOut date must be after checkIn date");
			}else if(!CheckOut.after(checkIn)) {
				System.out.println("Error in reservatioin: CheckOut date must be after checkIn date");
			}else {
				reservation.updateDates(checkIn, CheckOut);
				System.out.println("Reservation: " + reservation);	
			}
			
			
		}
		
		
		sc.close();

	}

}
