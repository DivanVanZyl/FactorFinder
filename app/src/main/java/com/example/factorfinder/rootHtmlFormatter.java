package com.example.factorfinder;

/*
    Some roots need to be written as whole numbers, others need to be written as fractions.
    This class takes the two roots, which comprises the answer, and return an HTML string that displays then correctly
 */
public class rootHtmlFormatter {
    public String getHTMLText(int root) {
            return root+"";
    }

    public String getHTMLText(int numerator, int denominator) {
        return "<sup>" + numerator + "</sup>/<sub>" + denominator + "</sub>";
    }
    public String getHTMLText(double numerator, double denominator) {
        return "<sup>" + numerator + "</sup>/<sub>" + denominator + "</sub>";
    }
}