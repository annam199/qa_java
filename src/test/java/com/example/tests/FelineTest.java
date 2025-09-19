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
        Feline felineObj = new Feline();
        assertEquals("Кошачьи", felineObj.getFamily());
    }

    @Test
    public void testFelineKittensDefault () {
        Feline felineObj = new Feline();
        assertEquals(1, felineObj.getKittens());
    }

    @Test
    public void testFelineKittensProvided () {
        Feline felineObj = new Feline();
        assertEquals(5, felineObj.getKittens(5));
    }
}
