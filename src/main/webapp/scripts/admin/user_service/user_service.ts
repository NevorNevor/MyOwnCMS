import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { User } from '../model/user.model';
import { Response_JSON } from '../../components_library/response_json/response_json';

@Injectable()
export class User_Service {
    private headers: Headers = new Headers({ 'Content-Type': 'application/json' });

    constructor(private http: Http) { }

    getUsers(onSuccessFunc): User[] {
        let users: User[] = [];
        this.http.request('../users').subscribe((res: Response) => {
            let data = res.json();
            for (let user of data) {
                users.push(user);
            }
            console.log("user_service/getUsers - success ");
            onSuccessFunc();
        }, (error: Response) => {
            console.log("user_service/getUsers - error: ", error.statusText);
        });
        return users;
    }

    setUser(user: User, onSuccessFunc) {
        this.http.put('../users', user, this.headers).subscribe((res: Response) => {
            let response = new Response_JSON(res);
            console.log("user_service/setUser(", user, ") - " + response.getMessage());
            onSuccessFunc(true);
        }, (error: Response) => {
            console.log("user_service/setUser - error: ", error.statusText);
            onSuccessFunc(false);
        })
    }

    addUser(user: User, onSuccessFunc){
        this.http.post('../users', user, this.headers).subscribe((res: Response) => {
            let response = new Response_JSON(res);
            console.log("user_service/addUser(", user, ") - " + response.getMessage());
            onSuccessFunc(true);
        }, (error: Response) => {
            console.log("user_service/addUser - error: ", error.statusText);
            onSuccessFunc(false);
        })
    }

    deleteUser(user: User, onSuccessFunc){
        this.http.delete('../users/' + user.id, this.headers).subscribe((res: Response) => {
            let response = new Response_JSON(res);
            console.log("user_service/deleteUser(", user, ") - " + response.getMessage());
            onSuccessFunc(true);
        }, (error: Response) => {
            console.log("user_service/deleteUser - error: ", error.statusText);
            onSuccessFunc(false);
        })
    }

}