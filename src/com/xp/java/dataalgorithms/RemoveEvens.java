package com.xp.java.dataalgorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

class RemoveEvens
{
    public static void removeEvensVer1( List<Integer> lst )
    {
        int i = 0;
        while( i < lst.size( ) )
            if( lst.get( i ) % 2 == 0 )
                lst.remove( i );
            else
                i++;
    }
    
    public static void removeEvensVer2( List<Integer> lst )
    {
        for( Integer x : lst )
            if( x % 2 == 0 )
                lst.remove( x );
    }
    
    public static void removeEvensVer3( List<Integer> lst )
    {
        Iterator<Integer> itr = lst.iterator( );

        while( itr.hasNext( ) )
            if( itr.next( ) % 2 == 0 )
                itr.remove( );
    }
    
    public static void main( String [ ] args )
    {
        int N = 1600000;
        List<Integer> lst1 = new ArrayList<>( );
        List<Integer> lst2 = new LinkedList<>( );

        for( int i = 0; i < N; i++ )
        {
            lst1.add( i );
            lst2.add( i );
        }

        long start, end;

        start = System.currentTimeMillis( );
        removeEvensVer3( lst2 );
        end = System.currentTimeMillis( );
        System.out.println( (end-start) + " ms for LinkedList size " + N );

        start = System.currentTimeMillis( );
        removeEvensVer3( lst1 );
        end = System.currentTimeMillis( );
        System.out.println( (end-start) + " ms for ArrayList size " + N );

    }
}