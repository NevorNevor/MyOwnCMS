import { Component } from '@angular/core';
import { UserComponent } from '../user_item/user.component';
import { User } from '../../model/user.model';
import { User_Service } from '../../service/user_service';

@Component({
  selector: 'user-list',
  templateUrl: '../scripts/admin/components/user_list/user_list.component.html',
  directives: [UserComponent]
})
export class User_ListComponent {
  users: User[];

  constructor(private user_service: User_Service) {
    this.users = this.user_service.getUsers();
    //[new User(1, 'Vasya', true), new User(2, 'Sasha', false)];    
  }

  load() {
    console.log(this.users);
  }
}