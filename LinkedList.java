// **LinkedList**에 대해 공부하세요.
// 정수를 저장하는 ListNode 클래스를 구현하세요.
// ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
// ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
// boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.


public class LinkedList {
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        ListNode ptr = head;
        int position_temp = position;

        while (ptr != null && --position > 0 && ptr.next != null) {
            ptr = ptr.next;
        }

        if (position == 1) {
            if (ptr == null) {
                return nodeToAdd; // 머리노드
            } else { // 꼬리노드
                ptr.next = nodeToAdd;
            }
        } else if (position == 0) { // 중간노드
            nodeToAdd.next = ptr.next;
            ptr.next = nodeToAdd;
            if (position_temp == 2) { // 머리노드 바로 뒤 노드
                return ptr;
            }
        }
        return head;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        ListNode ptr = head;
        int position_temp = positionToRemove;

        while (ptr != null && --positionToRemove > 0 && ptr.next.next != null) {
            ptr = ptr.next;
        }

        if (positionToRemove == 1 && ptr != null) { // 꼬리
            ptr.next = null;
        } else if (positionToRemove == 0) {
            if (position_temp == 1) { // 머리
                return ptr.next;
            }
            if (ptr.next.next != null) {
                ptr.next = ptr.next.next; // 중간
            }
        }
        return head;
    }

    public boolean contains(ListNode head, ListNode nodeTocheck) {
        ListNode ptr = head;

        while (ptr != null) {
            if (nodeTocheck == ptr) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }
}
