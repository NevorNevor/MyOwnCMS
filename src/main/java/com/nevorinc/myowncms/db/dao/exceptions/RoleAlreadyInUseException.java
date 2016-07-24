package com.nevorinc.myowncms.db.dao.exceptions;

public class RoleAlreadyInUseException extends RuntimeException{

    public RoleAlreadyInUseException() {
        super("This user role is already in use");
    }
    
}
