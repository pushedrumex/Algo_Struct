package hash;

public class OpenHash<K, V> {
    // 버킷의 상태
    // 데이터저장, 비어있음, 삭제 마침
    enum Status {
        OCCUPIED, EMPTY, DELETED
    }

    // 버킷
    static class Bucket<K, V> {
        private K key; // 키
        private V value; // 깂
        private Status stat; // 상태

        // 생성자
        Bucket() {
            stat = Status.EMPTY; // 버킷 초기상태 : 비어있음
        }

        // 모든 필드에 값 설정
        void set(K key, V value, Status stat) {
            this.key = key; // 키
            this.value = value; // 데이터
            this.stat = stat; // 상태
        }

        void setStat(Status stat) {
            this.stat = stat;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        // key의 해시 값을 반환
        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size; // 해시 테이블 크기
    private Bucket<K, V>[] table; // 해시 테이블

    // 생성자
    public OpenHash(int size) {
        table = new Bucket[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Bucket<K,V>();
        }
        this.size = size;
    }

    // 해시함수
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // 재해시 함수
    public int rehashValue(int hash) {
        return (hash + 1) % size;
    }

    // 키 값을 key로 갖는 버킷 검색
    private Bucket<K, V> searchBucket(K key) {
        int hash = hashValue(key); // 검색할 데이터의 해시값
        Bucket<K, V> bucket = table[hash]; // 선택 버킷

        for (int i = 0; bucket.stat != Status.EMPTY && i < size; i++) {
            if (bucket.stat == Status.OCCUPIED && bucket.getKey().equals(key)) {
                return bucket; // 검색 성공
            }
            hash = rehashValue(hash); // 재해시
            bucket = table[hash];
        }
        return null; // 검색 실패
    }

    // 키에 해당하는 value 검색
    public V search(K key) {
        Bucket<K, V> bucket = searchBucket(key);
        if (bucket == null) {
            return null;
        }
        return bucket.getValue();
    }

    // key : value 추가
    public int add(K key, V value) {
        if (search(key) != null) {
            return 1; // 이미 존재하는 key
        }

        int hash = hashValue(key); // 추가할 key의 해시값
        Bucket<K, V> bucket = table[hash]; // 선택 버킷
        for (int i = 0; i < size; i++) {
            if (bucket.stat == Status.EMPTY || bucket.stat == Status.DELETED) {
                bucket.set(key, value, Status.OCCUPIED);
                return 0; // 추가 성공
            }
            hash = rehashValue(hash); // 재해시
            bucket = table[hash];
        }
        return 1; // 해시 테이블 가득 참
    }

    // key : value 삭제
    public int remove(K key) {
        Bucket<K, V> bucket = searchBucket(key); // 선택 버킷
        if (bucket == null) {
            return 1; // 존재하지 않는 key
        }

        bucket.setStat(Status.DELETED);
        return 0; // 삭제 완료
    }

    // 해시 테이블 덤프
    public void dump() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%02d", i);
            switch (table[i].stat) {
                case OCCUPIED:
                    System.out.printf("%s (%s)\n", table[i].getKey(), table[i].getValue());
                    break;
                case EMPTY:
                    System.out.println("-- 등록 --");
                    break;
                case DELETED:
                    System.out.println("-- 삭제 마침 --");
                    break;
            }
        }
    }
}
