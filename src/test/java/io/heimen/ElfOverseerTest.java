package io.heimen;

import io.heimen.publisher.ExceptionPublisher;
import io.heimen.publisher.InitPublisher;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class ElfOverseerTest {

    @Test
    void run_invocation_publishesInitEvent() throws IOException {

        var initPublisher = Mockito.mock(InitPublisher.class);
        var exceptionPublisher = Mockito.mock(ExceptionPublisher.class);

        Mockito.doNothing().when(initPublisher).publishInitEvent(any(), eq(0));

        var overseer = new ElfOverseer(initPublisher, exceptionPublisher);

        overseer.run("0");

        Mockito.verify(initPublisher).publishInitEvent(any(), eq(0));

    }

    @Test
    void run_exception_isHandledByExceptionPublisher() throws IOException {
        var initPublisher = Mockito.mock(InitPublisher.class);
        var exceptionPublisher = Mockito.mock(ExceptionPublisher.class);
        var grinch = new RuntimeException();

        Mockito.doThrow(grinch).when(initPublisher).publishInitEvent(any(), eq(0));
        Mockito.doNothing().when(exceptionPublisher).publishExceptionEvent(any(), eq(0), eq(grinch));

        var overseer = new ElfOverseer(initPublisher, exceptionPublisher);

        overseer.run("0");

        Mockito.verify(exceptionPublisher).publishExceptionEvent(any(), eq(0), eq(grinch));

    }
}