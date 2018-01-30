import java.util.Scanner;

/**
 * 2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 before all nodes greater than or equal to x.

 */
public class PartitionList {

    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static void partition(Node head, int x){
        Node smallHead = new Node(-1);
        Node largeHead = new Node(-1);
        Node small = smallHead, large = largeHead, cur = head;
        while (cur != null){
            if (cur.getData() < x){
                small.setNext(cur);
                small = cur;
            }else{
                large.setNext(cur);
                large = cur;
            }
            cur = cur.getNext();
        }
        small.setNext(largeHead.getNext());
        large.setNext(null);
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
        System.out.println("Print elements: Before");
        printList(head);
        System.out.println("Enter x value:");
        int x = Integer.parseInt(sc.nextLine());
        partition(head, x);
        System.out.println("Print elements: After Partition");
        printList(head);
    }

}
