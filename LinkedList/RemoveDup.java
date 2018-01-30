import java.util.HashSet;
import java.util.Scanner;

/**
 *2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
 FOLLOW UP
 How would you solve this problem if a temporary buffer is not allowed?
 */

public class RemoveDup {
    public static void removeDuplicate(Node head){
        Node cur = head, prev = null;
        HashSet<Integer> dup = new HashSet<>();
        while (cur != null) {
            if (dup.contains(cur.getData()))
                prev.setNext(cur.getNext());
            else {
                dup.add(cur.getData());
                prev = cur;
            }
            cur = cur.getNext();
        }
    }
    //Space - O(1)  Time - O(n^2)
    public static void removeDuplicateWithoutBuffer(Node head){
        Node cur  = head, prev =head;
        while (cur!=null){
            Node next = cur.getNext();
            while (next != null){
                if (next.getData() == cur.getData()){
                    prev.setNext(next.getNext());
                    next = prev.getNext();
                }
                else{
                    prev = next;
                    next = next.getNext();
                }
            }
            cur = cur.getNext();
        }
    }

    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    public static void main(String[] args){
        int input; char flag;
        Node dummy = new Node(0);
        Node cur = dummy;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter the data");
            input = Integer.parseInt(sc.nextLine());
            Node temp = new Node(input);
            cur.setNext(temp);
            cur = cur.getNext();
            System.out.println("Enter Y to continue or N to exit");
            flag = sc.nextLine().toUpperCase().charAt(0);
        } while (flag != 'N');
        Node head = dummy.getNext();
        System.out.println("Print elements:Before");
        printList(head);
        removeDuplicateWithoutBuffer(head);
        System.out.println("Print elements:After");
        printList(head);
    }
}
