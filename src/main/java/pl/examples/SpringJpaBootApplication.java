package pl.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.examples.dao.BookDao;
import pl.examples.model.Book;

@SpringBootApplication
public class SpringJpaBootApplication
{

    public static void main( String[] args ) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);

        BookDao bookDao = ctx.getBean(BookDao.class);
        Book book = new Book("123123223", "Fale i anteny", "Jarosław Szóstka");
        bookDao.save(book);
        System.out.println("Zapisano do bazy danych");
        Book bookFromDb = bookDao.get(1L);
        System.out.println(bookFromDb);

        //to see db open connections
        Thread.sleep(5000);
        ctx.close();

    }
}
