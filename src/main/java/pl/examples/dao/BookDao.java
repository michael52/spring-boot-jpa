package pl.examples.dao;

import pl.examples.model.Book;

public interface BookDao {

    void save(Book book);
    Book get(Long id);
    void update(Book book);
    void remove(Long bookId);

}
