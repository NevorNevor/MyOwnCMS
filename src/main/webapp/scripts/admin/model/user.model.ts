export class User {
    id:number;
    name:string;
    enabled:boolean;

    constructor(id:number,name:string,enabled:boolean){
        this.id = id;
        this.name = name;
        this.enabled = enabled;
    }
}