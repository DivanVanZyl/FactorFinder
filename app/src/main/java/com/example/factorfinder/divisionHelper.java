package com.example.factorfinder;

public class divisionHelper {
    public static String fraction(double numerator, double denominator) {

        rootHtmlFormatter form = new rootHtmlFormatter();
        if(numerator % denominator == 0)
        {
            int root = (int) ((int) numerator/denominator);
            return form.getHTMLText(root);
        }
        else
        {
            boolean minusFlag = false;
            if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            {
                minusFlag = true;
            }

            if(minusFlag)
            {
                if(numerator < 0)
                    numerator = (-numerator);
                if(denominator < 0)
                    denominator = (-denominator);
            }

            double gcd = gcd(numerator,denominator);

            if(minusFlag)
            {
                return form.getHTMLText((-numerator / gcd), (denominator / gcd));
            }
            else
            {
                return form.getHTMLText((numerator / gcd), (denominator / gcd));
            }
        }
    }

    private static int getGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGCD(n2, n1 % n2);
    }

    static double gcd(double a, double b)
    {
        if (a < b)
            return gcd(b, a);

        // base case
        if (Math.abs(b) < 0.001)
            return a;

        else
            return (gcd(b, a -
                    Math.floor(a / b) * b));
    }
}

class fractionResult
{
    int numerator;
    int denominator;
    int wholeNumber;

    fractionResult(int num, int denom)
    {
        setNumerator(num);
        setDenominator(denom);
    }

    fractionResult(int wholeNumber)
    {

    }

    public int getDenominator() {
        return denominator;
    }

    private void setDenominator(int denom) {
        denominator = denom;
    }

    public int getNumerator() {
        return numerator;
    }

    private void setNumerator(int num) {
        numerator = num;
    }

    public int getWholeNumber()
    {
        return wholeNumber;
    }

    public void setWholeNumber(int w)
    {
        wholeNumber = w;
    }
}