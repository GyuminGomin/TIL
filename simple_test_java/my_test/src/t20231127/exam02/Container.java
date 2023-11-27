package simple_test_java.my_test.src.t20231127.exam02;

public class Container<T, S> {
	
    private T key;
    private S value;

    public T getKey() {
        return key;
    }
    public S getValue() {
        return value;
    }
    public void set(T key, S value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "Container [key=" + key + ", value=" + value + "]";
    }

    
}

