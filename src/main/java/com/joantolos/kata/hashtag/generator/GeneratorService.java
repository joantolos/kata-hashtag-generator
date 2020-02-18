package com.joantolos.kata.hashtag.generator;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratorService {

    private List<String> defaults;
    private List<String> randoms;

    public GeneratorService(Integer profileId) throws IOException {
        ConfigLoader configLoader = new ConfigLoader(profileId);

        this.defaults = configLoader.getDefaults();
        this.randoms = configLoader.getRandoms();
    }

    public String generate() {
        return this.defaults.stream().map(defaultEntry -> "#" + defaultEntry).collect(Collectors.joining(",")).replace(",", " ");
    }
}
