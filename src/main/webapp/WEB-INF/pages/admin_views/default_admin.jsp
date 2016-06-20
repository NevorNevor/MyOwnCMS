<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/styles/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/styles/bootstrap-theme.css"/>" rel="stylesheet" type="text/css"/>
        <script src="../scripts/angular.js" type="text/javascript"></script>
        <script src="../scripts/angular-resource.js" type="text/javascript"></script>
        <script src="../scripts/admin_js/admin_users.js" type="text/javascript"></script>
    </head>
    <body>
        <tiles:insertAttribute name="user_panel"/>
        <tiles:insertAttribute name="body"/>
    </body>
</html>
