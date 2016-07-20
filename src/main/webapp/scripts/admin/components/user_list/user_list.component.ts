import { Component, Output, EventEmitter } from '@angular/core';
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
  @Output('userPick') userPickEmitter = new EventEmitter();

  constructor(private user_service: User_Service) {
    this.users = this.user_service.getUsers();    
  }

  userPick(user:User){
    this.userPickEmitter.emit(user);
  }
}