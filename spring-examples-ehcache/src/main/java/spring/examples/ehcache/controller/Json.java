package spring.examples.ehcache.controller;

import java.io.Serializable;
import java.util.HashMap;

public class Json implements Serializable {

    private String code = "0";
    private String message = "";
    private Payload payload = new Payload();
    private Json() {
    }

    public static Json newInstance() {
        return new Json();
    }

    public Json code(String code) {
        this.code = code;
        return this;
    }

    public Json message(String message) {
        this.message = message;
        return this;
    }

    public Json payload(String key, Object value) {
        payload.put(key, value);
        return this;
    }

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

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public static class Payload extends HashMap<String, Object> implements Serializable {
    }
}
