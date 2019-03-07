package co.in.shop.vo;

import java.util.List;

import co.in.shop.bean.ShopUser;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "UserDetail")


public class ShopUserVO implements Serializable {
	
	   @XmlElement(name = "UserDetails")
private List<ShopUser> UserDetails=null;

	public List<ShopUser> getUserDetails() {
		return UserDetails;
	}

	public void setUserDetails(List<ShopUser> userDetails) {
		UserDetails = userDetails;
	}


}


