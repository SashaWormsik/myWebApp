<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="by.sasha.myWebApp.service.User" %>
<%@ page import="java.util.Date" %>


<html>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="currUser" scope="request"
         value="${requestScope.user}"/>

<%Date userBirth = ((User) request.getAttribute("currUser")).getBirthdate();
    String birthdate = new SimpleDateFormat("yyyy-MM-dd").format(userBirth); %>

<form action="userEdit?number=${param.number}" method="POST">

    First Name: <input type="text" name="firstName"
                       value="${currUser.firstName}"
                       placeholder=${currUser.firstName}>

    <br/>

    Last Name: <input type="text" name="lastName"
                      value="${currUser.lastName}"
                      placeholder=${currUser.lastName}>

    <br/>
    BirthDate: <input type="text" name="birthdate"
                      value= "<%= birthdate %>"
                      placeholder=<%= birthdate %>>

    <br/>

    <c:choose>
        <c:when test="${currUser.male}">
            <input type="radio" id="male" name="male" value="true" checked> <label for="male">Male</label><br>
            <input type="radio" id="female" name="male" value="false"> <label for="female">Female</label><br>
        </c:when>
        <c:otherwise>
            <input type="radio" id="male" name="male" value="true"> <label for="male">Male</label><br>
            <input type="radio" id="female" name="male" value="false" checked> <label for="female">Female</label><br>
        </c:otherwise>
    </c:choose>

    <input type="submit" value="Submit"/>

</form>
</body>
</html>
