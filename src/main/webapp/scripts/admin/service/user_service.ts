import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { User } from '../model/user.model';
import { Response_JSON } from '../../components_library/response_json/response_json';

@Injectable()
export class User_Service {
    headers: Headers = new Headers({ 'Content-Type': 'application/json' });

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
            onSuccessFunc();
        }, (error: Response) => {
            console.log("user_service/setUser - error: ", error.statusText);
        })
    }

}