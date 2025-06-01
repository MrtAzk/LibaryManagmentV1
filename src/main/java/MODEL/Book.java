package MODEL;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name",unique = true)
    private String bookName;

    @Column(name = "publication_year",nullable = true)
    private LocalDate publicationYear;

    @Column(name = "book_stock")
    private int stock;

    @ManyToOne()
    @JoinColumn(name = "author_id",referencedColumnName = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id",referencedColumnName = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<BookBorrowing> bookBorrowings;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories=new ArrayList<>();

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<BookBorrowing> getBookBorrowings() {
        return bookBorrowings;
    }


    public void setBookBorrowings(List<BookBorrowing> bookBorrowings) {
        this.bookBorrowings = bookBorrowings;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", publicationYear=" + publicationYear +
                ", stock=" + stock +
                ", author=" + author +
                ", publisher=" + publisher +
                ", categories=" + categories +
                '}';
    }
}
