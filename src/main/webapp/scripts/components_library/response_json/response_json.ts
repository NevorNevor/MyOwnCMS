import { Response } from '@angular/http';

export class Response_JSON {
    private message: string;

    constructor(response: Response){
        let data = response.json();
        this.message = data.message;
    }

    getMessage(): string{
        return this.message;
    }
}