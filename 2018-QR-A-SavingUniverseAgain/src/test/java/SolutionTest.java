import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class SolutionTest {

    @Test
    void saveUniverse() {
        final InputStream in = SolutionTest.class.getResourceAsStream("example01.txt");
        Solution.doSaveUniverse(in);
    }

    @Test
    void saveUniverse01() {
        final String answer = Solution.saveUniverse("CS", 1);
        assertThat(answer, is("1"));
    }

    @Test
    void saveUniverse02() {
        final String answer = Solution.saveUniverse("SS", 2);
        assertThat(answer, is("0"));
    }

    @Test
    void saveUniverse03() {
        final String answer = Solution.saveUniverse("SS", 1);
        assertThat(answer, is("IMPOSSIBLE"));
    }

    @Test
    void saveUniverse04() {
        final String answer = Solution.saveUniverse("SCCSSC", 6);
        assertThat(answer, is("2"));
    }

    @Test
    void saveUniverse05() {
        final String answer = Solution.saveUniverse("CC", 0);
        assertThat(answer, is("0"));
    }

    @Test
    void saveUniverse06() {
        final String answer = Solution.saveUniverse("CSCSS", 3);
        assertThat(answer, is("5"));
    }

    @Test
    void saveUniverse07() {
        final String answer = Solution.saveUniverse("CCCSCS", 16);
        assertThat(answer, is("1"));
    }


}
