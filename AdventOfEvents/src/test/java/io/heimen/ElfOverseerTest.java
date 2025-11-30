package io.heimen;

import io.heimen.publisher.ExceptionPublisher;
import io.heimen.publisher.InitPublisher;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class ElfOverseerTest {

    @Test
    void run_invocation_publishesInitEvent() {

        var initPublisher = Mockito.mock(InitPublisher.class);
        var exceptionPublisher = Mockito.mock(ExceptionPublisher.class);

        Mockito.doNothing().when(initPublisher).publishInitEvent(any());

        var overseer = new ElfOverseer(initPublisher, exceptionPublisher);

        overseer.run();

        Mockito.verify(initPublisher).publishInitEvent(any());

    }

    @Test
    void run_exception_isHandledByExceptionPublisher() {
        var initPublisher = Mockito.mock(InitPublisher.class);
        var exceptionPublisher = Mockito.mock(ExceptionPublisher.class);
        var grinch = new RuntimeException();

        Mockito.doThrow(grinch).when(initPublisher).publishInitEvent(any());
        Mockito.doNothing().when(exceptionPublisher).publishExceptionEvent(any(), eq(grinch));

        var overseer = new ElfOverseer(initPublisher, exceptionPublisher);

        overseer.run();

        Mockito.verify(exceptionPublisher).publishExceptionEvent(any(), eq(grinch));

    }
}