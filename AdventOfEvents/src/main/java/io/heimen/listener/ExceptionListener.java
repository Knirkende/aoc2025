package io.heimen.listener;

import io.heimen.event.exception.GrinchEvent;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ExceptionListener implements ApplicationListener<@NonNull GrinchEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionListener.class);
    private final ApplicationContext applicationContext;

    public ExceptionListener(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(@NonNull GrinchEvent event) {
        logger.info("An exception was caught with reason: {}", event.getGrinch().getMessage());
        SpringApplication.exit(applicationContext, () -> SpringApplication.exit(applicationContext));
    }
}
