package com.joantolos.kata.hashtag.generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneratorService {

    private List<String> defaults;
    private List<String> randoms;
    private Random random;

    public GeneratorService(Integer profileId) throws IOException {
        ConfigLoader configLoader = new ConfigLoader(profileId);

        this.random = new Random();
        this.defaults = configLoader.getDefaults();
        this.randoms = configLoader.getRandoms();
    }

    public String generate(int randomsCount) {
        return generateDefaults() + generateRandoms(randomsCount);
    }

    private String generateDefaults() {
        return this.defaults.stream().map(defaultEntry -> "#" + defaultEntry).collect(Collectors.joining(",")).replace(",", " ") + " ";
    }

    private String generateRandoms(int randomsCount) {
        List<String> tempRandoms = new ArrayList<>();

        do {
            String randomHashTag = randoms.get(random.nextInt(randoms.size()));
            if (!tempRandoms.contains(randomHashTag)) {
                tempRandoms.add("#" + randomHashTag);
            }
        } while (tempRandoms.size() != randomsCount);

        return String.join(" ", tempRandoms);
    }
}
