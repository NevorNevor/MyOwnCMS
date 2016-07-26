import { Component } from '@angular/core';
import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { User_Role } from '../model/user_role.model';
import { Response_JSON } from '../../components_library/response_json/response_json';

@Injectable()
export class UserRole_Service {  
    headers: Headers = new Headers({ 'Content-Type': 'application/json' });

    constructor(private http: Http) { }

    getAllRoles(onSuccessFunc){
        let roles: User_Role[] = [];
        this.http.request('/roles').subscribe((res: Response) => {
            let data = res.json();
            for (let role of data){
                roles.push(role);
            }
            console.log("user_role_service/getAllRoles - success ");
            onSuccessFunc(true);
        }, (error: Response) => {
            console.log("user_role_service/getAllRoles - error: ", error.statusText);
            onSuccessFunc(false);
        });
        return roles;
    }

    getUserRoles(user_id, onSuccessFunc){
        let roles: User_Role[] = [];
        this.http.request('/roles/' + user_id).subscribe((res: Response) => {
            let data = res.json();
            for (let role of data){
                roles.push(role);
            }
            console.log("user_role_service/getUserRoles - success ");
            onSuccessFunc(true);
        }, (error: Response) => {
            console.log("user_role_service/getUserRoles - error: ", error.statusText);
            onSuccessFunc(false);
        });
        return roles;
    }

    setUserRole(role, user_id, onSuccessFunc){
        this.http.put('/roles/' + user_id, role, this.headers).subscribe((res: Response) => {
            let response = new Response_JSON(res);
            console.log(`user_role_service/setUserRole. Try to set role: ${role} to user with id: ${user_id} - result: ${response.getMessage()}`);
            onSuccessFunc(true);
        }, (error: Response) => {
            console.log("user_role_service/setUserRole - error: ", error.statusText);
            onSuccessFunc(false);
        });
    }

    deleteUserRole(role, user_id, onSuccessFunc){
        this.http.delete(`/roles/${user_id}/${role}`, this.headers).subscribe((res: Response) => {
            let response = new Response_JSON(res);
            console.log(`user_role_service/deleteUserRole. Try to delete role: ${role} from user with id: ${user_id} - result: ${response.getMessage()}`);
            onSuccessFunc(true);
        }, (error: Response) => {
            console.log("user_role_service/deleteUserRole - error: ", error.statusText);
            onSuccessFunc(false);
        });
    }

    deleteRole(role, onSuccessFunc){
        this.http.delete('/roles/' + role, this.headers).subscribe((res: Response) => {
            let response = new Response_JSON(res);
            console.log(`user_role_service/deleteRole: ${role} with result: ${response.getMessage()}`);
            onSuccessFunc(true);
        }, (error: Response) => {
            console.log("user_role_service/deleteRole - error: ", error.statusText);
            onSuccessFunc(false);
        });
    }

}