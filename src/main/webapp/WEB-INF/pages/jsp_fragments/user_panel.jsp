<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<sec:authorize access="hasRole('ROLE_USER')">
    <c:url value="/logout" var="logoutUrl" />
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="" id="user_panel">
                User : ${pageContext.request.userPrincipal.name} | <a
                    href="javascript:formSubmit()"> Logout</a>
        </div>
    </c:if>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
    <div id="user_panel">
        <spring:message code="user_panel.unregistred"/>
        <a href="login">Log In</a>
        <a href="/registration">Register</a>
    </div>
</sec:authorize>
