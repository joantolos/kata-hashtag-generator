package com.joantolos.kata.hashtag.generator.exception;

public class HashTagsOverflowException extends Throwable {

    public HashTagsOverflowException(int randomMax) {
        super("The maximum amount of hashtags is " + randomMax);
    }
}
