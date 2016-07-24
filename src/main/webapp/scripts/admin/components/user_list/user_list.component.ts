import { Component, Output, EventEmitter } from '@angular/core';
import { UserComponent } from '../user_item/user.component';
import { User } from '../../model/user.model';
import { User_Service } from '../../user_service/user_service';

@Component({
  selector: 'user-list',
  template: `
    <h3 class="text-center">
      User list
    </h3>
    <button type="button" class="btn btn-default" (click)="newUser()">New User</button>
    <button type="button" class="btn btn-default" (click)="refresh()">Refresh</button>
    <table class="table table-condensed table-bordered table-hover">
      <thead><tr><th>ID</th><th>Name</th><th>Enabled</th></tr></thead>
      <tbody>
        <tr *ngFor="let user of users" [user]=user (click)="userPick(user)"></tr>
      </tbody>
    </table>
    <h3 *ngIf="loading" class="text-center">
      LOADING...
    </h3>
    `,
  directives: [UserComponent]
})
export class User_ListComponent {
  users: User[];
  loading: boolean = true;
  @Output('userPick') userPickEmitter = new EventEmitter();

  constructor(private user_service: User_Service) {
    this.refresh();
  }

  userPick(user: User) {
    this.userPickEmitter.emit(user);
  }

  newUser(){
    this.userPickEmitter.emit(null);
  }

  refresh(){
    this.users = this.user_service.getUsers(() => {
      this.loading = false;
    });
  }
}