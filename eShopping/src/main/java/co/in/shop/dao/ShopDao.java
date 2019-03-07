package co.in.shop.dao;

import co.in.shop.bean.ShopUser;
import co.in.shop.exception.EshopingException;
import co.in.shop.util.ConvertXmlToObject;
import co.in.shop.util.FileUtility;
import co.in.shop.util.HibernateUtilities;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jms.JMSException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import co.in.shop.vo.ShopUserVO;
import co.in.shop.util.MessageEnq;



public class ShopDao
{
  Session Db_session = HibernateUtilities.getDbSessionFactory().openSession();
  
  public ShopDao() {}
  
  public void loadFile() throws EshopingException, FileNotFoundException  {
/*    FileUtility fu = new FileUtility();
    HashMap<String, List> loadMap = new HashMap();
    ShopUser user = new ShopUser();
    loadMap = (HashMap)fu.loadFile();
	Transaction t = Db_session.beginTransaction();
	 Db_session.save(loadMap);
	 t.commit();
	 Db_session.close();  */
   
  }
  

  public int register(ShopUser user)
  {
    int i = 0;
    Transaction t = Db_session.beginTransaction();
    i = ((Integer)Db_session.save(user)).intValue();
    t.commit();
    Db_session.close();
    return i;
  }
  

  public ShopUserVO getUserDetails() throws JMSException
  {
	  MessageEnq msq =new MessageEnq();
	  ShopUserVO users= new ShopUserVO();
	List<ShopUser> lstUser = new ArrayList();
    String sqlQuery = "From ShopUser";
    Query query = Db_session.createQuery(sqlQuery);
    lstUser = query.list();
    users.setUserDetails(lstUser);
    ConvertXmlToObject.convert(users);
    System.out.println(users.getUserDetails().size());
    msq.createQueue(users);
    Db_session.close();
    
 
    return users;
  }
  
  public ShopUser passingMq() throws JMSException
  {
	  MessageEnq msq =new MessageEnq();
	  ShopUser users= new ShopUser();
	  users.setFirstName("Rekha");
	  users.setLastName("Tiwari");
	  users.setPassword("rekha");
	  users.setPhoneNo("100909090");
	  users.setEmail("rek.pandey@gmail.com");
	 //  msq.createQueue(users);
        return users;
  }
  
  public static void main(String[] args)
    throws FileNotFoundException, JMSException
  {
    ShopDao dao = new ShopDao();
   // dao.passingMq();
    dao.getUserDetails();
    /*try {
		dao.loadFile();
	} catch (EshopingException e) {
		// TODO Auto-generated catch block
		System.out.println("checking catch block"+e);
		e.printStackTrace();
	}*/
  }
}