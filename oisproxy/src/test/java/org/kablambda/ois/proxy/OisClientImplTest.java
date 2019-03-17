package org.kablambda.ois.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OisClientImplTest {

    @Mock
    private InputStream mockIn;

    @Mock
    private OutputStream mockOut;

    private OisClientImpl oisClient;

    @BeforeEach
    public void setupClient() throws IOException, InterruptedException {
        final int[] data = new int[]{(int) 'x', (int) '\n'};
        lenient().when(mockIn.read()).thenAnswer(new Answer<Integer>() {
            int index = 0;

            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                return data[index++ % data.length];
            }
        });
        oisClient = new OisClientImpl(mockIn, mockOut);
    }

    @Test
    public void getEvent_always_returnsX() {
        assertThat(oisClient.getEvent(), equalTo("x"));
    }

    @Test
    public void getEvent_whenStopped_ReturnsNull() {
        oisClient.stop();
        assertThat(oisClient.getEvent(), equalTo(null));
    }
}
