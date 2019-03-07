package co.in.shop.util;
import co.in.shop.vo.ShopUserVO;
import co.in.shop.dao.ShopDao;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ConvertXmlToObject {
	
	private static String fileName="user.xml";

	public static void convert(ShopUserVO shopuserVo) 
	{	

	
	try {
        JAXBContext context = JAXBContext.newInstance(ShopUserVO.class);
        Marshaller m = context.createMarshaller();
        //for pretty-print XML in JAXB
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      //  System.out.println("checking inside convert class"+shopuserVo.getEmail());
       
        	
        m.marshal(shopuserVo, new File("C:\\\\Rekha\\\\user.xml"));
        
    } catch (JAXBException e) {
        e.printStackTrace();
    }
	
	
}

		
	}


