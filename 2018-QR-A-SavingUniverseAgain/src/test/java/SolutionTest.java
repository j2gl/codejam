import org.junit.Test;

import java.io.InputStream;

public class SolutionTest {



    @Test
    public void saveUniverse() {
        final InputStream in = SolutionTest.class.getResourceAsStream("example01.txt");
        Solution.saveUniverse(in);
    }
}
