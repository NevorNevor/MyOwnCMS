import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { User } from '../model/user.model';

@Injectable()
export class User_Service {
    loading: boolean = false;

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
        return users;
    }



}