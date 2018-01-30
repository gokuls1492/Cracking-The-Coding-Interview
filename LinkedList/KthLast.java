import java.util.Scanner;

/**
 * 2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthLast {

    public static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    public static void findKthRecursive(Node head, int k){
        findKthLastHelper(head, k);
    }

    public static int findKthLastHelper(Node cur, int k){
        if (cur == null)
            return 0;

        int index = findKthLastHelper(cur.getNext(), k) + 1;
        if (index == k)
            System.out.print(cur.getData());

        return index;
    }

    public static int findKthToLast(Node head, int k){
        if (head == null) return -1;
        Node p1 = head, p2 = head;
        for (int i=1; i<k ; i++)
            if (p1 !=null)
                p1 = p1.getNext();

        if (p1!=null){
            while (p1.getNext() !=null){
                p2 = p2.getNext();
                p1= p1.getNext();
            }
            return p2.getData();
        }else return -1;
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
        System.out.println("Enter k value:");
        int k = Integer.parseInt(sc.nextLine());
        System.out.println("kth element from last : ");
        findKthRecursive(head, k);
    }
}
