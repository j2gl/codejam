package com.codejam.round1bb;

import org.junit.Assert;
import org.junit.Test;

import static com.codejam.round1bb.CloseMatch.closeMatch;
import static org.hamcrest.core.Is.is;

public class CloseMatchTest {

    @Test
    public void closeMatch_all() throws Exception {
        String result;

        result = closeMatch("? ?");
        Assert.assertThat(result, is("0 0"));

        result = closeMatch("? 1");
        Assert.assertThat(result, is("1 1"));

        result = closeMatch("1 ?");
        Assert.assertThat(result, is("1 1"));

        result = closeMatch("1 ?");
        Assert.assertThat(result, is("1 1"));

        result = closeMatch("1? 2?");
        Assert.assertThat(result, is("19 20"));

        result = closeMatch("1? 25");
        Assert.assertThat(result, is("19 25"));

        result = closeMatch("19 2?");
        Assert.assertThat(result, is("19 20"));

        result = closeMatch("2? 1?");
        Assert.assertThat(result, is("20 19"));

        result = closeMatch("2? 1?");
        Assert.assertThat(result, is("20 19"));

        result = closeMatch("2? 17");
        Assert.assertThat(result, is("20 17"));

        result = closeMatch("27 1?");
        Assert.assertThat(result, is("27 19"));

        result = closeMatch("?7 ?7");
        Assert.assertThat(result, is("07 07"));

        result = closeMatch("??7 ??7");
        Assert.assertThat(result, is("007 007"));


    }

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

    @Test
    public void closeMatch_06() throws Exception {
        String input = "?9 60";
        String result = closeMatch(input);
        Assert.assertThat(result, is("69 60"));
    }

    @Test
    public void closeMatch_07() throws Exception {
        String input = "02? 3?0";
        String result = closeMatch(input);
        Assert.assertThat(result, is("029 300"));
    }

    @Test
    public void closeMatch_09() throws Exception {
        String input = "?7 ?0";
        String result = closeMatch(input);
        Assert.assertThat(result, is("07 10"));
    }



}