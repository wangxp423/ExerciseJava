package com.xp.java.dataalgorithms;// LeftistHeap class
//
// CONSTRUCTION: with a negative infinity sentinel
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void merge( rhs )      --> Absorb rhs into this heap
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements a leftist heap.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class LeftistHeap<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the leftist heap.
     */
    public LeftistHeap( )
    {
        root = null;
    }

    /**
     * Merge rhs into the priority queue.
     * rhs becomes empty. rhs must be different from this.
     * @param rhs the other leftist heap.
     */
    public void merge( LeftistHeap<AnyType> rhs )
    {
        if( this == rhs )    // Avoid aliasing problems
            return;

        root = merge( root, rhs.root );
        rhs.root = null;
    }

    /**
     * Internal method to merge two roots.
     * Deals with deviant cases and calls recursive merge1.
     */
    private LeftistNode<AnyType> merge( LeftistNode<AnyType> h1, LeftistNode<AnyType> h2 )
    {
        if( h1 == null )
            return h2;
        if( h2 == null )
            return h1;
        if( h1.element.compareTo( h2.element ) < 0 )
            return merge1( h1, h2 );
        else
            return merge1( h2, h1 );
    }

    /**
     * Internal method to merge two roots.
     * Assumes trees are not empty, and h1's root contains smallest item.
     */
    private LeftistNode<AnyType> merge1( LeftistNode<AnyType> h1, LeftistNode<AnyType> h2 )
    {
        if( h1.left == null )   // Single node
            h1.left = h2;       // Other fields in h1 already accurate
        else
        {
            h1.right = merge( h1.right, h2 );
            if( h1.left.npl < h1.right.npl )
                swapChildren( h1 );
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    /**
     * Swaps t's two children.
     */
    private static <AnyType> void swapChildren( LeftistNode<AnyType> t )
    {
        LeftistNode<AnyType> tmp = t.left;
        t.left = t.right;
        t.right = tmp;
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = merge( new LeftistNode<>( x ), root );
    }

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw UnderflowException if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return root.element;
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw UnderflowException if empty.
     */
    public AnyType deleteMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );

        AnyType minItem = root.element;
        root = merge( root.left, root.right );

        return minItem;
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }
    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    private static class LeftistNode<AnyType>
    {
            // Constructors
        LeftistNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        LeftistNode( AnyType theElement, LeftistNode<AnyType> lt, LeftistNode<AnyType> rt )
        {
            element = theElement;
            left    = lt;
            right   = rt;
            npl     = 0;
        }

        AnyType              element;      // The data in the node
        LeftistNode<AnyType> left;         // Left child
        LeftistNode<AnyType> right;        // Right child
        int                  npl;          // null path length
    }
    
    private LeftistNode<AnyType> root;    // root

    public static void main( String [ ] args )
    {
        int numItems = 100;
        LeftistHeap<Integer> h  = new LeftistHeap<>( );
        LeftistHeap<Integer> h1 = new LeftistHeap<>( );
        int i = 37;

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            if( i % 2 == 0 )
                h1.insert( i );
            else
                h.insert( i );

        h.merge( h1 );
        for( i = 1; i < numItems; i++ )
            if( h.deleteMin( ) != i )
                System.out.println( "Oops! " + i );
    }
}
