package com.cognizant.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {

        // Create Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub Method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Service Object
        MyService service = new MyService(mockApi);

        // Call Method
        String result = service.fetchData();

        // Verify Output
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {

        // Create Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Service Object
        MyService service = new MyService(mockApi);

        // Call Method
        service.fetchData();

        // Verify Interaction
        verify(mockApi).getData();
    }
}