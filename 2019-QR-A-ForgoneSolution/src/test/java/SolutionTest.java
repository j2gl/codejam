import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    @Test
    public void findNumbersWithout4Test() {
        String s = Solution.findNumbersWithout4(4, 0);
        assertThat(s, is("3 1"));
    }

    @Test
    public void findNumbersWithout4Test02() {
        String s = Solution.findNumbersWithout4(940, 0);
        assertThat(s, is("930 10"));
    }

    @Test
    public void findNumbersWithout4Test03() {
        String s = Solution.findNumbersWithout4(4444, 0);
        assertThat(s, is("3333 1111"));
    }

    @Test
    public void findNumbersWithout4Test04() {
        String s = Solution.findNumbersWithout4(4946, 0);
        assertThat(s, is("3936 1010"));
    }

    @Test
    public void findNumbersWithout4Test05() {
        String s = Solution.findNumbersWithout4(4_444_444_444L, 0);
        assertThat(s, is("3333333333 1111111111"));
    }





}