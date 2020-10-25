<%@page import="by.sasha.myWebApp.service.User" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<html>

<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<br/>


<c:if test="${requestScope.users != null}">
    <table>
        <tr>
            <th>Num</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Birthdate</th>
            <th>Sex</th>
            <th>Actions</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="i" begin="0" end="${fn:length(requestScope.users)-1}">
            <c:set var="currUser" scope="request"
                   value="${requestScope.users[i]}"/>
            <tr>
                <td>${i+1}</td>
                <td>${requestScope.currUser.firstName}</td>
                <td>${requestScope.currUser.lastName}</td>
                <td>
                    <%
                        Date userBirth = ((User) request.getAttribute("currUser")).getBirthdate();
                        out.println(new SimpleDateFormat("yyyy-MM-dd").format(userBirth));
                    %>
                </td>
                <td><c:choose>
                    <c:when test="${requestScope.currUser.male}">Male</c:when>
                    <c:otherwise>Female</c:otherwise>
                </c:choose></td>
                <td><a href="http://localhost:8080/myWebApp/user/delete?number=${i}">Delete
                    user</a></td>
                <td><a href="http://localhost:8080/myWebApp/user/edit?number=${i}&firstName=${requestScope.currUser.firstName}&lastName=${requestScope.currUser.lastName}&birthdate=${requestScope.currUser.birthdate}&male=${requestScope.currUser.male}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a href="http://localhost:8080/myWebApp/jstl2.jsp">Add user</a>

<br/>
<br/>


</body>
</html>
