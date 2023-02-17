package tree;

import java.util.Comparator;

public class BinTree<K,V> {
    // 노드
    static class Node<K,V> {
        private K key; // 키
        private V value; // 값
        private Node<K,V> left; // 왼쪽 포인터(왼쪽 자식노드에 대한 참조)
        private Node<K,V> right; // 오른쪽 포인터(오른쪽 자식노드에 대한 참조)

        // 생성자
        Node(K key, V value, Node<K,V> left, Node<K,V> right) {
            this.key   = key;
            this.value  = value;
            this.left  = left;
            this.right = right;
        }

        // 키값을 반환
        K getKey() {
            return key;
        }

        // 데이터를 반환
        V getValue() {
            return value;
        }

        // 데이터를 표시
        void print() {
            System.out.println(value);
        }
    }

    private Node<K,V> root; // 루트
    private Comparator<? super K> comparator = null; // 비교자

    // 생성자
    public BinTree() {
        root = null;
    }

    // 생성자
    public BinTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    // 두 키값을 비교
    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
                : comparator.compare(key1, key2);
    }

    // 키로 검색
    public V search(K key)    {
        Node<K,V> node = root; // 루트

        while (true) {
            if (node == null)  // 더 이상 나아갈 수 없으면
                return null; // 검색 실패
            int cond = comp(key, node.getKey());  // key와 노드의 키를 비교
            if (cond == 0)  // 같으면
                return node.getValue(); // 검색 성공
            else if (cond < 0)  // key 쪽이 작으면
                node = node.left; // 왼쪽 서브트리에서 검색
            else // key 쪽이 크면
                node = node.right; // 오른쪽 서브트리에서 검색
        }
    }

    // node를 뿌리로 하는 서브트리에 노드 <K,V>를 삽입
    private void addNode(Node<K,V> node, K key, V value) {
        int cond = comp(key, node.getKey());
        if (cond == 0) // key가 이미 존재
            return;
        else if (cond < 0) {
            if (node.left == null)
                node.left = new Node<K,V>(key, value, null, null); // 왼쪽에 노드 삽입
            else
                addNode(node.left, key, value); // 왼쪽 서브트리에 주목
        } else {
            if (node.right == null)
                node.right = new Node<K,V>(key, value, null, null); // 오른쪽에 노드 삽입
            else
                addNode(node.right, key, value); // 오른쪽 서브트리에 주목
        }
    }

    // 노드 삽입
    public void add(K key, V value) {
        if (root == null)
            root = new Node<K,V>(key, value, null, null);
        else
            addNode(root, key, value);
    }

    // 키값이 key인 노드를 삭제
    public boolean remove(K key) {
        Node<K,V> node = root;  // 스캔 중인 노드
        Node<K,V> pNode = null; // 스캔 중인 노드의 부모노드
        boolean isLeftChild = true; // node는 pNode의 왼쪽 자식노드인가?

        while (true) {
            if (node == null) // 더 이상 나아갈 수 없으면
                return false; // 그 키값은 존재하지 않음
            int cond = comp(key, node.getKey()); // key와 노드 p의 키값을 비교
            if (cond == 0) // 같으면
                break; // 검색 성공
            else {
                pNode = node; // 가지로 내려가기 전에 부모 설정
                if (cond < 0) { // key 쪽이 작으면
                    isLeftChild = true; // 왼쪽의 자식으로 내려감
                    node = node.left; // 왼쪽 서브트리에서 검색
                } else { // key 쪽이 크면
                    isLeftChild = false; // 오른쪽의 자식으로 내려감
                    node = node.right; // 오른쪽 서브트리에서 검색
                }
            }
        }
        // node : 삭제해야할 노드
        // pNode : 삭제해야할 노드의 부모 노드

        if (node.left == null) { // node에 왼쪽의 자식이 없음
            if (node == root)
                root = node.right;
            else if (isLeftChild)
                pNode.left  = node.right; // 부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
            else
                pNode.right = node.right; // 부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
        } else if (node.right == null) { // node에 오른쪽 자식이 없음
            if (node == root)
                root = node.left;
            else if (isLeftChild)
                pNode.left  = node.left; // 부모의 왼쪽 포인터가 왼쪽 자식을 가리킴
            else
                pNode.right = node.left; // 부모의 오른쪽 포인터가 왼쪽 자식을 가리킴
        } else { // 오른쪽/왼쪽 다 있음
            pNode = node;
            Node<K,V> maxLeft = node.left; // 서브트리 가운데 최대 노드
            isLeftChild = true;
            while (maxLeft.right != null) { // 최대 노드의 left를 검색
                pNode = maxLeft;
                maxLeft = maxLeft.right;
                isLeftChild = false;
            }
            node.key  = maxLeft.key; //  left의 키를 node로 이동
            node.value = maxLeft.value; //  left의 값을 node로 이동
            if (isLeftChild)
                pNode.left  = maxLeft.left; // left를 삭제
            else
                pNode.right = maxLeft.left; // left를 삭제
        }
        return true;
    }

    // node를 루트로 하는 서브트리의 노드를 키값의 오름차순으로 표시
    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left); // 왼쪽 서브트리를 키값의 오름차순으로 표시
            System.out.println(node.key + " " + node.value); // node를 표시
            printSubTree(node.right); // 오른쪽 서브트리를 키값의 오름차순으로 표시
        }
    }

    // 전체 노드를 키값의 오름차순으로 표시
    public void print() {
        printSubTree(root);
    }
}
