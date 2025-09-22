package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionTest {
    String sex;
    boolean hasMane;

    @Spy
    Lion lion;
    Feline felineMock = mock(Feline.class);

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testLionSex () throws Exception {
        Lion lionObj = new Lion(this.sex, felineMock);
        assertEquals(this.hasMane, lionObj.doesHaveMane());
    }

    @Test
    public void testLionKittens () throws Exception {
        lion = new Lion(this.sex, felineMock);
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
        lion = new Lion(this.sex, felineMock);
        lion.getFood();
        verify(felineMock).getFood("Хищник");
    }

}
