package com.xp.java.dataalgorithms;

public class Fig02_11
{
    public static boolean isEven( int n )
    {
        return n % 2 == 0;
    }

    public static long pow( long x, int n )
    {
        if( n == 0 )
            return 1;
        if( n == 1 )
            return x;
        if( isEven( n ) )
            return pow( x * x, n / 2 );
        else
            return pow( x * x, n / 2 ) * x;
    }

    // Test program
    public static void main( String [ ] args )
    {
        System.out.println( "2^21 = " + pow( 2, 21 ) );
        System.out.println( "2^50 = " + pow( 2, 50 ) );
    }
}
