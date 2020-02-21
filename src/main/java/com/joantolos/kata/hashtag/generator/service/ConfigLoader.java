package com.joantolos.kata.hashtag.generator.service;

import com.joantolos.kata.hashtag.generator.exception.InvalidProfileIdException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigLoader {

    private List<String> defaults;
    private List<String> randoms;

    public ConfigLoader(Integer profileId) throws InvalidProfileIdException, IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));

        defaults = getWordList(profileId, properties, "default");
        randoms = getWordList(profileId, properties, "random");
    }

    private List<String> getWordList(Integer profileId, Properties properties, String kind) throws InvalidProfileIdException {
        String defaultProperty = properties.getProperty("profile." + profileId + "." + kind);
        if (defaultProperty == null) {
            throw new InvalidProfileIdException(profileId);
        }
        return new ArrayList<>(Arrays.asList(defaultProperty.split(",")));
    }

    public List<String> getDefaults() {
        return defaults;
    }

    public List<String> getRandoms() {
        return randoms;
    }
}
