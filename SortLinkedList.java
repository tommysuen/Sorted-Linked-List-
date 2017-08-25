/**
   Programming Challenge 20-2
   Linked List Sorting and Reversing.
   The SortLinkedList class implements a Linked list
   that has sort and reverse operations.
*/


/* Notice that the class SortLinkedList has fields, methods, and a constructor,
 * but also *contains a class*, Node.
 * Treat it as if they were separate files
 */


class SortLinkedList
{
    /**
       The Node class stores a list element
       and a reference to the next node.
    */
    
    private class Node
    {
        String value;   // Value of a list element
        Node next;      // Next node in the list
        
        /**
           Constructor.            
           @param val The element to be stored in the node.
           @param n The reference to the successor node.
        */
        
        Node(String val, Node n)
        {
            value = val;
            next = n;
        } 
        
        /**
           Constructor. Use when the node has no successor.
           @param val The element to be stored in the node.
        */
        
        Node(String val)
        {
           // Just call the other (sister) constructor
           this(val, null);            
        }
    }
    
    private Node first;   // First element on the list (head)
    private Node last;    // Last element on the list 
    
    /**
       Constructor.
    */
    
    public SortLinkedList()
    {
        first = null;
        last = null;        
    }
    
    /**
       The sort method sorts the list.
    */
    
    public void sort()
    {
      
      //TODO: your code here
      
        // Recommendation: Sort the list by successively inserting nodes
        // into an initially empty list
        // (by using insertSorted method, below)
        
        Node sortedList = null;      
        
       
        //TODO: Sort the list here
        
        while (first != null)
        	{
        	Node p = new Node(first.value);
        	sortedList = insertSorted(p, sortedList);
        	first = first.next;
        	}
        
        // Replace first with sorted list
        first = sortedList;
        
        // Set the last reference to the last node
        last = first;
        if (last != null)
        { 
            while (last.next != null)        
               last = last.next;   
        }
        
    }
    
    /**
       The insertSorted method inserts a node in the
       proper place in a sorted list. The method does
       not set the last reference.
       @param n The node to insert.  
       @param sortedList A sorted list.
       @return The result of inserting n at the right position in sortedList.     
    */
    
    private Node insertSorted(Node n, Node sortedList)
    {
      
      
      //TODO: add your code
       Node current = sortedList;
        // The node n goes at the beginning if the sortedList is empty
        // or if the value in n is less than the value in the head of sortedList
        if (sortedList == null || n.value.compareTo(sortedList.value) < 0)
        {
            n.next = sortedList;
            return n;
        }
        
        else 
         {while (current.next != null && current.next.value.compareTo(n.value) < 0)
         { 
        	 current = current.next;
         }
         }
        // Otherwise, scan to find the right place for n
        // store the node that will come before n
        
        
        // Put n after its predecessor
        n.next = current.next;
        current.next = n;
        
        // Return head of the now sorted list
        return sortedList;       
    }
    	
    
    
    /**
       The reverse method reverses the list.
       Makes sure the last reference is set.
    */
    
    public void reverse()
    {        
        Node previous = null;
        Node current = first;
        
        	
        // If the list is empty there is nothing to do
        if (first == null)
            return;
        
        //TODO: your code here    
        while (current != null)
        	{
        	
        	Node after = current.next;
        	
        	current.next = previous;
        	previous = current;
        	current = after;
        	
        	}
        first = previous;
    }	
    
    
    
    
    /**
       The isEmpty method checks to see if the list is empty.
    */
    
    public boolean isEmpty()
    {        
        return first == null;       
    }
    
    /**
       The size method returns the length of the list.
       @return The number of elements in the list.
    */
    
    public int size()
    {
       int count = 0;
       Node p = first;     // Use  p to walk down the list
       while (p != null)
       {
           // There is an element at p
           count ++;
           p = p.next;
       }
       return count;
    }
    
    /**
       The add method adds an element to the end of the list.
       @param e The value to add to the end of the list.       
    */
    
    public void add(String e)
    {
      if (isEmpty()) 
      {
          first = new Node(e);
          last = first;
      }
      else
      {
          // Add to end of existing list
          last.next = new Node(e);
          last = last.next;
      }      
    }
    
    /**
       This add method adds an element at an index.
       @param e The element to add to the list.
       @param index The index at which to add the element.
    */
    
    public void add(int index, String e)
    {
         if (index < 0  || index > size()) 
         {
             String message = String.valueOf(index);
             throw new IndexOutOfBoundsException(message);
         }
         
         // Index is at least 0
         if (index == 0)
         {
             // New element goes at beginning
             first = new Node(e, first);
             if (last == null)
                 last = first;
             return;
         }
         
         // Set a reference pred to point to the node that
         // will be the predecessor of the new node
         Node pred = first;        
         for (int k = 1; k <= index - 1; k++)        
         {
            pred = pred.next;           
         }
         
         // Splice in a node containing the new element
         pred.next = new Node(e, pred.next);  
         
         // Is there a new last element ?
         if (pred.next.next == null)
             last = pred.next;         
    }
    
    /**
       The toString method computes the string
       representation of the list.
       @return The string form of the list.
    */
    
    public String toString()
    {
      StringBuilder strBuilder = new StringBuilder();
      
      // Use p to walk down the linked list
      Node p = first;
      while (p != null)
      {
         strBuilder.append(p.value + "\n"); 
         p = p.next;
      }      
      return strBuilder.toString(); 
    }
    
    /**
       The remove method removes the element at an index.
       @param index The index of the element to remove. 
       @return The element removed.     
    */
    
    public String remove(int index)
    {
       if (index < 0 || index >= size())
       {  
           String message = String.valueOf(index);
           throw new IndexOutOfBoundsException(message);
       }
       
       String element;  // The element that will be returned
      
       if (index == 0)
       {
          // Removal of first item in the list
          element = first.value;    
          first = first.next;
          if (first == null)
              last = null;             
       }
       else
       {
          // To remove an element other than the first,
          // find the predecessor of the element to
          // be removed.
          Node pred = first;
          
          // Move pred forward index - 1 times
          for (int k = 1; k <= index -1; k++)
              pred = pred.next;
          
          // Store the value to return
          element = pred.next.value;
          
          // Route link around the node to be removed
          pred.next = pred.next.next;  
          
          // Check if pred is now last
          if (pred.next == null)
              last = pred;              
       }
       return element;        
    }   
    
    /**
       The remove method removes an element from the list.
       @param element The element to remove.
       @return true if the remove succeeded, false otherwise.
    */
    
    public boolean remove(String element)
    {
       if (isEmpty()) 
           return false;      
      
       if (element.equals(first.value))
       {
          // Removal of first item in the list
          first = first.next;
          if (first == null)
              last = null;       
          return true;
       }
      
      // Find the predecessor of the element to remove
      Node pred = first;
      while (pred.next != null && 
             !pred.next.value.equals(element))
      {
          pred = pred.next;
      }

      // pred.next == null OR pred.next.value is element
      if (pred.next == null)
          return false;
      
      // pred.next.value  is element
      pred.next = pred.next.next;    
      
      // Check if pred is now last
      if (pred.next == null)
          last = pred;
      
      return true;       
    }     
}

