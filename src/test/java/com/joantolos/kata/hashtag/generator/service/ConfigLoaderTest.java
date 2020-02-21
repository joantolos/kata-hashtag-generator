package com.joantolos.kata.hashtag.generator.service;

import com.joantolos.kata.hashtag.generator.exception.InvalidProfileIdException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ConfigLoaderTest {

    private ConfigLoader configLoader;

    @Before
    public void setUp() throws IOException, InvalidProfileIdException {
        this.configLoader = new ConfigLoader(1);
    }

    @Test
    public void shouldLoadDefaults() {
        Assert.assertEquals("java", configLoader.getDefaults().get(0));
    }

    @Test
    public void shouldLoadRandoms() {
        Assert.assertEquals("tdd", configLoader.getRandoms().get(0));
    }

    @Test(expected = InvalidProfileIdException.class)
    public void shouldRaiseExceptionWhenWrongProfileId() throws IOException, InvalidProfileIdException {
        new ConfigLoader(99);
    }
}
