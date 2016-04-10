package com.codejam.qr2016;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.io.IOException;

import static com.codejam.qr2016.CoinJam.PRIME_NUMBERS_FILE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class CoinJamTest {

    @DataPoints(value = "validJamcoins")
    public static String[] validJamCoins = {"1001", "100011", "111111"};

    @DataPoints(value = "invalidJamCoins")
    public static String[] invalidJamCoins = {null, "101", "110", "110111"};


    @BeforeClass
    public static void setup() throws IOException {
        CoinJam.loadPrimeNumbers(PRIME_NUMBERS_FILE);;
    }

    @Theory
    public void isJamCoinTest_valid(@FromDataPoints("validJamcoins") String jamCoin) {

        assertTrue(CoinJam.isJamCoin(jamCoin));
    }

    @Theory
    public void isJamCoinTest_notValid(@FromDataPoints("invalidJamCoins") String jamCoin) {
        assertFalse(CoinJam.isJamCoin(jamCoin));
    }

    @Test
    public void ifJamCoin() {
        assertFalse(CoinJam.isJamCoin("101"));
    }
}