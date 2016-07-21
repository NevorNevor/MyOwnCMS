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
        `.ng-valid[required] { 
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
    @Output('backToList') backToListEmitter = new EventEmitter();

    constructor(formBuilder: FormBuilder, private user_service: User_Service) {
        this.userForm = formBuilder.group({
            'id': [''],
            'username': [''],
            'enabled': ['']
        })
    }

    public showUser(user: User) {
        this.userForm.controls['id'].updateValue(user.id);
        this.userForm.controls['username'].updateValue(user.username);
        this.userForm.controls['enabled'].updateValue(user.enabled);
        console.log("admin/UserForm - showUser(", user,")");
    }

    onSubmit(value) {
        value.enabled = value.enabled ? 1 : 0;
        this.loading = true;
        this.user_service.setUser(value, () => {
            this.backToList();
            this.loading = false;
        });
        console.log("admin/UserForm - onSubmit(", value, ")");
    }

    backToList() {
        this.backToListEmitter.emit(true);
        console.log("admin/UserForm - backToList(", true, ")");
    }
}