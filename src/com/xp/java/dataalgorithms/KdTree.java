package com.xp.java.dataalgorithms;

/**
 * Quick illustration of a two-dimensional tree.
 */
public class KdTree<AnyType extends Comparable<? super AnyType>>
{
    private static class KdNode<AnyType>
    {
        AnyType [ ]     data;
        KdNode<AnyType> left;
        KdNode<AnyType> right;

        KdNode( AnyType item[ ] )
        {
            data = (AnyType[]) new Comparable[ 2 ];
            data[ 0 ] = item[ 0 ];
            data[ 1 ] = item[ 1 ];
            left = right = null;
        }
    }

    private KdNode<AnyType> root;

    public KdTree( )
    {
        root = null;
    }

    public void insert( AnyType [ ] x )
    {
        root = insert( x, root, 0 );
    }

    private KdNode<AnyType> insert( AnyType [ ] x, KdNode<AnyType> t, int level )
    {
        if( t == null )
            t = new KdNode<>( x );
        else if( x[ level ].compareTo( t.data[ level ] ) < 0 )
            t.left = insert( x, t.left, 1 - level );
        else
            t.right = insert( x, t.right, 1 - level );
        return t;
    }

    /**
     * Print items satisfying
     * low[ 0 ] <= x[ 0 ] <= high[ 0 ] and
     * low[ 1 ] <= x[ 1 ] <= high[ 1 ].
     */
    public void printRange( AnyType [ ] low, AnyType [ ] high )
    {
        printRange( low, high, root, 0 );
    }

    private void printRange( AnyType [ ] low, AnyType [ ] high,
                             KdNode<AnyType> t, int level )
    {
        if( t != null )
        {
            if( low[ 0 ].compareTo( t.data[ 0 ] ) <= 0 &&
                        low[ 1 ].compareTo( t.data[ 1 ] ) <= 0 &&
                       high[ 0 ].compareTo( t.data[ 0 ] ) >= 0 &&
                       high[ 1 ].compareTo( t.data[ 1 ] ) >= 0 )
                System.out.println( "(" + t.data[ 0 ] + ","
                                        + t.data[ 1 ] + ")" );

            if( low[ level ].compareTo( t.data[ level ] ) <= 0 )
                printRange( low, high, t.left, 1 - level );
            if( high[ level ].compareTo( t.data[ level ] ) >= 0 )
                printRange( low, high, t.right, 1 - level );
        }
    }

    public static void main( String [ ] args )
    {
        KdTree<Integer> t = new KdTree<>( );
        
        System.out.println( "Starting program" );
        for( int i = 300; i < 370; i++ )
        {
            Integer [ ] it = new Integer[ 2 ];
            it[ 0 ] = i;
            it[ 1 ] = 2500 - i;
            t.insert( it );
        }

        Integer [ ] low = { 70, 2186 };
        Integer [ ] high = { 1200, 2200 };

        t.printRange( low, high );
    }
}
