package com.xp.java.dataalgorithms;// MemoryCell class
//  Object read( )         -->  Returns the stored value
//  void write( Object x ) -->  x is stored

public class MemoryCell<AnyType>
{
        // Public methods
    public AnyType read( )
      { return storedValue; }
    public void write( AnyType x )
      { storedValue = x; }

        // Private internal data representation
    private AnyType storedValue;
}
