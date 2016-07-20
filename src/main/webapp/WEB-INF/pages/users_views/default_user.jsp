<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <link href="styles/stylesheet.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                margin: 0px 0px 0px 0px;
            }
        </style>
    </head>   
    <body>       
            <tiles:insertAttribute name="admin_panel" />
            <tiles:insertAttribute name="user_panel"/>
            <tiles:insertAttribute name="body"/>
    </body>
</html>
