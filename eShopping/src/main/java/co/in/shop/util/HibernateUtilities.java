package co.in.shop.util;

import org.hibernate.cfg.Configuration;

public class HibernateUtilities {
  private static org.hibernate.SessionFactory dbFactory;
  
  public  HibernateUtilities() {}
  
  public static org.hibernate.SessionFactory getDbSessionFactory() { Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");
    org.hibernate.SessionFactory dbFactory = cfg.buildSessionFactory();
    

    return dbFactory;
  }
}