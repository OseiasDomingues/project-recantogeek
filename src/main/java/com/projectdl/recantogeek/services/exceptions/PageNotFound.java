package com.projectdl.recantogeek.services.exceptions;

public class PageNotFound extends RuntimeException{
    public PageNotFound(String message) {
        super(message);
    }
}
