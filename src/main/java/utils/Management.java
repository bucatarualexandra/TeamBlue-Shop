package utils;

import java.util.List;

public interface Management<T> {
    void insert(T item);

    void delete(T item);

    void update(T item);

    T getById(Long id);

    List<T> getItems();

    void deleteById(Long id);
}
