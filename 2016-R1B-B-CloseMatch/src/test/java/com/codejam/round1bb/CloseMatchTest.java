package com.codejam.round1bb;

import org.junit.Assert;
import org.junit.Test;

import static com.codejam.round1bb.CloseMatch.closeMatch;
import static org.hamcrest.core.Is.is;

public class CloseMatchTest {

    @Test
    public void closeMatch_01() throws Exception {
        String input = "1? 2?";
        String result = closeMatch(input);
        Assert.assertThat(result, is("19 20"));

    }

    @Test
    public void closeMatch_02() throws Exception {
        String input = "?2? ??3";
        String result = closeMatch(input);
        Assert.assertThat(result, is("023 023"));
    }

    @Test
    public void closeMatch_03() throws Exception {
        String input = "? ?";
        String result = closeMatch(input);
        Assert.assertThat(result, is("0 0"));
    }

    @Test
    public void closeMatch_04() throws Exception {
        String input = "?5 ?0";
        String result = closeMatch(input);
        Assert.assertThat(result, is("05 00"));
    }

    @Test
    public void closeMatch_05() throws Exception {
        String input = "7?9 650";
        String result = closeMatch(input);
        Assert.assertThat(result, is("709 650"));
    }
}