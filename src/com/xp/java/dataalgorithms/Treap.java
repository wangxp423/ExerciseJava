package com.xp.java.dataalgorithms;// Treap class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is found
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements a treap.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class Treap<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the treap.
     */
    public Treap( )
    {
        nullNode = new TreapNode<>( null );
        nullNode.left = nullNode.right = nullNode;
        nullNode.priority = Integer.MAX_VALUE;
        root = nullNode;
    }

    /**
     * Insert into the tree. Does nothing if x is already present.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Does nothing if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return the smallest item, or throw UnderflowException if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );

        TreapNode<AnyType> ptr = root;

        while( ptr.left != nullNode )
            ptr = ptr.left;

        return ptr.element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item, or throw UnderflowException if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );

        TreapNode<AnyType> ptr = root;

        while( ptr.right != nullNode )
            ptr = ptr.right;

        return ptr.element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if x is found.
     */
    public boolean contains( AnyType x )
    {
        TreapNode<AnyType> current = root;
        nullNode.element = x;

        for( ; ; )
        {
            int compareResult = x.compareTo( current.element );
            
            if( compareResult < 0 )
                current = current.left;
            else if( compareResult > 0 ) 
                current = current.right;
            else
                return current != nullNode;
        }
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = nullNode;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == nullNode;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private TreapNode<AnyType> insert( AnyType x, TreapNode<AnyType> t )
    {
        if( t == nullNode )
            return new TreapNode<>( x, nullNode, nullNode );
            
        int compareResult = x.compareTo( t.element );
        
        if( compareResult < 0 )
        {
            t.left = insert( x, t.left );
            if( t.left.priority < t.priority )
                t = rotateWithLeftChild( t );
        }
        else if( compareResult > 0  )
        {
            t.right = insert( x, t.right );
            if( t.right.priority < t.priority )
                t = rotateWithRightChild( t );
        }
        // Otherwise, it's a duplicate; do nothing

        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private TreapNode<AnyType> remove( AnyType x, TreapNode<AnyType> t )
    {
        if( t != nullNode )
        {
            int compareResult = x.compareTo( t.element );
            
            if( compareResult < 0 )
                t.left = remove( x, t.left );
            else if( compareResult > 0 )
                t.right = remove( x, t.right );
            else
            {
                    // Match found
                if( t.left.priority < t.right.priority )
                    t = rotateWithLeftChild( t );
                else
                    t = rotateWithRightChild( t );

                if( t != nullNode )     // Continue on down
                    t = remove( x, t );
                else
                    t.left = nullNode;  // At a leaf
            }
        }
        return t;
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printTree( TreapNode<AnyType> t )
    {
        if( t != t.left )
        {
            printTree( t.left );
            System.out.println( t.element.toString( ) );
            printTree( t.right );
        }
    }

    /**
     * Rotate binary tree node with left child.
     */
    private TreapNode<AnyType> rotateWithLeftChild( TreapNode<AnyType> k2 )
    {
        TreapNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     */
    private TreapNode<AnyType> rotateWithRightChild( TreapNode<AnyType> k1 )
    {
        TreapNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    private static class TreapNode<AnyType>
    {
            // Constructors
        TreapNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        TreapNode( AnyType theElement, TreapNode<AnyType> lt, TreapNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
            priority = randomObj.randomInt( );
        }

            // Friendly data; accessible by other package routines
        AnyType            element;      // The data in the node
        TreapNode<AnyType> left;         // Left child
        TreapNode<AnyType> right;        // Right child
        int                priority;     // Priority

        private static Random randomObj = new Random( );
    }
    
    private TreapNode<AnyType> root;
    private TreapNode<AnyType> nullNode;
 

        // Test program
    public static void main( String [ ] args )
    {
        Treap<Integer> t = new Treap<>( );
        final int NUMS = 40000;
        final int GAP  =   307;

        System.out.println( "Checking... (no bad output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );
        System.out.println( "Inserts complete" );

        for( int i = 1; i < NUMS; i+= 2 )
            t.remove( i );
        System.out.println( "Removes complete" );

        if( NUMS < 40 )
            t.printTree( );
        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i+=2 )
            if( !t.contains( i ) )
                System.out.println( "Error: find fails for " + i );

        for( int i = 1; i < NUMS; i+=2 )
            if( t.contains( i ) )
                System.out.println( "Error: Found deleted item " + i );
    }
}
