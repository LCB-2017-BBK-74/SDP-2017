/**
 * Created by lucieburgess on 20/01/2017.
 */
class Storage<T> {
    T x;

    Storage() {
    }

    public void setValue(T value) {
        this.x = value;
    }

    public T getValue() {
        return this.x;
    }
}
