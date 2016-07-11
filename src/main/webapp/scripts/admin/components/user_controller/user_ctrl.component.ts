import { Component } from '@angular/core';
import { User_ListComponent } from '../user_list/user_list.component';
import { User_FormComponent } from '../user_form/user_form.component';

@Component({
    selector: 'user-ctrl',
    template: 
    `<user-list *ngIf="user_list_show"></user-list>
    <user-form *ngIf="!user_list_show"></user-form>`,
    directives: [User_ListComponent, User_FormComponent]
})
export class User_CtrlComponent {
    private user_list_show:boolean = true;

    showUserList(){
        this.user_list_show = true;
    }

    showUserForm(){
        this.user_list_show = false;
    }
}