package com.flab.baseballgame.exceptions;

public class ErrorResponse {
    private String success;
    private String data;
    private Err err;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Err getErr() {
        return err;
    }

    public void setErr(Err err) {
        this.err = err;
    }

    public ErrorResponse(String success, String data, Err err) {
        this.success = success;
        this.data = data;
        this.err = err;
    }

    public static class Err {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Err(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
