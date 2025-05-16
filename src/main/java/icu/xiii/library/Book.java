package icu.xiii.library;

public class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        setTitle(title);
        setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title == null) {
            throw new IllegalArgumentException("title can't be null");
        } else if (title.isBlank()) {
            throw new IllegalArgumentException("title can't be blank");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalArgumentException {
        if (author == null) {
            throw new IllegalArgumentException("author can't be null");
        } else if (author.isBlank()) {
            throw new IllegalArgumentException("author can't be blank");
        }
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return getTitle().equals(book.getTitle()) && getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getAuthor().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
