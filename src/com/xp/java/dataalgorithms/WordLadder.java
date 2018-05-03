package com.xp.java.dataalgorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Queue;

/*
DISTRIBUTION OF DICTIONARY:
Read the words...88984
1       1
2       48
3       601
4       2409
5       4882
6       8205
7       11989
8       13672
9       13014
10      11297
11      8617
12      6003
13      3814
14      2173
15      1169
16      600
17      302
18      107
19      53
20      28
Elapsed time FAST: 2.8 vs 3.8
Elapsed time MEDIUM: 50.9 vs 50.5
Elapsed time SLOW: 95.9 vs 96.1 (H vs T)
**/

public class WordLadder
{
    public static List<String> readWords( BufferedReader in ) throws IOException
    {
            String oneLine;
            List<String> lst = new ArrayList<>( );

            while( ( oneLine = in.readLine( ) ) != null )
                    lst.add( oneLine );

            return lst;
    }    
    
    // Returns true is word1 and word2 are the same length
    // and differ in only one character.
    private static boolean oneCharOff( String word1, String word2 )
    {
            if( word1.length( ) != word2.length( ) )
                return false;

            int diffs = 0;

            for( int i = 0; i < word1.length( ); i++ )
                if( word1.charAt( i ) != word2.charAt( i ) )
                    if( ++diffs > 1 )
                        return false;

            return diffs == 1;
    }
    
    private static <KeyType> void update( Map<KeyType,List<String>> m, KeyType key, String value )
    {
            List<String> lst = m.get( key );
            if( lst == null )
            {
                lst = new ArrayList<>( );
                m.put( key, lst );
            }

            lst.add( value );
    }
    
    // Computes a map in which the keys are words and values are Lists of words
    // that differ in only one character from the corresponding key.
    // Uses a quadratic algorithm (with appropriate Map).
    public static Map<String,List<String>> computeAdjacentWordsSlow( List<String> theWords )
    {
            Map<String,List<String>> adjWords = new HashMap<>( );

            String [ ] words = new String[ theWords.size( ) ];

            theWords.toArray( words );    
            for( int i = 0; i < words.length; i++ )
                for( int j = i + 1; j < words.length; j++ )
                    if( oneCharOff( words[ i ], words[ j ] ) )
                    {
                        update( adjWords, words[ i ], words[ j ] );
                        update( adjWords, words[ j ], words[ i ] );
                    }

            return adjWords;
    }
    
    // Computes a map in which the keys are words and values are Lists of words
    // that differ in only one character from the corresponding key.
    // Uses a quadratic algorithm (with appropriate Map), but speeds things up a little by
    // maintaining an additional map that groups words by their length.
    public static Map<String,List<String>> computeAdjacentWordsMedium( List<String> theWords )
    {
            Map<String,List<String>> adjWords = new HashMap<>( );
            Map<Integer,List<String>> wordsByLength = new HashMap<>( );

              // Group the words by their length
            for( String w : theWords )
                update( wordsByLength, w.length( ), w );

              // Work on each group separately
            for( List<String> groupsWords : wordsByLength.values( ) )
            {
                String [ ] words = new String[ groupsWords.size( ) ];

                groupsWords.toArray( words );    
                for( int i = 0; i < words.length; i++ )
                    for( int j = i + 1; j < words.length; j++ )
                        if( oneCharOff( words[ i ], words[ j ] ) )
                        {
                            update( adjWords, words[ i ], words[ j ] );
                            update( adjWords, words[ j ], words[ i ] );
                        }
            }

            return adjWords;
    }
    
    
    // Computes a map in which the keys are words and values are Lists of words
    // that differ in only one character from the corresponding key.
    // Uses an efficient algorithm that is O(N log N) with a TreeMap, or
    // O(N) if a HashMap is used.
    public static Map<String,List<String>> computeAdjacentWords( List<String> words )
    {
            Map<String,List<String>> adjWords = new TreeMap<>( );
            Map<Integer,List<String>> wordsByLength = new TreeMap<>( );

              // Group the words by their length
            for( String w : words )
                update( wordsByLength, w.length( ), w );

              // Work on each group separately
            for( Map.Entry<Integer,List<String>> entry : wordsByLength.entrySet( ) )
            {    
                List<String> groupsWords = entry.getValue( );
                int groupNum = entry.getKey( );

                // Work on each position in each group
                for( int i = 0; i < groupNum; i++ )
                {
                    // Remove one character in specified position, computing representative.
                    // Words with same representative are adjacent, so first populate
                    // a map
                    Map<String,List<String>> repToWord = new HashMap<>( );

                    for( String str : groupsWords )
                    {
                        String rep = str.substring( 0, i ) + str.substring( i + 1 );
                        update( repToWord, rep, str );
                    }

                    // and then look for map values with more than one string
                    for( List<String> wordClique : repToWord.values( ) )
                        if( wordClique.size( ) >= 2 )
                            for( String s1 : wordClique )
                                for( String s2 : wordClique )
                                    if( s1 != s2 )  // must be same string; equals not needed
                                        update( adjWords, s1, s2 );
                }
            }

            return adjWords;
    }
                
