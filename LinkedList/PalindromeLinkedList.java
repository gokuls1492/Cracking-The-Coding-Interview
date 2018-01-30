import java.util.Queue;
import java.util.Scanner;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class PalindromeLinkedList {
    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static boolean isPalindrome(Node dummy){
        Node head = dummy.getNext();
        if(head == null || head.getNext() == null) return true;
        Node secHead = null;
        //dummy.setNext(head) ;
        Node fast = dummy, slow = dummy;
        //find middle node
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        //Header to second half of list
        secHead = slow.getNext();
        //break second list at middle
        slow.setNext(null);;
        //Reverse second half of list
        Node prev= null, cur = secHead, next = null;
        while(cur != null){
            next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        Node p1 = head, p2 = prev;
        while(p1!=null && p2!=null){
            if(p1.getData() != p2.getData())
                return false;
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return true;
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
        System.out.println("Is Palindrome: "+ isPalindrome(dummy));
    }
}
