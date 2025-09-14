package com.example.tests;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;

    @Test
    public void testFelineEatPredatorFood () throws Exception {
        feline.eatMeat();
        verify(feline).getFood("Хищник");
    }

    @Test
    public void testFelineFamily () {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testFelineKittensDefault () {
        feline.getKittens();
        verify(feline).getKittens(1);
    }

    @Test
    public void testFelineKittensProvided () {
        feline.getKittens(5);
        verify(feline).getKittens(5);
    }
}
