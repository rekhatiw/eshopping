package co.in.shop.util;
import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import co.in.shop.vo.ShopUserVO;
import co.in.shop.bean.ShopUser;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageEnq 
{
	private ActiveMQConnectionFactory connectionFactory ;
	private Connection connection ;     	 
	private Session session ;	 
	private Queue queue;
	private MessageProducer producer; 
	
	 public void createQueue(ShopUserVO shopUser) throws JMSException
	 {
	  connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	  connection = connectionFactory.createConnection();    
	  connection.start();
	  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	  queue = session.createQueue("ShopUserQ");
    
    // Create a producer for test_queue			    	        
      producer = session.createProducer(queue);
      ObjectMessage objMsg = session.createObjectMessage();
      System.out.println("inside queue"+shopUser.getUserDetails().size());
  	  objMsg.setObject(shopUser);   
      producer.send(objMsg );
      //session.commit();
      //session.close();
      connection.close();
	 }
}
