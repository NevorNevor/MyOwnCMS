<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="default_admin">
    <tiles:putAttribute name="body">
        <spring:message code="admin_main.header"/>
        <a href="users"><spring:message code="admin_main.users_ref"/></a>
    </tiles:putAttribute>
</tiles:insertDefinition>
