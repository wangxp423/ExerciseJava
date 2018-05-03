package com.xp.java.dataalgorithms;

public class Fig10_43
{
    public static double eval( int n )
    {
        if( n == 0 )
            return 1.0;
        else
        {
            double sum = 0.0;
            for( int i = 0; i < n; i++ )
                sum += eval( i );
            return 2.0 * sum / n + n;
        }
    }

    public static void main( String [ ] args )
    {
        System.out.println( "eval( 10 ) = " + eval( 10 ) );
    }
}
