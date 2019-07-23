import { Injectable } from '@angular/core';

import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { Observable, of } from 'rxjs';
import { UserDTO } from '../dto/UserDTO';
import { LoginDTO } from '../dto/LoginDTO';


@Injectable({
  providedIn: 'root'
})
export class UserService {

    constructor(private http: HttpClient) {
  }
  auth() {
    const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;

    console.log(user.authorities + 'user');
    if (user) {
      return 'Bearer ' + user.authorities;
    } else {
      return '';
    }
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
}

  login(loginDTO: LoginDTO): Observable<UserDTO> {
     return this.http.post<any>('http://localhost:8080/api/authenticate', loginDTO);
  }
  userLogged(username: string) {
    // console.log('qua: ', this.auth());
     console.log(this.auth());
     return this.http.get('http://localhost:8080/api/users/' + username, {
       headers: {
         Authorization: this.auth()
       }
     });
  }

  getUsername(idUser: number): Observable<any> {
    // console.log('qua: ', this.auth());
     console.log(this.auth());
     return this.http.get<UserDTO>('http://localhost:8080/api/users/' + idUser, {
       headers: {
         Authorization: this.auth()
       }
     });
  }
  
  getAll(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>('http://localhost:8080/api/users' , {
      headers: {
        Authorization : this.auth()
      }
    });
  }
  insert(userdto: UserDTO): Observable<any> {
    console.log(userdto)
    return this.http.post<UserDTO>('http://localhost:8080/api/users',userdto, {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  update(userdto: UserDTO): Observable<any> {
    return this.http.put<UserDTO>('http://localhost:8080/api/users', userdto , {
      headers: {
        Authorization : this.auth()
      }
    });

  }



}


