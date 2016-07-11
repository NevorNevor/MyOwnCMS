import { Component } from '@angular/core';
import { User_CtrlComponent } from './components/user_controller/user_ctrl.component';

@Component({
  selector: 'main-comp',
  templateUrl: '../scripts/admin/app.component.html',
  directives: [User_CtrlComponent]
})
export class AppComponent { }