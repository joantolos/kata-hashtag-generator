package com.joantolos.kata.hashtag.generator.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigLoader {

    private List<String> defaults;
    private List<String> randoms;

    public ConfigLoader(Integer profileId) throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));

        defaults = new ArrayList<>();
        defaults.addAll(Arrays.asList(properties.getProperty("profile." + profileId + ".default").split(",")));

        randoms = new ArrayList<>();
        randoms.addAll(Arrays.asList(properties.getProperty("profile." + profileId + ".random").split(",")));
    }

    public List<String> getDefaults() {
        return defaults;
    }

    public List<String> getRandoms() {
        return randoms;
    }
}
