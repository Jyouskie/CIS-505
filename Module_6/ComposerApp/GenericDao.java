package Module_6.ComposerApp;

import java.util.List;

// A tiny generic DAO contract for a single entity/table
public interface GenericDao <T, K> {
    List<T> findAll();   // return all records
    T findBy(K id);      // return a single record by key
    void insert(T item); // insert a new record
}