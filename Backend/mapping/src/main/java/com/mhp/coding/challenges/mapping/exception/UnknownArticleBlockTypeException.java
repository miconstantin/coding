package com.mhp.coding.challenges.mapping.exception;

public class UnknownArticleBlockTypeException extends RuntimeException {

    public UnknownArticleBlockTypeException(String type) {
        super("article block type " + type + " is unknown");
    }
}
