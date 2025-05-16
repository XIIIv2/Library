package icu.xiii.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LibraryTest {

    Library library;
    Book bookA;
    Book bookB;
    Book bookC;

    @Before
    public void setUp() {
        library = new Library();
        bookA = new Book("Book A", "John Doe");
        bookB = new Book("Book B", "Jane Doe");
        bookC = null;
    }

    @Test
    public void testAddBook() {
        library.addBook(bookA);
        List<Book> books = library.getBooks();
        Assert.assertTrue("Книга должна быть добавлена", books.contains(bookA));
    }

    @Test
    public void testAddNullableBook() {
        Assert.assertThrows("Добавление null книги должно приводить к ошибке",
                IllegalArgumentException.class,
                () -> library.addBook(bookC)
        );
    }

    @Test
    public void testRemoveBook() {
        library.addBook(bookA);
        library.addBook(bookB);
        boolean isDeleted = library.removeBook(bookB);
        List<Book> books = library.getBooks();
        Assert.assertTrue("Удаление книги должно быть успешным", isDeleted);
        Assert.assertFalse("Книга должна быть удалена", books.contains(bookB));
        Assert.assertTrue("Книга Book A не должна быть удалена", books.contains(bookA));
    }

    @Test
    public void testRemoveNonExistentBook() {
        boolean isDeleted = library.removeBook(bookA);
        Assert.assertFalse("Удаление книги не должно быть успешным", isDeleted);
    }

    @Test
    public void testGetBooks() {
        library.addBook(bookA);
        library.addBook(bookB);
        List<Book> books = library.getBooks();
        Assert.assertTrue("Список книг должен содержать Book A", books.contains(bookA));
        Assert.assertTrue("Список книг должен содержать Book B", books.contains(bookB));
    }

    @Test
    public void testGetBookCount() {
        library.addBook(bookA);
        library.addBook(bookB);
        Assert.assertEquals("В библиотеке должно быть 2 книги", 2, library.getBookCount());
    }
}