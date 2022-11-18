package uk.ac.tees.linkedlistica;

/**
 * Represents a singly linked list.
 * @author Richard North (a0313108@tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class DoublyLinkedList {
    
    /**
     * Stores the first node in the list.
     */
    public DoublyLinkedListNode head;
      
    /**
     * Creates a new doubly linked list from an existing array.
     * @param data  the array to create the new linked list from
     */
    public DoublyLinkedList(int[] data) {
        
        // DO NOT MODIFY THIS CONSTRUCTOR.
           
        for (int i = data.length - 1; i >= 0; i--) {
            DoublyLinkedListNode n = new DoublyLinkedListNode(data[i], head, 
                    null);
            if (head != null) {
                head.prev = n;
            }
            head = n;
        }
    }
    
    
    /**
     * Gets the length of the doubly linked list.
     * @return  the length
     */
    public int getSize() {
        DoublyLinkedListNode current = head;
        int counter = 0;
        while(current != null){
            counter ++;
            current = current.next;
        }
        return counter;
    }
    
    /**
     * Gets the last item in the doubly linked list, or -999 if not found.
     * @return  the last item, or -999 if empty
     */
    public int getLast() {
        DoublyLinkedListNode current = head;
        int dataToReturn = -999;
        if (head != null){
            while(current.next != null){
                current = current.next;
            }
            dataToReturn = current.data;
        }
        return dataToReturn;
    }
    
    /**
     * Deletes all nodes with the given value, returning the number of nodes
     * deleted.
     * @param obj   the value
     * @return      the number of nodes deleted
     */
    public int deleteAllNodesWithValue(int obj) {
        DoublyLinkedListNode current = head;
        int dataToReturn = 0;
        
        while (current != null) {
            if (current.data == obj) {
                if (current.prev == null) {
                    head = current.next;
                    head.prev.next = null;
                    head.prev = null;
                }else if (current.next == null){
                    DoublyLinkedListNode previousNode = current.prev;
                    DoublyLinkedListNode nodeToDelete = previousNode.next;                    
                    previousNode.next = null;                  
                    nodeToDelete.next = null;
                    nodeToDelete.prev = null;
                    current = previousNode;
                }else {
                    DoublyLinkedListNode previousNode = current.prev;
                    DoublyLinkedListNode nodeToDelete = previousNode.next;
                    DoublyLinkedListNode nextNode = nodeToDelete.next;
                    previousNode.next = nextNode;
                    nextNode.prev = previousNode;
                    nodeToDelete.next = null;
                    nodeToDelete.prev = null;
                    current = previousNode;

                }
                dataToReturn++;
            }
            current = current.next;
        }
        return dataToReturn;
    }

    /**
     * Deletes the node in the list at the specified index.
     * @param index the index
     * @return      true if successful, otherwise false
     */
    public boolean deleteAtPos(int index) {
        int currentIndex = 0;
        if(currentIndex == index){
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            return true;
        }else{
            DoublyLinkedListNode current = head;
            while(current != null){
                if(currentIndex == index-1){
                    DoublyLinkedListNode nodeToDelete = current.next;
                    DoublyLinkedListNode nextNode = nodeToDelete.next;
                    nextNode.prev = current;
                    current.next = nextNode;
                    nodeToDelete.next = null;
                    nodeToDelete.prev = null;
                    return true;
                }
                currentIndex ++;
                current = current.next;
            }
            
        }
        return false;
        
    }
    
     /**
     * Count the number of even nodes in the list.
     * @return number of even nodes
     */
    public int evenNodes(){  
        DoublyLinkedListNode current = head;
        int dataToReturn = 0;
        while(current != null){
            if(current.data %2 == 0){
                dataToReturn ++;
            }
            current = current.next;
        }
        return dataToReturn;
    }
    
      /**
     * Delete second node in the list
     * @return true if successful, false if there is no second node in the list
     */
    public boolean deleteSecond(){
        if(getSize() == 2 ){
            DoublyLinkedListNode toDelete = head.next;
            head.next = null;
            toDelete.prev = null;
            return true;
        }else if(getSize() > 2){
            DoublyLinkedListNode thirdNode = head.next.next;
            DoublyLinkedListNode toDelete = head.next;
            thirdNode.prev = head;
            head.next = thirdNode;
            toDelete.prev = null;
            toDelete.next = null;
            return true;
        }else{
            return false;
        }
        
    }
    
    
    
    /**
     * Adds an item to the end of the list.
     * @param obj   the item
     */
    public boolean addSecondLast(int obj) {  
        if(getSize() >= 2){
            DoublyLinkedListNode current = head;
            while(current.next.next != null){
                current = current.next;
            }
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(obj);
            DoublyLinkedListNode lastNode = current.next;
            newNode.next = lastNode;
            lastNode.prev = newNode;
            current.next = newNode;
            return true;
        }else{
            return false;
        }
        
    }
    /**
     * A method to return the data contained within a list as a string
     * @return the data in the list separated  by a space
     */
    @Override
    public String toString() {
        String output = "";
        DoublyLinkedListNode current = head;
        while(current != null){
            output += current.data + " ";
            current = current.next;
        }
        return output;
    }
    
}
