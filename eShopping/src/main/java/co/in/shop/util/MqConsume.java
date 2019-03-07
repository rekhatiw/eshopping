package co.in.shop.util;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Destination;
import co.in.shop.bean.ShopUser;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.Queue;
import co.in.shop.vo.ShopUserVO;
public class MqConsume {

	private ActiveMQConnectionFactory connectionFactory ;
	private Connection connection ;     	 
	private Session session ;	
	private Queue queue ;

	
	
	public void receiveValue() throws JMSException
	{    System.out.println("inside consumer::::");
		  connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		  System.out.println("inside connect::::");
		  connection = connectionFactory.createConnection();    
		  connection.start();
		  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		  System.out.println("inside start::::");
		//  session.createObjectMessage()
		  Destination destination = session.createQueue("ShopUserQ");
	      MessageConsumer consumer = session.createConsumer(destination);
          ObjectMessage obg= (ObjectMessage) consumer.receive(10000);
         // ShopUserVO shop=(ShopUserVO)obg;
         //System.out.println(""+shop.getUserDetails().size());
          ShopUserVO shopuser=(ShopUserVO) obg.getObject();
          System.out.println(shopuser.getUserDetails().size());
         // consumer.close();
          session.close();
          connection.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MqConsume consume= new MqConsume();
		try {
			consume.receiveValue();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
