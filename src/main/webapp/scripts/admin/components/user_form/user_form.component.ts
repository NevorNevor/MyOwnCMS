import { Component, Input, AfterContentChecked, AfterContentInit, Output, EventEmitter } from '@angular/core';
import { User } from '../../model/user.model';
import {
    FORM_DIRECTIVES,
    REACTIVE_FORM_DIRECTIVES,
    FormBuilder,
    FormGroup,
    Validators,
    AbstractControl
} from '@angular/forms';
import { Control } from '@angular/common';
import { User_Service } from '../../service/user_service';

@Component({
    selector: 'user-form',
    templateUrl: '../scripts/admin/components/user_form/user_form.components.html',
    styles: [
        `.ng-valid { 
                border-left: 5px solid #42A948;
            }
            `,
        `.ng-invalid {
                border-left: 5px solid #a94442;
            }
            `],
    directives: [FORM_DIRECTIVES, REACTIVE_FORM_DIRECTIVES]
})
export class User_FormComponent {
    userForm: FormGroup;
    loading: boolean = false;
    newUser: boolean = false;
    @Output('backToList') backToListEmitter = new EventEmitter();

    constructor(formBuilder: FormBuilder, private user_service: User_Service) {
        this.userForm = formBuilder.group({
            'id': [''],
            'username': ['', Validators.compose([
                Validators.minLength(4),
                Validators.maxLength(15),
                Validators.required
            ])
            ],
            'password': ['', Validators.compose([
                Validators.minLength(6),
                Validators.maxLength(15),
                Validators.required
            ])
            ],
            'enabled': ['']
        })
    }

    public showUser(user: User) {
        if (user !== null) {
            this.userForm.controls['id'].updateValue(user.id);
            this.userForm.controls['username'].updateValue(user.username);
            this.userForm.controls['enabled'].updateValue(user.enabled);
            console.log("admin/UserForm - showUser(", user, ")");
        }else{
            this.newUser = true;
            this.userForm.controls['username'].updateValue("");
            this.userForm.controls['password'].updateValue("");
            this.userForm.controls['enabled'].updateValue(true);
            console.log("admin/UserForm - showUser - new user");
        }
    }

    onSubmit(value) {
        if (!this.newUser)
            this.setUser(value);
        else
            this.addUser(value);
        console.log("admin/UserForm - onSubmit(", value, ")");
    }

    backToList() {
        this.backToListEmitter.emit(true);
        this.newUser = false;
        console.log("admin/UserForm - backToList(", true, ")");
    }

    private setUser(value){
        value.enabled = value.enabled ? 1 : 0;
        delete value.password;
        this.loading = true;
        this.user_service.setUser(value, (result) => {
            if (result)
                this.backToList();
            this.loading = false;
        });
    }

    private addUser(value){
        value.enabled = value.enabled ? 1 : 0;
        delete value.id;
        this.loading = true;
        this.user_service.addUser(value, (result) => {
            if (result)
                this.backToList();
            this.loading = false;
        });
    }

    private deleteUser(value){
        value.enabled = value.enabled ? 1 : 0;
        delete value.password;
        this.loading = true;
        this.user_service.deleteUser(value, (result) => {
            if (result)
                this.backToList();
            this.loading = false;
        });
    }
}