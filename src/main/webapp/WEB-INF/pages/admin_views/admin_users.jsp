<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="default_admin">
    <tiles:putAttribute name="body">
        <div class="container" ng-app="admin.users" ng-controller="users">
            <h1><spring:message code="admin_main.users_ref"/></h1>
            <table class="table table-hover" ng-if="!edit">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>Enabled</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-click="user_edit(user)" ng-repeat="user in users">
                        <td>{{user.id}}</td>
                        <td>{{user.username}}</td>
                        <td>{{user.enabled === 1 ? true : false}}</td>
                    </tr>
                </tbody>
            </table>
            <table class="table" ng-if="edit">
                <tr>
                    <td>User name</td> 
                    <td>Enabled</td>
                </tr>
                <tr>
                    <td><input ng-model="user.username"><input ng-model="user.id" hidden></td> 
                    <td><input class="checkbox" style="margin: auto" type="checkbox" ng-model="user.enabled" ng-checked="user.enabled === 1 ? true : false"></td>
                </tr>
                <tr>
                    <td><button class="btn-default" ng-click="update()">{{edit ? "Edit" : "Add"}}</button></td>
                    <td><button class="btn-default" ng-click="back()">Back</button></td>
                </tr>
            </table>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
<spring:message code="admin_main.header"/>  

