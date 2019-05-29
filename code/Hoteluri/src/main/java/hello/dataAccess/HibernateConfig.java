package hello.dataAccess;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	public static SessionFactory buildSessionFactory() {
		SessionFactory sessionFactoryObj = new Configuration().configure().buildSessionFactory();
		return sessionFactoryObj;
	}

}