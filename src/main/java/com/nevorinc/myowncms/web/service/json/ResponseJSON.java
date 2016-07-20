/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nevorinc.myowncms.web.service.json;

/**
 *
 * @author Admin
 */
public class ResponseJSON {
    private String message;

    public String getMessage() {
        return message;
    }

    public ResponseJSON(String message) {
        this.message = message;
    }

}
