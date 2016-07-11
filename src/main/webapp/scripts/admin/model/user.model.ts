export class User {
    id:number;
    username:string;
    enabled:boolean;

    constructor(id:number,name:string,enabled:boolean){
        this.id = id;
        this.username = name;
        this.enabled = enabled;
    }
}