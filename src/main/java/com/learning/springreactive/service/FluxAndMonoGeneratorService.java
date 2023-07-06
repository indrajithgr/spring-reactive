package com.learning.springreactive.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class FluxAndMonoGeneratorService {

    public Flux<String> getNamesFlux() {
        return Flux.fromIterable(List.of("Alice", "Bob", "Attacker")).log()
                .doOnComplete(()-> System.out.println("all data received"));
    }

    public Mono<String> getNameMono() {
        return Mono.just("Chris").log();
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService =  new FluxAndMonoGeneratorService();
        fluxAndMonoGeneratorService.getNamesFlux().subscribe(
                name -> System.out.println("Name is : "+name)
        );

        fluxAndMonoGeneratorService.getNameMono().subscribe(name -> System.out.println("Mono name is : "+name));
    }
}
