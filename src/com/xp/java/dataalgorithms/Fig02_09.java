package com.xp.java.dataalgorithms;

public class Fig02_09
{
    public static final int NOT_FOUND = -1;

    /**
     * Performs the standard binary search.
     * @return index where item is found, or -1 if not found
     */
    public static <AnyType extends Comparable<? super AnyType>>
    int binarySearch( AnyType [ ] a, AnyType x )
    {
        int low = 0, high = a.length - 1;

        while( low <= high )
        {
            int mid = ( low + high ) / 2;

            if( a[ mid ].compareTo( x ) < 0 )
                low = mid + 1;
            else if( a[ mid ].compareTo( x ) > 0 )
                high = mid - 1;
            else
                return mid;   // Found
        }
        return NOT_FOUND;     // NOT_FOUND is defined as -1
    }

    // Test program
    public static void main( String [ ] args )
    {
        int SIZE = 8;
        Integer [ ] a = new Integer [ SIZE ];
        for( int i = 0; i < SIZE; i++ )
            a[ i ] = i * 2;

        for( int i = 0; i < SIZE * 2; i++ )
            System.out.println( "Found " + i + " at " + binarySearch( a, i ) );
    }
}
