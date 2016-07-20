import { Component } from '@angular/core';
import { User_CtrlComponent } from './components/user_controller/user_ctrl.component';
import { User_Service } from './service/user_service';

@Component({
  selector: 'main-comp',
  templateUrl: '../scripts/admin/app.component.html',
  directives: [User_CtrlComponent],
  providers: [User_Service]
})
export class AppComponent { }