package com.joantolos.kata.hashtag.generator.service;

import com.joantolos.kata.hashtag.generator.exception.HashTagsOverflowException;
import com.joantolos.kata.hashtag.generator.exception.InvalidProfileIdException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class GeneratorServiceTest {

    private List<String> randoms;
    private String[] hashTags;
    private int randomCounts;

    @Before
    public void setUp() throws IOException, InvalidProfileIdException, HashTagsOverflowException {
        this.randomCounts = 3;
        this.randoms = new ConfigLoader(1).getRandoms();
        this.hashTags = new GeneratorService(1).generate(randomCounts).split(" ");
    }

    @Test
    public void shouldGenerateHashTagsStartingWithDefaults() {
        Assert.assertEquals("#java", hashTags[0]);
        Assert.assertEquals("#programming", hashTags[1]);
    }

    @Test
    public void shouldContainAtLeastOneValidRandom() {
        Assert.assertTrue(randoms.contains(hashTags[2].replace("#", "")));
    }

    @Test
    public void shouldContainThreeRandoms() {
        int defaultCounts = 2;
        Assert.assertEquals( defaultCounts + randomCounts, hashTags.length);
    }

    @Test(expected = HashTagsOverflowException.class)
    public void shouldRaiseExceptionWhenMoreRandomCountsAskedThanAllowed() throws IOException, InvalidProfileIdException, HashTagsOverflowException {
        new GeneratorService(1).generate(9999);
    }

}
