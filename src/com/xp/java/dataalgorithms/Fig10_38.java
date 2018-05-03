package com.xp.java.dataalgorithms;

public class Fig10_38
{
    /**
     * Standard matrix multiplication.
     * Arrays start at 0.
     * Assumes a and b are square.
     */
    public static int [ ][ ] multiply( int [ ][ ] a, int [ ][ ] b )
    {
        int n = a.length;
        int [ ][ ] c = new int[ n ][ n ];

        for( int i = 0; i < n; i++ )    // Initialization
            for( int j = 0; j < n; j++ )
                c[ i ][ j ] = 0;

        for( int i = 0; i < n; i++ )
            for( int j = 0; j < n; j++ )
                for( int k = 0; k < n; k++ )
                    c[ i ][ j ] += a[ i ][ k ] * b[ k ][ j ];

        return c;
    }

    public static void main( String [ ] args )
    {
        int [ ][ ] a = { { 1, 2 }, { 3, 4 } };
        int [ ][ ] c = multiply( a, a );

        System.out.println( c[ 0 ][ 0 ] + " " + c[ 0 ][ 1 ] + " " +
                            c[ 1 ][ 0 ] + " " + c[ 1 ][ 1 ] );
    }
}
