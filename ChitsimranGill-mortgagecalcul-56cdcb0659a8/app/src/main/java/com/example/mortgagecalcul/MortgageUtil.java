package com.example.mortgagecalcul;

import java.lang.Math;
public class MortgageUtil
{
    public static double mortgageCalculator(float amount, float interest, float years, float taxes)
    {
        if (interest==0)
        {
            return (amount/(years*12))+(taxes);
        }
        else {
            return (amount * (((interest*0.01)/12)/(1-Math.pow((1+((interest*0.01)/12)),(0-(years*12)))))) + taxes;
        }
    }

}