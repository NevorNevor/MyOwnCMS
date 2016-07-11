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
var user_component_1 = require('../user_item/user.component');
var user_service_1 = require('../../service/user_service');
var User_ListComponent = (function () {
    function User_ListComponent(user_service) {
        this.user_service = user_service;
        this.users = this.user_service.getUsers();
        //[new User(1, 'Vasya', true), new User(2, 'Sasha', false)];    
    }
    User_ListComponent.prototype.load = function () {
        console.log(this.users);
    };
    User_ListComponent = __decorate([
        core_1.Component({
            selector: 'user-list',
            templateUrl: '../scripts/admin/components/user_list/user_list.component.html',
            directives: [user_component_1.UserComponent]
        }), 
        __metadata('design:paramtypes', [user_service_1.User_Service])
    ], User_ListComponent);
    return User_ListComponent;
}());
exports.User_ListComponent = User_ListComponent;
//# sourceMappingURL=user_list.component.js.map