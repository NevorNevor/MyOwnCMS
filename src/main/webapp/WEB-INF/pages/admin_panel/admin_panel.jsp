<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <style>
        *{
            font-size: 18px; 
        }

        #admin_panel{
            /*position: absolute;*/
            background: background;
            background: linear-gradient(to top left, #d9edf7, skyblue);
            top: 0px;
            left: 0px;
            height: 30px;
            width: 100%; 
            margin: 0px 0px 0px 0px;
        }

        a {
            position: absolute;
            right: 20px;
            margin-top: 3px;
            border: 0px;
        }

        #admin_panel_text{
            position: absolute;
            margin-top: 3px;
            left: 10px;        
        }
    </style>
    <div id="admin_panel">
        <form name="adminPanel">
            <p id="admin_panel_text">Admin Parametr Only</p>
            <a href="adminpanelpage">Панель администратора</a>
        </form>           
    </div>
    <p>AdminPanel</p>
</sec:authorize>
