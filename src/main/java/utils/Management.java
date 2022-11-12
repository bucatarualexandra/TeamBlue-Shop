package utils;


public interface Management<T> {
    void insert(T item);

    void delete(T item);

    void get();

    void update(T item);
}
