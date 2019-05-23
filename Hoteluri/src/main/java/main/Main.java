package main;

import java.util.List;

import hello.dataAccess.RoomAccess;
import hello.dataAccess.UserAccess;
import hello.entities.Room;

public class Main {
	public static void main(String args[]) {
		RoomAccess user = new RoomAccess();
		//System.out.println(user.loginUser("timisaratean", "timi"));
		List<Room> rooms=user.getAll();
		for(Room r:rooms) {
			System.out.println(r.toString());
		}
		
	}
}
