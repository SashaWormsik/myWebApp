<%@page import="by.sasha.myWebApp.service.User" %>
<%@page import="by.sasha.myWebApp.service.UserService" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>

<form action = "/user/edit${param.id}" method = "POST">
    First Name: <input type = "text" name = "firstName" >
    <br />
    Last Name: <input type = "text" name = "lastName" >
    <br />
    BirthDate: <input type = "text" name = "birthdate" >
    <br />
    <input type="radio" id="male" name="male">
    <label for="male">Male</label><br>
    <input type="radio" id="female" name="male">
    <label for="female">Female</label><br>
    <input type="hidden" name="_method" value="put">
    <input type = "submit" value = "Submit" />
</form>
<!--POST localhost/webappsample/user?firstName=asd&lastName=qwe&birthdate=1234-12-12&male=true -->
</body>
</html>
