package com.xp.java.dataalgorithms;

public class Fig01_04
{
    public static void printDigit( int n )
    {
        System.out.print( n );
    }

    public static void printOut( int n )  /* Print nonnegative n */
    {
        if( n >= 10 )
            printOut( n / 10 );
        printDigit( n % 10 );
    }
    
    public static void main( String [ ] args )
    {
        printOut( 1369 );
        System.out.println( );
    }
}
