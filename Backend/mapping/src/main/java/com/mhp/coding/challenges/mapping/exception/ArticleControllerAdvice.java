package com.mhp.coding.challenges.mapping.exception;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SuppressWarnings("unused")
@ControllerAdvice
@RequestMapping(produces = "application/vnd.error")
@ResponseBody
public class ArticleControllerAdvice {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ArticleNotFoundException.class)
    public VndErrors articleNotFoundException(ArticleNotFoundException e) {
        return this.error(e, e.getId() + "");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnknownArticleBlockTypeException.class)
    public VndErrors unknownArticleBlockTypeException(UnknownArticleBlockTypeException e) {
        return this.error(e, e.getMessage());
    }

    private <E extends Exception> VndErrors error(E e, String logref) {
        String msg = Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
        return new VndErrors(logref, msg);
    }

}
