package com.learning.springreactive.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class FluxAndMonoGeneratorService {
    public static final String ALICE = "Alice";
    public static final String ATTACKER = "Attacker";

    public Flux<String> getNamesFlux() {
        return Flux.fromIterable(List.of(ALICE, "Bob", ATTACKER)).log()
                .doOnComplete(() -> System.out.println("all data received"));
    }
    public Flux<String> getNamesFluxMapped() {
        return Flux.fromIterable(List.of(ALICE, "Bob", ATTACKER))
                .map(String::toUpperCase).log();
    }
    public Flux<String> getNamesFluxMappedWithFilter(final int minLength) {
        return Flux.fromIterable(List.of(ALICE, "Bob", ATTACKER))
                .map(String::toUpperCase)
                .filter(s -> s.length() > minLength);
    }
    public Flux<String> getNamesFluxMappedWithFilterCombination(final int minLength) {
        return Flux.fromIterable(List.of(ALICE, "Bob", ATTACKER))
                .map(String::toUpperCase)
                .filter(s -> s.length() > minLength)
                .map(s -> s.length() + "-" + s);
    }

    public Mono<String> getNameMono() {
        return Mono.just("Chris").log();
    }

    public static void main(final String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService =
                new FluxAndMonoGeneratorService();
        fluxAndMonoGeneratorService.getNamesFlux().subscribe(
                name -> System.out.println("Name is : " + name)
        );

        fluxAndMonoGeneratorService.getNameMono().
                subscribe(name -> System.out.println("Mono name is : " + name));
    }
}
