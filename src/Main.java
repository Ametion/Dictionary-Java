import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary<Integer, String>();

        dictionary.Add(1, "FIRST VALUE");
        dictionary.Add(13, "sfsefse VALUE");
        dictionary.Add(13, "sfsefse VALUE");
        dictionary.Add(343, "ANOTHER VALUE");

        System.out.println(dictionary.GetValue(343));

        dictionary.Remove(343);
    }
}

class Dictionary<K, V>{
    private List<Node<K, V>> list = new ArrayList();

    public void Add(K key, V value){
        for (Node n: list){
            if(n.key.equals(key)){
                return;
            }
        }

        var node = new Node<K, V>(key, value);
        list.add(node);
    }

    public void Remove(K key){
        for (Node n: list){
            if(n.key.equals(key)){
                list.remove(n);
                return;
            }
        }
    }

    public V GetValue(K key){
        for (Node n: list){
            if(n.key.equals(key)){
                return (V) n.value;
            }
        }
        throw new NullPointerException("there is no value with this key");
    }
}

class Node<K, V>{
    public K key;
    public V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}