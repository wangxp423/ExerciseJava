package com.xp.java.dataalgorithms;

public class Fig02_10
{
    public static long gcd( long m, long n )
    {
        while( n != 0 )
        {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    // Test program
    public static void main( String [ ] args )
    {
        System.out.println( "gcd( 45, 35 ) = " + gcd( 45, 35 ) );
        System.out.println( "gcd( 1989, 1590 ) = " + gcd( 1989, 1590 ) );
    }
}
