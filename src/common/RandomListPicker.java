package common;
import java.util.List;

public class RandomListPicker <T> {

    private List<T> list;

    public RandomListPicker(List<T> list) {
        this.list = list;
    }

    public T pick() {
        if (list.isEmpty()) {
            throw new IllegalStateException("items all used");
        }
        int index = (int) (Math.random() * list.size());
        T result = list.remove(index);
        return result;
    }
}
