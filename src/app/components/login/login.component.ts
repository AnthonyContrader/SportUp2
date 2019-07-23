import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';

import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { LoginDTO } from 'src/app/dto/LoginDTO';
import { UserDTO } from 'src/app/dto/UserDTO';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userDTO: UserDTO;
  loginDTO: LoginDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((token : any) => {
      localStorage.setItem("AUTOKEN", JSON.stringify({ "authorities": token.id_token }));
      localStorage.setItem("currentUser", JSON.stringify({ "authorities": token.id_token }));
      this.service.userLogged(this.loginDTO.username).subscribe((user:UserDTO)=>{

      if (user != null) {
        localStorage.setItem('AUTOKEN', JSON.stringify(user));
        console.log(user.authorities);
        if(user.authorities == "ROLE_ADMIN" ) {
          this.router.navigate(['/homeAdmin']);
        }
        if(user.authorities == "ROLE_PLAYER") {
          this.router.navigate(['/homePlayer/'+ user.idUser ]);
        }
        if(user.authorities == "trainer") {
            this.router.navigate(['/homeTrainer']);
          }
       
      }else{
          alert("Wrong username or password");
        }
      });
    });
    }
}