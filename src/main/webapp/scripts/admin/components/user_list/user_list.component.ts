import { Component } from '@angular/core';
import { UserComponent } from '../user_item/user.component';
import { User } from '../../model/user.model';

@Component({
  selector: 'user-list',
  templateUrl: '../scripts/admin/components/user_list/user_list.component.html',
  directives: [UserComponent]
})
export class User_ListComponent {
  users: User[];

  constructor() {
    this.users = [new User(1, 'Vasya', true), new User(2, 'Sasha', false)];
  }
}