    // Find most changeable word: the word that differs in only one
    // character with the most words. Return a list of these words, in case of a tie.
    public static List<String> findMostChangeable( Map<String,List<String>> adjacentWords )
    {
            List<String> mostChangeableWords = new ArrayList<>( );
            int maxNumberOfAdjacentWords = 0;

            for( Map.Entry<String,List<String>> entry : adjacentWords.entrySet( ) )
            {
                List<String> changes = entry.getValue( );

                if( changes.size( ) > maxNumberOfAdjacentWords )
                {
                    maxNumberOfAdjacentWords = changes.size( );
                    mostChangeableWords.clear( );
                }
                if( changes.size( ) == maxNumberOfAdjacentWords )
                    mostChangeableWords.add( entry.getKey( ) );
            }

            return mostChangeableWords;
    }    
    
    public static void printMostChangeables( List<String> mostChangeable,
                                     Map<String,List<String>> adjacentWords )
    {
            for( String word : mostChangeable )
            {
                System.out.print( word + ":" );
                List<String> adjacents = adjacentWords.get( word );
                for( String str : adjacents )
                    System.out.println( " " + str );
                System.out.println( " (" + adjacents.size( ) + " words)" );
            }
    }    
    
    public static void printHighChangeables( Map<String,List<String>> adjacentWords,
                                             int minWords )
        {
            for( Map.Entry<String,List<String>> entry : adjacentWords.entrySet( ) )
            {
                List<String> words = entry.getValue( );

                if( words.size( ) >= minWords )
                {
                    System.out.print( entry.getKey( ) + " )" + words.size( ) + "):" );
                    for( String w : words )
                        System.out.print( " " + w );
                    System.out.println( );
                }
            }
        }    
    
    // After the shortest path calculation has run, computes the List that
    // contains the sequence of word changes to get from first to second.
    public static List<String> getChainFromPreviousMap( Map<String,String> prev,
                                                String first, String second )
    {
            LinkedList<String> result = new LinkedList<>( );
        
            if( prev.get( second ) != null )
                for( String str = second; str != null; str = prev.get( str ) )
                    result.addFirst( str );
        
            return result;
    }
    
    // Runs the shortest path calculation from the adjacency map, returning a List
    // that contains the sequence of words changes to get from first to second.
    public static List<String> findChain( Map<String,List<String>> adjacentWords, String first, String second )            
    {
            Map<String,String> previousWord = new HashMap<>( );
            Queue<String> q = new LinkedList<>( );

            q.add( first );
            while( !q.isEmpty( ) )
            {
                String current = q.element( ); q.remove( );
                List<String> adj = adjacentWords.get( current );

                if( adj != null )
                    for( String adjWord : adj )
                        if( previousWord.get( adjWord ) == null )
                        {
                            previousWord.put( adjWord, current );
                            q.add( adjWord );
                        }                                                
            }

            previousWord.put( first, null );

            return getChainFromPreviousMap( previousWord, first, second );
    }
    
    // Runs the shortest path calculation from the original list of words, returning
    // a List that contains the sequence of word changes to get from first to
    // second. Since this calls computeAdjacentWords, it is recommended that the
    // user instead call computeAdjacentWords once and then call other findChar for
    // each word pair.
    public static List<String> findChain( List<String> words, String first, String second )
    {
            Map<String,List<String>> adjacentWords = computeAdjacentWords( words );
            return findChain( adjacentWords, first, second );
    }
    
    public static void main( String [ ] args ) throws IOException
    {
            long start, end;

            FileReader fin = new FileReader( "dict.txt" );
            BufferedReader bin = new BufferedReader( fin );
            List<String> words = readWords( bin );
            System.out.println( "Read the words..." + words.size( ) );
            Map<String,List<String>> adjacentWords;

            start = System.currentTimeMillis( );
            adjacentWords = computeAdjacentWords( words );
            end = System.currentTimeMillis( );
            System.out.println( "Elapsed time FAST: " + (end-start) );

            start = System.currentTimeMillis( );
            adjacentWords = computeAdjacentWordsMedium( words );
            end = System.currentTimeMillis( );
            System.out.println( "Elapsed time MEDIUM: " + (end-start) );


            start = System.currentTimeMillis( );
            adjacentWords = computeAdjacentWordsSlow( words );
            end = System.currentTimeMillis( );
            System.out.println( "Elapsed time SLOW: " + (end-start) );


            // printHighChangeables( adjacentWords, 15 );

            System.out.println( "Adjacents computed..." );
            List<String> mostChangeable = findMostChangeable( adjacentWords );
            System.out.println( "Most changeable computed..." );
            printMostChangeables( mostChangeable, adjacentWords );

            BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );

            for( ; ; )
            {
                System.out.println( "Enter two words: " );
                String w1 = in.readLine( );
                String w2 = in.readLine( );

                List<String> path = findChain( adjacentWords, w1, w2 );
                System.out.print( path.size( ) + "..." );
                for( String word : path )
                        System.out.print( " " + word );
                System.out.println( );    
            }
    }
}
