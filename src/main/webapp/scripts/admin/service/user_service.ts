import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { User } from '../model/user.model';
import { Response_JSON } from '../../components_library/response_json/response_json';

@Injectable()
export class User_Service {
    loading: boolean = false;
    headers: Headers = new Headers({'Content-Type': 'application/json'});
    
    constructor(private http: Http) { }

    getUsers(): User[] {
        let users: User[] = [];
        this.loading = true;
        this.http.request('../users').subscribe((res: Response) => {
            let data = res.json();
            this.loading = false;
            for (let user of data) {
                users.push(user);
            }
        });
        console.log("user_service/getUsers - success");
        return users;
    }

    setUser(user: User) {
        this.loading = true;
        this.http.put('../users', user, this.headers).subscribe((res: Response) => {
            let response = new Response_JSON(res);
            this.loading = false;
            console.log("user_service/setUser(", user, ") - " + response.getMessage());
        },(error: Response) =>{
            console.log("user_service/setUser - error: ", error.statusText);
        })
    }

}