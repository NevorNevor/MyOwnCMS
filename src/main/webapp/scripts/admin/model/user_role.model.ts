export class User_Role{
    user_id:number;
    authority:string;

    constructor(user_id:number, authority:string) {
        this.user_id = user_id;
        this.authority = authority;
     }

     toControllerParams():string{
         return `${this.user_id}/${this.authority}`;
     }

}