package com.joantolos.kata.hashtag.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ConfigLoaderTest {

    private ConfigLoader configLoader;

    @Before
    public void setUp() throws IOException {
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
}
