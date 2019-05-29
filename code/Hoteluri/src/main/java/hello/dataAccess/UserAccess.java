package hello.dataAccess;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import hello.entities.Profile;
import hello.entities.User;

@Service
public class UserAccess {
	public User getUser(int id) {
		User user = new User();
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			user = (User) sessionObj.get(User.class, id);
			sessionObj.close();
			return user;
		} catch (Exception e) {

			return user;
		}

	}
   
	public int loginUser(String name, String password) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			Query<User> query = sessionObj.createQuery("from User");
			List<User> users = query.getResultList();
			for (User user : users) {
				if (user.getName().equals(name)) {
					if (user.getPassword().equals(password)) {
						sessionObj.close();
						return user.getType();
					}
				}
			}
			sessionObj.close();
			return -1;
		} catch (Exception e) {
			return -2;
		}
	}

	public int addUser(String name, String password) {
		Random rand = new Random();
		int id = rand.nextInt(300);
		try {
			User user = new User(id, 0, id, name, password);
			Profile profile = new Profile(id);
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(profile);
			sessionObj.getTransaction().commit();
			sessionObj.beginTransaction();
			sessionObj.save(user);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not working");
		}
		return -1;
	}
}
