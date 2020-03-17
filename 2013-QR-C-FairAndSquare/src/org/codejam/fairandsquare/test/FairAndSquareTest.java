/**
 * 
 */
package org.codejam.fairandsquare.test;

import org.codejam.fairandsquare.FairAndSquare;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jgarcia
 *
 */
public class FairAndSquareTest {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link org.codejam.fairandsquare.FairAndSquare#isFair(long)}.
     */
    @Test
    public void testIsFair() {
	
	Assert.assertTrue(FairAndSquare.isFair(1));
	Assert.assertTrue(FairAndSquare.isFair(101));
	Assert.assertTrue(FairAndSquare.isFair(19788791));
	Assert.assertTrue(!FairAndSquare.isFair(123456789L));
	Assert.assertTrue(FairAndSquare.isFair(123456789987654321L));
	
	
    }

}
