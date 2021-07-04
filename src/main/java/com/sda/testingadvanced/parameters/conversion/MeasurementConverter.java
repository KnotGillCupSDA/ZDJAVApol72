package com.sda.testingadvanced.parameters.conversion;

public class MeasurementConverter {

    public double convert(double value, ConversionType conversionType) {
        return conversionType.getConverter().apply(value);
    }
}
