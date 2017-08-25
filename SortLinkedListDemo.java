import java.util.*; 

/**
   This class is used to demonstrate the sort and 
   reverse operations in the SortLinkedList class.
*/

public class SortLinkedListDemo
{    
    private static SortLinkedList ll;    
    /** 
       main method gets things started.
    */
    
    public static void main(String [ ] args)
    {
        ll = new SortLinkedList();
        
        Random rand = new Random();
        
        String[] declaration = {"Prudence", "indeed", "will", "dictate", "that",
          "governments", "long", "established", "should", "not", "be", "changed", "for", 
          "light", "and", "transient", "causes"};
        
        for (String i: declaration){
          
          ll.add(i);
          
        }
        
        System.out.println("Original list: ");
        System.out.println(ll);
        
        System.out.println("Sorted list: ");
        ll.sort();
        System.out.println(ll);
        
        System.out.println("Reversed list: ");
        ll.reverse();
        System.out.println(ll);
        
    }   
    
}


