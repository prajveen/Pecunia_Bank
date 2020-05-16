import { Component, OnInit } from '@angular/core';
import { LoginserviceService, account} from '../loginservice.service';
import { Router } from '@angular/router';
import { Login } from '../login';
import { ServiceService } from '../service.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: Login = {employeeID: "",username: "",password: ""};
  login1: Login = {employeeID: "",username: "",password: ""};

  details: any;
  details1: any;
  username: any;
  password: any;
  private router: Router;
  values: any;
  check: boolean = false;
  check1: boolean = false;
  check3: any;

  constructor(private service: ServiceService, router: Router) {
    this.router = router;
  }

  ngOnInit(): void {
  }

  validate() {
    this.service.validateEmail(this.login.username, this.login.password).subscribe((data) => {
      this.details = data,error=>this.details= JSON.parse(error.error).message;
      
      if (this.details == "no user found") {
        alert("Ooops..! Invalid username/password .");
        this.router.navigate(['/Login']);
      }
      else {
        alert("Login Successfull");
        this.login1 = this.details;
        console.log(this.login1);
        this.router.navigate(['/account']);
      }
    });


  }
}
