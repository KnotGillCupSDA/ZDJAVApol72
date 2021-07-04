package com.sda.testingadvanced.parameters.fiboncci;

import java.math.BigInteger;

public class FibonacciSequenceIterative implements FibonacciSequence {

    @Override
    public BigInteger getFibonacciNumber(int nthTerm) {

        if (nthTerm < 0) {
            throw new IllegalArgumentException("nthTerm must be greater or equal to 0");
        }
        if (nthTerm == 0) {
            return BigInteger.ZERO;
        }
        if (nthTerm == 1) {
            return BigInteger.ONE;
        }

        BigInteger previousPrevious = BigInteger.ZERO;
        BigInteger previous = BigInteger.ONE;

        BigInteger current = BigInteger.ZERO;

        for (int i = 2; i <= nthTerm; i++) {
            current = previousPrevious.add(previous);

            previousPrevious = previous;
            previous = current;
        }

        return current;
    }
}
