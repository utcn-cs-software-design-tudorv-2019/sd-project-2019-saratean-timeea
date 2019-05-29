package hello.dataAccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import hello.entities.Room;

@Service
public class RoomAccess {
	public Room getRoom(int id) {
		Room room = new Room();
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			room = (Room) sessionObj.get(Room.class, id);
			sessionObj.close();
		} catch (Exception e) {
			System.out.println("Not working");
		}
		return room;
	}

	public void addRoom(Room h) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(h);
			sessionObj.getTransaction().commit();
			sessionObj.close();
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}

	public void deleteRoom(int id) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			Room room = sessionObj.find(Room.class, id);
			sessionObj.remove(room);
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Not working");
			e.printStackTrace();
		}
	}

	public void updateRoom(Room h) {
		try {
			deleteRoom(h.getNumber());
			addRoom(h);
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}
	public List<Room> getAll() {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			Query<Room> query = sessionObj.createQuery("from Room");
			List<Room> offerts = query.getResultList();
			return offerts;
		} catch (Exception e) {
			System.out.println("Not working");
			return null;
		}
	}
}
