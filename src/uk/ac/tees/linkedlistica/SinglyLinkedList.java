package uk.ac.tees.linkedlistica;

/**
 * Represents a singly linked list.
 * @author Richard North (a0313108@tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class SinglyLinkedList {
    
    /**
     * Stores the first node in the list.
     */
    public ListNode head;
    
    /**
     * Creates a new singly linked list from an existing array.
     * @param data  the array to create the new linked list from
     */
    public SinglyLinkedList(int[] data) {
        
        // DO NOT MODIFY THIS CONSTRUCTOR.
        
        // Populate list.
        for (int i = data.length - 1; i >= 0; i--) {
            head = new ListNode(data[i], head);
        }
    }
    
    /**
     * Creates a new, empty singly linked list.
     */
    public SinglyLinkedList() {
        
        // DO NOT MODIFY THIS CONSTRUCTOR.
        
        this(new int[] {});
    }
    
    
   /**
     * Adds an item at the front of the list.
     * @param value   the item to add
     */
    public void addFirst(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }

    }
     

    /**
     * Gets the item at the specified index in the list.
     * @param index the index
     * @return      the item, or -999 if not found
     */
    public int getAtPos(int index) {
        int currentIndex = 0;
        int valueToReturn = -999;
        ListNode current = head;
        while(current != null){
            if (currentIndex == index){
                valueToReturn = current.data;
            }
            currentIndex++;
            current = current.next;
        }
        return valueToReturn;
    }
    
    
     /**
     * Count all nodes with the given value, returning the number of nodes.
     * @param obj   the value
     * @return      the number of nodes with value obj
     */
    public int countNodesWithValue(int obj) {  
        int valueToReturn = 0;
        ListNode current = head;
        while(current != null){
            if(current.data == obj){
                valueToReturn++;
            }
            current = current.next;
        }
        return valueToReturn;
    }
    
    /**
     * Gets the last item in the circular linked list, or -999 if not found.
     * @return  the last item, or -999 if empty
     */
    public int getLast() {  
        int valueToReturn = -999;
        if(head != null){
            ListNode current = head;
            while(current.next != null){
                current = current.next;
            }
            valueToReturn = current.data;
        }

        return valueToReturn;
    }
    
     /**
     * Adds a piece of data at the specified index.
     * @param obj   the data
     * @param index the index
     * @return      true on successful insert, otherwise false
     */
    public boolean addAtPos(int obj, int index) {
        int currentIndex = 0;
        boolean valueToReturn = false;
        if(index == currentIndex){
            addFirst(obj);
            valueToReturn = true;
            
        }if(index > currentIndex){
            ListNode current = head;
            while(current != null){
                if (currentIndex == index - 1){
                    ListNode newNode = new ListNode(obj, current.next);
                    current.next = newNode;
                    valueToReturn = true;
                }
                currentIndex++;

                current = current.next;
            }
        }
        return valueToReturn;
    }
    
         /**
     * Appends a singly linked list to this circular linked list.
     * @param list  the singly linked list to append
     */
    public void appendSinglyLinkedList(SinglyLinkedList list) {
        ListNode current = head;
        if(current != null){
            while(current.next != null){
                current = current.next;
            }
            current.next = list.head;
        }else{
            head = list.head;
        }
    }
    
       /**
     * Returns the sum of all integers in the list.
     * @return  the sum
     */
    public int sum() {
        int valueToReturn = 0;
        if(head != null){
            ListNode current = head;
            while(current != null){
                valueToReturn += current.data;
                current = current.next;
            }
        }
        return valueToReturn;
    }

    @Override
    public String toString() {
        String output = "";
        ListNode current = head;
        while(current != null){
            output += current.data +" ";
            current = current.next;
        }
        return output;
    }
    
}

