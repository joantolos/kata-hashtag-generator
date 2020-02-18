package com.joantolos.kata.hashtag.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class GeneratorServiceTest {

    private GeneratorService generatorService;

    @Before
    public void setUp() throws IOException {
        this.generatorService = new GeneratorService(1);
    }

    @Test
    public void shouldGenerateHashTagsStartingWithDefaults() {
        Assert.assertTrue(this.generatorService.generate().startsWith("#java #programming"));
    }

}
