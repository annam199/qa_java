package com.example.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {
    @Test
    public void testCatSoundMessage () {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testCatEatMeat () throws Exception {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);
        cat.getFood();
        doThrow(new Exception()).when(felineMock).eatMeat();
    }
}
