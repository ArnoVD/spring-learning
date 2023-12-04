package com.arnovandijck.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    public void findTheGreatestFromAllData_basicScenario() {
         when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
         assertEquals(24, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void findTheGreatestFromAllData_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 35 });
        assertEquals(35, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void findTheGreatestFromAllData_emptyArray() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}
