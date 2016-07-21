package com.nevorinc.myowncms.db.dao.exceptions;

public class PasswordException extends RuntimeException{

    /**
     * Trown when password is out of boud
     * @param min min-bound
     * @param max max-bound
     */
    public PasswordException(int min, int max) {
        super(String.format("Password must be between %min and %max", min, max));
    }
    
}
