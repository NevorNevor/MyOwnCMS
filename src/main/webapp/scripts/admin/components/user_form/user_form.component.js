"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var forms_1 = require('@angular/forms');
var user_service_1 = require('../../service/user_service');
var User_FormComponent = (function () {
    function User_FormComponent(formBuilder, user_service) {
        this.user_service = user_service;
        this.backToListEmitter = new core_1.EventEmitter();
        this.userForm = formBuilder.group({
            'id': [''],
            'username': [''],
            'enabled': ['']
        });
    }
    User_FormComponent.prototype.showUser = function (user) {
        this.userForm.controls['id'].updateValue(user.id);
        this.userForm.controls['username'].updateValue(user.username);
        this.userForm.controls['enabled'].updateValue(user.enabled);
        console.log("admin/UserForm - showUser(", user, ")");
    };
    User_FormComponent.prototype.onSubmit = function (value) {
        value.enabled = value.enabled ? 1 : 0;
        this.user_service.setUser(value);
        this.backToList();
        console.log("admin/UserForm - onSubmit(", value, ")");
    };
    User_FormComponent.prototype.backToList = function () {
        this.backToListEmitter.emit(true);
        console.log("admin/UserForm - backToList(", true, ")");
    };
    __decorate([
        core_1.Output('backToList'), 
        __metadata('design:type', Object)
    ], User_FormComponent.prototype, "backToListEmitter", void 0);
    User_FormComponent = __decorate([
        core_1.Component({
            selector: 'user-form',
            templateUrl: '../scripts/admin/components/user_form/user_form.components.html',
            styles: [
                ".ng-valid[required] { \n                border-left: 5px solid #42A948;\n            }\n            ",
                ".ng-invalid {\n                border-left: 5px solid #a94442;\n            }\n            "],
            directives: [forms_1.FORM_DIRECTIVES, forms_1.REACTIVE_FORM_DIRECTIVES]
        }), 
        __metadata('design:paramtypes', [forms_1.FormBuilder, user_service_1.User_Service])
    ], User_FormComponent);
    return User_FormComponent;
}());
exports.User_FormComponent = User_FormComponent;
//# sourceMappingURL=user_form.component.js.map