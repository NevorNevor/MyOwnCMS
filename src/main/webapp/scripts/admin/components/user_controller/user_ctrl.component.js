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
var user_list_component_1 = require('../user_list/user_list.component');
var user_form_component_1 = require('../user_form/user_form.component');
var User_CtrlComponent = (function () {
    function User_CtrlComponent() {
        this.user_list_show = true;
    }
    User_CtrlComponent.prototype.showUserList = function () {
        this.user_list_show = true;
    };
    User_CtrlComponent.prototype.showUserForm = function () {
        this.user_list_show = false;
    };
    User_CtrlComponent = __decorate([
        core_1.Component({
            selector: 'user-ctrl',
            template: "<user-list *ngIf=\"user_list_show\"></user-list>\n    <user-form *ngIf=\"!user_list_show\"></user-form>",
            directives: [user_list_component_1.User_ListComponent, user_form_component_1.User_FormComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], User_CtrlComponent);
    return User_CtrlComponent;
}());
exports.User_CtrlComponent = User_CtrlComponent;
//# sourceMappingURL=user_ctrl.component.js.map