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

        <script src="<c:url value="/scripts/node_modules/core-js/client/shim.min.js"/>"></script>
        <script src="<c:url value="/scripts/node_modules/zone.js/dist/zone.js"/>"></script>
        <script src="<c:url value="/scripts/node_modules/reflect-metadata/Reflect.js"/>"></script>
        <script src="<c:url value="/scripts/node_modules/systemjs/dist/system.src.js"/>"></script>
        <!-- 2. Configure SystemJS -->
        <script src="<c:url value="/scripts/systemjs.config.js"/>"></script>
        <script>
            System.import('admin').catch(function (err) {
                console.error(err);
            });
        </script>
    </head>
    <body>
        <tiles:insertAttribute name="user_panel"/>
        <tiles:insertAttribute name="body"/>
    </body>
</html>
