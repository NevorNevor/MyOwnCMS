<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="root">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../scripts/angular.js" type="text/javascript"></script>
        <script src="../scripts/admin_root.js" type="text/javascript"></script>
        <script src="../scripts/angular-resource.js" type="text/javascript"></script>
        <title><spring:message code="admin_main.users_ref"/></title>
    </head>
    <body ng-controller="users">
        <spring:message code="admin_main.header"/>
        
        <h1><spring:message code="admin_main.users_ref"/></h1>
        <table ng-init="getUsers()">
            <tbody>
                <tr ng-repeat="user in users">
                    <td>{{user.id}}</td>
                    <td>{{user.name}}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
