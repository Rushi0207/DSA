public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeLinkedList mergeLinkedList = new MergeLinkedList();

        // Creating linked list 1: 1->3->5->7
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);

        // Creating linked list 2: 2->4->6->8
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        // Merging both lists in non-increasing order
        Node result = mergeLinkedList.mergeResult(head1, head2);

        System.out.println("Merged List in non-increasing order:");
        printList(result);
    }
}


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

 class MergeLinkedList {

    Node mergeResult(Node head1, Node head2) {
        // Dummy node to simplify merging
        Node dummy = new Node(-1);
        Node prev = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data >= head2.data) {
                prev.next = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }

        // Add remaining elements from list1
        while (head1 != null) {
            prev.next = head1;
            head1 = head1.next;
            prev = prev.next;
        }

        // Add remaining elements from list2
        while (head2 != null) {
            prev.next = head2;
            head2 = head2.next;
            prev = prev.next;
        }

        // Reverse the merged list to make it non-increasing
        Node result = reverse(dummy.next);
        return result;
    }

    // Function to reverse a linked list
    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
