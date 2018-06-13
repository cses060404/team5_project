package com.example.wchang.team5_project;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void isItemNull(String item) { assertNotEquals(item, null); }
    @Test
    public void isAmountNull(Integer amount) { assertNotEquals(amount,null); }
    @Test
    public void isRecipeNull(String recipe) { assertNotEquals(recipe, null); }
    //CHANGE RECIPE DATA VALUE
}
