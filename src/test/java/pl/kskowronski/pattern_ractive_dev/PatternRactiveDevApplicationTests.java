package pl.kskowronski.pattern_ractive_dev;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class PatternRactiveDevApplicationTests {

    @Test
    void contextLoads() {

        Flux.just("Jon", "Mark", "Bella")
                .filter( item -> item.contains("M"))
                .map(String::toUpperCase)
                .subscribe(System.out::println);
        Mono.just("Jon");
    }

}
