package com.sda.testingadvanced.parameters.fiboncci;

import java.math.BigInteger;

public class FibonacciSequenceRecursive implements FibonacciSequence {
    @Override
    public BigInteger getFibonacciNumber(int nthTerm) {
        if (nthTerm < 0) {
            throw new IllegalArgumentException("nthNumber must be greater or equal to 0");
        }
        if (nthTerm == 0) {
            return BigInteger.ZERO;
        }
        if (nthTerm == 1) {
            return BigInteger.ONE;
        }
        return getFibonacciNumber(nthTerm-2).add(getFibonacciNumber(nthTerm-1));
    }
}
