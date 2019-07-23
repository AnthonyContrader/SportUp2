
export class User {
    idUser: number;
    username: string;
    password: string;
    authorities: string;



    // tslint:disable-next-line:max-line-length
    constructor(userId: number, username: string, password: string, authorities: string) {
        this.idUser = userId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

}