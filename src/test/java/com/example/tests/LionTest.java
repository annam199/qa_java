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
        Lion lionObj = new Lion("Самец", felineMock);

        assertTrue(lionObj.doesHaveMane());
    }

    @Test
    public void testLionIsFemale () throws Exception {
        Lion lionObj = new Lion("Самка", felineMock);

        assertFalse(lionObj.doesHaveMane());
    }

    @Test
    public void testLionKittens () throws Exception {
        lion = new Lion("Самка", felineMock);
        lion.getKittens();
        verify(felineMock).getKittens();
    }

    @Test
    public void testLionWrongSex() {
        // не поняла почему в ревью говорится о spy в этом тесте, тут сравнивается какое исключение выбрасывает конструктор класса
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
