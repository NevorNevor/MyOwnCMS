<%-- 
    Document   : registration
    Created on : 09.04.2016, 20:21:56
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><spring:message code="registr.header"/></h1>
        <form name="registration" method="POST">
            <c:if test="${not empty error}">
                <p><spring:message code="registr.param.error"/></p>
            </c:if>
            <c:if test="${not empty registred}">
                <p><spring:message code="registr.param.success"/></p>
            </c:if>      
            <label><spring:message code="registr.name"/></label>
            <input type="text" name="name" value="" />
            <label><spring:message code="registr.password"/></label>
            <input type="text" name="password" value="" />
            <label><spring:message code="registr.email"/></label>
            <input type="text" name="email" value="" />
            <input type="submit" value="<spring:message code="registr.submit"/>"/>
        </form>
    </body>
</html>
