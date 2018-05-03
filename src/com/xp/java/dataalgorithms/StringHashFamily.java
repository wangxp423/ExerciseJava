package com.xp.java.dataalgorithms;

import java.util.Random;

public class StringHashFamily implements HashFamily<String>
{
    private final int [ ] MULTIPLIERS;
    private final Random r = new Random( );
    
    public StringHashFamily( int d )
    {
        MULTIPLIERS = new int [ d ];
        generateNewFunctions( );
    }
    public int getNumberOfFunctions( )
    {
        return MULTIPLIERS.length;
    }
    
    public void generateNewFunctions( )
    {
        for( int i = 0; i < MULTIPLIERS.length; i++ )
            MULTIPLIERS[ i ] = r.nextInt( );
    }
    
    public int hash( String x, int which )
    {
        final int multiplier = MULTIPLIERS[ which ];
        int hashVal = 0;

        for( int i = 0; i < x.length( ); i++ )
            hashVal = multiplier * hashVal + x.charAt( i );
        
        return hashVal;
    }
}