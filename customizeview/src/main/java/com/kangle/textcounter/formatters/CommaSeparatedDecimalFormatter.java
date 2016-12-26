package com.kangle.textcounter.formatters;


import com.kangle.textcounter.Formatter;

import java.text.DecimalFormat;

/**
 * Created by prem on 10/28/14.
 * <p>
 * Formats the text to a comma separated decimal with 2dp
 */
public class CommaSeparatedDecimalFormatter implements Formatter {

    private final DecimalFormat format = new DecimalFormat("##,###,###.00");

    @Override
    public String format(String prefix, String suffix, float value) {
        return prefix + format.format(value) + suffix;
    }
}
