package list;

import java.util.Comparator;

public class LinkedList<E> {

    public LinkedList() {
        // 노드가 하나도 없는 상태
        head = crnt = null;
    }

    // 노드
    class Node<E> {
        private E data; // 데이터
        private Node<E> next; // 다음 노드 참조

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; // 머리 노드
    private Node<E> crnt; // 선택 노드

    // 노드 검색
    // (검색할 때 key가 되는 데이터는 넣어둔 obj, 데이터를 비교하기 위한 comparator)
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head; // 머리노드 부터 비교

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) { // 검색 성공
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next; // 다음 노드 선택
        }
        return null; //  검색 실패
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        Node<E> ptr = head; // 삽입 전의 머리 노드
        head = crnt = new Node<E>(obj, ptr);
    }

    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        // 리스트가 비어있다면
        if (head == null) {
            addFirst(obj); // 머리 삽입과 동일
        } else {
            Node<E> ptr = head;
            while (ptr.next != null) { // 꼬리 노드를 찾음
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    // 머리 노드를 삭제
    private void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
        }
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (head != null) {
            if (head.next == null) { // 노드가 하나만 있다면
                removeFirst(); // 머리 노드 삭제와 동일
            } else {
                Node<E> ptr = head; // 스캔 중인 노드
                Node<E> post = head.next; // 스캔 중인 노드의 뒤쪽 노드

                while (post.next != null) { // 꼬리 직전 노드 찾음
                    ptr = post;
                    post = post.next;
                }
                ptr.next = null; // 삭제 후 꼬리 노드
                crnt = ptr;
            }
        }
    }

    // 특정 노드를 삭제
    public void remove(Node<E> p) {
        if (head != null) {
            if (p == head) { // p가 머리 노드면
                removeFirst(); // 머리노드삭제와 동일
            } else {
                Node<E> ptr = head;

                while (ptr.next != p) { // 특정 노드 앞쪽 노드 찾음
                    ptr = ptr.next;
                    if (ptr == null) return; // p가 리스트에 존재하지 않음
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    // 선택 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear() {
        while (head != null) {
            removeFirst();
        }
        crnt = null;
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (crnt == null || crnt.next == null) {
            return false; // 이동 불가
        }
        crnt = crnt.next;
        return true;
    }

    // 선택 노드 출력
    private void printCurrentNode() {
        if (crnt == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(crnt.data);
        }
    }

    // 모든 노드 출력
    private void dump() {
        Node <E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
