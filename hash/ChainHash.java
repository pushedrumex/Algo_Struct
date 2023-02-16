package hash;

public class ChainHash<K, V> {
    // 해시를 구성하는 노드
    class Node<K, V> {
        private K key; // 키 값
        private V value; // 데이터
        private Node<K, V> next; // 다음 노드에 대한 참조

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // 키 반환
        K getKey() {
            return key;
        }

        // 값 반환
        V getValue() {
            return value;
        }

        // 키의 해시값을 반환
        public int hashCode() {
            return key.hashCode();
        }

    }

    private int size;
    private Node<K, V>[] table; // 키값으로 얻은 해시값(인덱스)에 node 저장

    public ChainHash(int capacity) {
        table = new Node[capacity];
        this.size = capacity;
    }

    // 해시 함수
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // 키 값에 해당하는 데이터 반환
    public V search(K key) {
        int hash = hashValue(key); // 해시값
        Node<K, V> node = table[hash]; // 첫번 째 노드
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue(); // 검색 성공
            }
            node = node.next;
        }
        return null; // 검색 실패
    }

    // key : data 추가
    public int add(K key, V data) {
        int hash = hashValue(key); // 해시값
        Node<K, V> node = table[hash]; // 첫번 째 노드

        while (node != null) {
            if (node.getKey().equals(key)) { // 이미 존재하는 키
                return 1; // 추가 실패
            }
            node = node.next;
        }
        Node<K, V> temp = new Node<K, V>(key, data, table[hash]);
        table[hash] = temp; // 리스트 맨 앞에 노드 추가
        return 0; // 추가 성공
    }

    // 키 값을 key로 갖는 요소 삭제
    public int remove(K key) {
        int hash = hashValue(key); // 삭제할 데이터의 해시 값
        Node<K, V> node = table[hash]; // 첫번 째 노드
        Node<K, V> pNode = null; // 현재 노드 바로 앞 노드

        while (node != null) {
            if (node.getKey().equals(key)) { // 찾으면
                if (pNode == null) {
                    table[hash] = node.next;
                } else {
                    pNode.next = node.next;
                }
                return 0; // 삭제 성공
            }
            pNode = node;
            node = node.next; // 다음 노드
        }
        return 1; // 존재하지 않는 키
    }

    // 해시 테이블의 덤프
    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K, V> node = table[i]; // 리스트의 첫번 째 노드
            System.out.printf("%02d ", i);
            while (node != null) {
                System.out.printf("-> %s (%s) ", node.getKey(), node.getValue());
                node = node.next;
            }
            System.out.println();
        }
    }
}