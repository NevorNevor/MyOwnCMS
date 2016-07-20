import { Component, ViewChild } from '@angular/core';
import { User_ListComponent } from '../user_list/user_list.component';
import { User_FormComponent } from '../user_form/user_form.component';
import { User } from '../../model/user.model';

@Component({
    selector: 'user-ctrl',
    template:
    `<user-list *ngIf="user_list_show" (userPick)="showUserForm($event)"></user-list>
    <user-form [hidden]="user_list_show" (backToList)="showUserList($event)"></user-form>`,
    directives: [User_ListComponent, User_FormComponent]
})
export class User_CtrlComponent {
    private user_list_show: boolean = true;
    @ViewChild(User_FormComponent) 
    userForm : User_FormComponent;

    showUserList() {
        this.user_list_show = true;
    }

    showUserForm(user: User) {
        this.user_list_show = false;
        this.userForm.showUser(user);
    }
}