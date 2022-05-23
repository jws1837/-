package com.flab.baseballgame.controller.response;

import com.flab.baseballgame.controller.dto.Data;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class ApiResponse {
    private String success;
    private Data data;
    private Err err;

    public ApiResponse(@Nullable String success, Data data) {

        this.success = Optional.ofNullable(success).orElse("true");
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public Data getData() {
        return data;
    }

    public void setErr(Err err) {
        this.err = err;
    }

    public static class Err {
        private String code;
        private String message;

        public Err(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}

