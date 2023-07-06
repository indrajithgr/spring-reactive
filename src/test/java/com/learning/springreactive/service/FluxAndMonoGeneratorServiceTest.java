package com.learning.springreactive.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService classUnderTest = new FluxAndMonoGeneratorService();

    @Test
    public void test_getNamesFlux() {
        var namesFlux = classUnderTest.getNamesFlux();
        StepVerifier.create(namesFlux).expectNextCount(3).verifyComplete();
        StepVerifier.create(namesFlux).expectNext("Alice", "Bob", "Attacker").verifyComplete();
        StepVerifier.create(namesFlux).expectNext("Alice").expectNextCount(2).verifyComplete();
    }

    @Test
    public void test_getNameMono() {
        var nameMono = classUnderTest.getNameMono();
        StepVerifier.create(nameMono).expectNext("Chris").verifyComplete();
    }
}
