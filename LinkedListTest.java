public class LinkedListTest {
    public static void main(String[] args) {
//        LinkedList.ListNode node1;
//        LinkedList.ListNode node2;
//
//        LinkedList.ListNode head = null;
//        LinkedList list = new LinkedList();
//
//        node1 = new LinkedList.ListNode(1);
//        head = list.add(head, node1, 1);
//
//        System.out.println(list.contains(head, node1));
//
//        node2 = new LinkedList.ListNode(2);
//        head = list.add(head, node2, 1);
//
//        System.out.println(list.contains(head, node1));
//        System.out.println(list.contains(head, node2));
//
//        head = list.remove(head, 1);
//
//        System.out.println(list.contains(head, node1));
//        System.out.println(list.contains(head, node2));

        ListNodeStack stack = new ListNodeStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

    }
}
