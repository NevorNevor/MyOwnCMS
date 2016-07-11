import { Component, Input } from '@angular/core';
import { User } from '../../model/user.model';

@Component({
    selector: '[user]',
    template:
    `<td>{{user.id}}</td>
    <td>{{user.name}}</td>
    <td>{{user.enabled}}</td>`
})
export class UserComponent {
    @Input() user: User;
}