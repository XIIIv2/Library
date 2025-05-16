package icu.xiii.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) throws IllegalArgumentException {
        if (book == null) {
            throw new IllegalArgumentException("book can't be null");
        }
        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public int getBookCount() {
        return books.size();
    }
}
