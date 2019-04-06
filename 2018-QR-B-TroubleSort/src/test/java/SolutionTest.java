import org.junit.Test;

import java.io.InputStream;

public class SolutionTest {

    @Test
    public void checkTroubleSort01() {
        final InputStream in = SolutionTest.class.getResourceAsStream("example01.txt");
        Solution.checkTroubleSort(in);
    }

    @Test
    public void checkTroubleSort02() {
        final InputStream in = SolutionTest.class.getResourceAsStream("example02.txt");
        Solution.checkTroubleSort(in);
    }

    @Test
    public void checkTroubleSort03() {
        final InputStream in = SolutionTest.class.getResourceAsStream("example03.txt");
        Solution.checkTroubleSort(in);
    }

    @Test
    public void checkTroubleSort04() {
        final InputStream in = SolutionTest.class.getResourceAsStream("example04.txt");
        Solution.checkTroubleSort(in);
    }

}
