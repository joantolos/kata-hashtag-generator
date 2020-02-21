package com.joantolos.kata.hashtag.generator.exception;

public class InvalidProfileIdException extends Throwable {

    public InvalidProfileIdException(int profileId) {
        super("The id " + profileId + " does not exists.");
    }
}
