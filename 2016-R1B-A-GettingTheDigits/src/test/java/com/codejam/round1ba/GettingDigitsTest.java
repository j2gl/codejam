package com.codejam.round1ba;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class GettingDigitsTest {


    @Test
    public void removeNumberLetters_1() throws Exception {
        String input = "OZONETOWER";
        String result = GettingDigits.getDigits(input);
        Assert.assertThat(result, is("012"));
    }

    @Test
    public void removeNumberLetters_2() throws Exception {
        String input = "WEIGHFOXTOURIST";
        String result = GettingDigits.getDigits(input);
        Assert.assertThat(result, is("2468"));
    }

    @Test
    public void removeNumberLetters_3() throws Exception {
        String input = "OURNEONFOE";
        String result = GettingDigits.getDigits(input);
        Assert.assertThat(result, is("114"));
    }

    @Test
    public void removeNumberLetters_4() throws Exception {
        String input = "ETHER";
        String result = GettingDigits.getDigits(input);
        Assert.assertThat(result, is("3"));
    }

}
