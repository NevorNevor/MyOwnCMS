package com.nevorinc.myowncms.db.dao.exceptions;

public class ConstantFieldAlterException extends RuntimeException {

    public ConstantFieldAlterException() {
        super("Constant field alter attempt");
    }

}
