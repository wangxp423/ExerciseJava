package com.xp.java.dataalgorithms;

public class Fig10_53
{
    public static final int NOT_A_VERTEX = -1;

    /**
     * Compute all-shortest paths.
     * a[ ][ ] contains the adjacency matrix with
     * a[ i ][ i ] presumed to be zero.
     * d[ ] contains the values of the shortest path.
     * Vertices are numbered starting at 0; all arrays
     * have equal dimension. A negative cycle exists if
     * d[ i ][ i ] is set to a negative value.
     * Actual path can be computed using path[ ][ ].
     * NOT_A_VERTEX is -1
     */
    public static void allPairs( int [ ][ ] a, int [ ][ ] d, int [ ][ ] path ) 
    {
        int n = a.length;

        // Initialize d and path
        for( int i = 0; i < n; i++ )
            for( int j = 0; j < n; j++ )
            {
                d[ i ][ j ] = a[ i ][ j ];
                path[ i ][ j ] = NOT_A_VERTEX;
            }

        for( int k = 0; k < n; k++ )
            // Consider each vertex as an intermediate
            for( int i = 0; i < n; i++ )
                for( int j = 0; j < n; j++ )
                    if( d[ i ][ k ] + d[ k ][ j ] < d[ i ][ j ] )
                    {
                        // Update shortest path
                        d[ i ][ j ] = d[ i ][ k ] + d[ k ][ j ];
                        path[ i ][ j ] = k;
                    }
    }

    public static void main( String [ ] args )
    {
        int [ ][ ] a = { { 0, 2, -2, 2 }, { 1000, 0, -3, 1000 },
                         { 4, 1000, 0, 1000 }, { 1000, -2, 3, 0 } };
        int d[ ][ ] = new int [ 4 ][ 4 ];
        int path[ ][ ] = new int [ 4 ][ 4 ];

        allPairs( a, d, path );
        for( int i = 0; i < 4; i++ )
        {
            for( int j = 0; j < 4; j++ )
                System.out.print( d[ i ][ j ] + "    " );
            System.out.println( );
        }
        for( int i = 0; i < 4; i++ )
        {
            for( int j = 0; j < 4; j++ )
                System.out.print( path[ i ][ j ] + "    " );
            System.out.println( );
        }
    }
}
