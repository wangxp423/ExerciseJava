package com.xp.java.dataalgorithms;

public class Fig10_63
{
    /**
     * Method that implements the basic primality test.
     * If witness does not return 1, n is definitely composite.
     * Do this by computing a^i (mod n) and looking for
     * nontrivial square roots of 1 along the way.
     */
    private static long witness( long a, long i, long n )
    {
        if( i == 0 )
            return 1;

        long x = witness( a, i / 2, n );
        if( x == 0 )    // If n is recursively composite, stop
            return 0;

        // n is not prime if we find a nontrivial square root of 1
        long y = ( x * x ) % n;
        if( y == 1 && x != 1 && x != n - 1 )
            return 0;

        if( i % 2 != 0 )
            y = ( a * y ) % n;

        return y;
    }

    /**
     * The number of witnesses queried in randomized primality test.
     */
    public static final int TRIALS = 5;

    /**
     * Randomized primality test.
     * Adjust TRIALS to increase confidence level.
     * @param n the number to test.
     * @return if false, n is definitely not prime.
     *     If true, n is probably prime.
     */
    public static boolean isPrime( long n )
    {
        Random r = new Random( );

        for( int counter = 0; counter < TRIALS; counter++ )
            if( witness( r.randomLong( 2, n - 2 ), n - 1, n ) != 1 )
                return false;

        return true;
    }

    public static void main( String [ ] args )
    {
        for( int i = 101; i < 200; i += 2 )
            if( isPrime( i ) )
                System.out.println( i + " is prime" );
    }
}
