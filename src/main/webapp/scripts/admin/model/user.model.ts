export class User {
    id:number;
    username:string;
    enabled:number;

    constructor(id:number,name:string,enabled:number){
        this.id = id;
        this.username = name;
        this.enabled = enabled;
    }

}