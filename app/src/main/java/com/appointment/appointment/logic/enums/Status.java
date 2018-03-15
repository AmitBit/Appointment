package com.appointment.appointment.logic.enums;

/**
 * Created by AmitBit on 3/15/2018.
 */

public enum Status {

    Approved(1),
    Declined(2),
    Pending(3);

    public int getCode() {
        return code;
    }

    private int code;

    Status(int code) {
        this.code = code;
    }
}
