import { Component, Input } from '@angular/core';
import { User } from '../../model/user.model';

@Component({
    selector: '[user]',
    template:
    `<td>{{user.id}}</td>
    <td>{{user.username}}</td>
    <td><input type="checkbox" [ngModel]="user.enabled"></td>`
})
export class UserComponent {
    @Input() user: User;
}