<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <style>
            body{
                margin: 0px 0px 0px 0px;
            }
        </style>
    </head>   
    <body>
        <tiles:insertAttribute name="admin_panel" />
        <h1>YII ${adminpanel}</h1>
        <spring:message code="main.header"/>
        <a href="registration"><spring:message code="registr.header"/></a>
        <table>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.enabled}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </body>
</html>
