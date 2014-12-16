package com.card.seller.domain;

/**
 * Created by doing on 13-12-27.
 */
public class ResourceException extends Exception {

    public ResourceException(String s) {
        super(s);
    }

    public ResourceException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
