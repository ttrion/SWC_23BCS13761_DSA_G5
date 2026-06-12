//Add 2 numbers as lists
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}

public class Session_16 {
    static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            curr.next = new Node(sum % 10);
            curr = curr.next;
            carry = sum / 10;
        }
        return dummy.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        Node result = addTwoNumbers(l1, l2);
        printList(result);
    }
}