package io.heimen;

import io.heimen.event.InitPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ElfOverseer implements CommandLineRunner {

    private final InitPublisher initPublisher;

    public ElfOverseer(InitPublisher initPublisher) {
        this.initPublisher = initPublisher;
    }

    static void main(String[] args) {
        SpringApplication.run(ElfOverseer.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initPublisher.publishInitEvent(this, args[0]);
    }
}
