package main;

import java.util.List;

import externalServices.MailService;
import hello.dataAccess.RoomAccess;
import hello.dataAccess.UserAccess;
import hello.entities.Room;

public class Main {
	public static void main(String args[]) {
		MailService mailService = new MailService("timisarateannn@gmail.com","steaua2586");
		mailService.sendMail("timisaratean@yahoo.com","Dummy Mail Title","alogara");
		
	}
}
