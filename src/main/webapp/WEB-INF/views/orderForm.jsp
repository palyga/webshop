<%--
  Created by IntelliJ IDEA.
  User: Василь
  Date: 02.03.2015
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title></title>
</head>
<body>


<h2>Add New Order</h2>
<form:form method="post" action="/order" commandName="newOrder">
  <tr>
    <td><form:input path="destination" /></td>
  </tr>
  <tr>
    <td><form:input path="orderStatus" /></td>
  </tr>
  <td colspan="2">
    <input type="submit" value="Go"/>
  </td>
</form:form>

</body>
</html>
