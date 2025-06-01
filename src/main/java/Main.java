public class Main {
    import MODEL.Author;
import MODEL.Book;
import MODEL.Category;
import MODEL.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

    public class Main {
        public static void main(String[] args) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LibaryManagment");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();



            entityTransaction.begin();

            Author author= new Author();
            author.setAuthorName("Halit Ziya Uşaklıgil");
            author.setAuthorCountry("Türkiye");
            author.setBirthDate(LocalDate.of(1867,1,1));
            entityManager.persist(author);

            Publisher publisher = new Publisher();
            publisher.setPublisherName("Can Yayın evi");
            publisher.setEstablishmentYear(LocalDate.of(1923,1,1));
            publisher.setAddress("Ankara/Kızılay");
            entityManager.persist(publisher);

            Category category = new Category();
            category.setCategoryName("Dram");
            category.setCategoryDescription("Anadolu Dram");
            entityManager.persist(category);

            Book book =new Book() ;
            book.setBookName("Aşk-ı Memnu");
            book.setPublicationYear(LocalDate.of(1900,1,1));
            book.setStock(20);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.getCategories().add(category);
            entityManager.persist(book);











            entityTransaction.commit();
        }
    }

}
