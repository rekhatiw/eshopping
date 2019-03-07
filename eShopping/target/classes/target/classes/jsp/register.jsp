<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="co.in.shop.dao.ShopDao"%>
<%@ page import="co.in.shop.bean.ShopUser"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
<jsp:useBean id="obj" class="co.in.shop.bean.ShopUser">  
</jsp:useBean>  
<jsp:setProperty property="*" name="obj"/>  

<%  
ShopDao dao= new ShopDao();
int i=dao.register(obj);  
if(i>0)  
	
//out.print("You are successfully registered!::::::::" +obj.getFirstName());
out.print("You will get Mail notification");  
  
%>  
<table>
<tr></tr><td>User Information</td></table>
<tr><td>Search Employee
<input type= "text" name="Search"></td>
</tr>
<tr><td>
<% 
//List<ShopUser> lst = new ArrayList();
//lst=dao.getUserDetails();
%>
</td></tr>



</body>
</html>