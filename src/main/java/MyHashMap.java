import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap <K,V> {
    private int size;
    private Node<K, V> firstNode;
    private Node<K, V> lastNode;
    private static class Node<K, V> {
        final int hashItem;
        private K key;
        private V value;
        private Node<K, V> nextNode;

        Node(int hash, K key, V value) {
            this.hashItem = hash;
            this.key = key;
            this.value = value;
            this.nextNode = null;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<K, V> nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "[key-" + key + ", value-" + value + "]";
        }


    }
    private void setNullFirstLastNodes(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    private Node<K, V> getNodeByKey(K key){
        Node<K, V> node = firstNode;
        while (node!=null){
            if(node.key.equals(key)){
                return node;
            }
            node = node.getNextNode();
        }
        return node;
    }
    private Node<K, V> getNodeByNext(Node<K, V> searchNode){
        if (searchNode==null){
            return null;
        }
        Node<K, V> node = firstNode;
        while (node!=null){

            if (node.getNextNode()==null){
                return null;
            }

            if(node.getNextNode().equals(searchNode)){
                return node;
            }
            node = node.getNextNode();
        }
        return node;
    }
    public void put(K key, V value) {
        if (get(key) == null) {
            int hash = key.hashCode();
            Node<K, V> node = new Node<>(hash, key, value);

            if (size == 0) {
                firstNode = node;
            } else {
                lastNode.setNextNode(node);
            }
            lastNode = node;

            size++;
        }
    }
    public void remove(K key) {
        if (size == 0){
            return;
        }

        if (size==1){
            setNullFirstLastNodes();
            return;
        }

        Node<K, V> findNode = getNodeByKey(key);
        if (findNode == null){
            return;
        }

        Node<K, V> prevNode = getNodeByNext(findNode);

        if (prevNode==null){
            firstNode = findNode.getNextNode();
        } else if (findNode.getNextNode()==null){
            prevNode.setNextNode(null);
            lastNode = prevNode;
        } else {
            prevNode.setNextNode(findNode.getNextNode());
        }

        size--;
    }
    public void clear() {
        if (size==0){
            return;
        }

        Node<K, V> currentNode = firstNode;

        while (currentNode!=null){

            currentNode.setKey(null);
            currentNode.setValue(null);
            currentNode = currentNode.getNextNode();
        }

        setNullFirstLastNodes();
    }

    public int size() {
        return size;
    }
    public V get(K key) {
        Node<K, V> node = getNodeByKey(key);
        if (node == null) {
            return null;
        }
        return node.getValue();
    }
    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        StringJoiner res = new StringJoiner(",");
        res.add(firstNode.toString());

        Node<K, V> node = firstNode.getNextNode();
        while (node != null) {
            res.add(node.toString());
            node = node.getNextNode();
        }
        return "{" + res + "}";
    }
}