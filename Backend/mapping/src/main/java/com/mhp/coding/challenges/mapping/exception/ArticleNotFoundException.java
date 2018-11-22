package com.mhp.coding.challenges.mapping.exception;

public class ArticleNotFoundException extends RuntimeException {

    private Long id;

    Long getId() {
        return id;
    }

    public ArticleNotFoundException(Long id) {
        super("article# " + id + " was not found");
        this.id = id;
    }

}
