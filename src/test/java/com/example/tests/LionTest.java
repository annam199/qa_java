package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {
    @Spy
    Lion lion;
    Feline felineMock = mock(Feline.class);

    @Test
    public void testLionIsMale () throws Exception {
        lion = new Lion("Самец", felineMock);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionIsFemale () throws Exception {
        lion = new Lion("Самка", felineMock);

        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testLionKittens () throws Exception {
        lion = new Lion("Самка", felineMock);
        lion.getKittens();
        verify(felineMock).getKittens();
    }

    @Test
    public void testLionWrongSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Мужчина", felineMock));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void testLionFood() throws Exception {
        Feline felineMock = mock(Feline.class);
        lion = new Lion("Самка", felineMock);
        lion.getFood();
        verify(felineMock).getFood("Хищник");
    }

}
