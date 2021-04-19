package pl.kskowronski.pattern_ractive_dev.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kskowronski.pattern_ractive_dev.models.Student;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class StudentApi {

    private Flux<Student> studentFlux;

    public StudentApi() {
        this.studentFlux = Flux.just(
                new Student("Jon", "Amman"),
                new Student("Mark", "Okah"),
                new Student("Bella", "Jackson")
        );
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> getStudent() {
        return studentFlux.delayElements(Duration.ofSeconds(2));
    }
}
