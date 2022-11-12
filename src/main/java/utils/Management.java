package utils;

import java.util.List;

public interface Management<T> {
    void insert(T item);

    void delete(T item);

    void update(T item);

    T getById(int id);

    List<T> getItems();

    void deleteById(int id);
}
