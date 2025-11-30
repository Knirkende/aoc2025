package io.heimen;

import io.heimen.publisher.ExceptionPublisher;
import io.heimen.publisher.InitPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElfOverseer implements CommandLineRunner {

    private final InitPublisher initPublisher;
    private final ExceptionPublisher exceptionPublisher;

    public ElfOverseer(InitPublisher initPublisher, ExceptionPublisher exceptionPublisher) {
        this.initPublisher = initPublisher;
        this.exceptionPublisher = exceptionPublisher;
    }

    static void main(String[] args) {
        SpringApplication.run(ElfOverseer.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            initPublisher.publishInitEvent(this);
        } catch (Exception e) {
            exceptionPublisher.publishExceptionEvent(this, e);
        }

    }
}
