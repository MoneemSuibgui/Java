public class ListTest {
    
    public static void main(String[] args) {
        
        // instantiate SinglyLinkedList Object
        SinglyLinkedList sll=new SinglyLinkedList();
        sll.add(8);
        sll.add(17);
        sll.add(15);
        sll.add(9);
        

        sll.remove();
        sll.printValues();
        sll.find(8);
        sll.find(17);
        sll.find(15);
        sll.find(9);
        sll.find(2);
        
    }
}
