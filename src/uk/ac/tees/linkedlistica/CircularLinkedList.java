package uk.ac.tees.linkedlistica;

/**
 * Represents a circular linked list.
 * @author Richard North (a0313108@tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class CircularLinkedList {
    
    /**
     * Stores the first node in the list. Should always be a sentinel node.
     */
    public ListNode head;
    
    /**
     * Creates a new circular linked list from an existing array.
     *
     * @param data  the array to create the new linked list from
     */
    public CircularLinkedList(int[] data) {
        
        // DO NOT MODIFY THIS CONSTRUCTOR.
        
        // The head is a sentinel node.
        head = new ListNode(-999, null);
        head.next = head; // Complete the circle.
        
        // Populate list.
        ListNode n = head; // The last item in the circle.
        for (int i = 0; i < data.length; i++) {
            n.next = new ListNode(data[i], head);
            n = n.next;
        }
    }
    
    
    /**
     * Gets whether or not the list is empty.
     * @return  true if list is empty, otherwise false
     */
    public boolean isEmpty() {
        return head.next == head;
    }
    
    /**
     * Returns the list as a string of the form "{item1, item2, ...}"
     * @return  the resulting string
     */
    @Override
    public String toString() {
        String output = "";
        // Set the pointer to the head
        ListNode current = head.next;
        while(current != head){
            if(current.next == head){
                output += current.data;
            }else{
                output += current.data + ", ";
            }
            current = current.next;
            
        }
       return "{"+output+"}";
    }
    
    /**
     * Count all nodes with the given value, returning the number of nodes.
     * @param obj   the value
     * @return      the number of nodes with value obj
     */
    public int countNodesWithValue(int obj) { 
                // Set the pointer to the head
        ListNode current = head.next;
        int valueToReturn = 0;
        while(current != head){
            if(current.data == obj){
                valueToReturn ++;
            }
            current = current.next;
        }
        return valueToReturn;
    }
    
    
         /**
     * Count all nodes with the given value, returning the number of nodes.
     * @param obj   the value
     * @return      the number of nodes with value obj
     */
    public int searchIndex(int obj) { 
        ListNode current = head.next;
        int valueToReturn = head.data;
        int currentIndex = 0;
        while(current != head){
            if(current.data == obj){
                valueToReturn = currentIndex;
            }
            currentIndex ++;
            current = current.next;
        }
        return valueToReturn;
    }
    
    
    /**
     * Returns the product of all integers in the list.
     * @return  the product
     */
    public int product() {
        ListNode current = head.next;
        int valueToReturn = head.next != head ? 1:0;
        while(current != head){
            valueToReturn *= current.data;            
            current = current.next;
        }
        return valueToReturn;
    }
    
    /**
     * Deletes any node containing a value that is a multiple of three.
     * @return the  number of nodes deleted
     */
    public int deleteMultiplesOfThree() {
        ListNode previous = head;
        ListNode current = head.next;
        int valueToReturn = 0;
        while(current != head){
            if(current.data %3 == 0){
                ListNode toDelete = current;
                previous.next = toDelete.next;
                toDelete.next = null;
                valueToReturn ++;
                current = previous;
            }
            previous = current;
            current = current.next;
        }
        return valueToReturn;
    }
    
}
