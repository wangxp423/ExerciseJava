package com.xp.java.dataalgorithms;

public class Fig01_02
{
    public static int f( int x )
    {
        if( x == 0 )
            return 0;
        else
            return 2 * f( x - 1 ) + x * x;
    }

    public static void main( String [ ] args )
    {
        System.out.println( "f(5) = " + f( 5 ) );
    }
}
