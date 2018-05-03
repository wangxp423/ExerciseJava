package com.xp.java.dataalgorithms;

// Exercise the IntCell class
public class TestIntCell
{
    public static void main( String [ ] args )
    {
        IntCell m = new IntCell( );

        m.write( 5 );
        System.out.println( "Cell contents: " + m.read( ) );
        // The next line would be illegal if uncommented
    //  m.storedValue = 0;
    }
}
