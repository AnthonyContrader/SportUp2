import { StringMap } from '@angular/core/src/render3/jit/compiler_facade_interface';


/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 */
export class LoginDTO {

   username: string;

   password: string;

   constructor(username: string, password: string) {
       this.username = username;
       this.password= password;
   }
   
   
}