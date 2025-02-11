package by.itacademy.jd2;

import by.itacademy.jd2.entity.Author;
import by.itacademy.jd2.entity.Book;
import by.itacademy.jd2.entity.Reader;
import by.itacademy.jd2.service.AuthorService;
import by.itacademy.jd2.service.BookService;
import by.itacademy.jd2.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("app")
@RequiredArgsConstructor
public class App 
{
    private final AuthorService authorService;
    private final BookService bookService;
    private final ReaderService readerService;

    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        App app = (App) context.getBean("app");

        Author author = Author.builder()
                .name("Джоан Роулинг")
                .birthDate(LocalDate.now())
                .nationality("британка")
                .build();

        app.authorService.save(author);
        List<Author> authors = app.authorService.findByNationality("британка");
        authors.forEach(System.out::println);

        Book book = Book.builder()
                .title("Гарри Поттер и Узник Азкабана")
                .isbn("1234567890")
                .publishedDate(LocalDate.now())
                .build();

        author.getBooks().add(book);
        book.setAuthor(author);

        if (app.bookService.save(book) == null) {
            System.out.println("Сохранить не удалось, книга с таким ISBN уже присутствует!");
        }
        List<Book> books = app.bookService.findByTitleContaining("Поттер");
        books.forEach(System.out::println);

        Reader reader = Reader.builder()
                .name("Роман")
                .email("roman@gulyako.by")
                .registrationDate(LocalDate.now())
                .build();

        book.getReaders().add(reader);
        reader.getBooks().add(book);

        if (app.readerService.register(reader) == null) {
            System.out.println("Читатель с таким email уже зарегистрирован");
        }

        Reader foundReader = app.readerService.findByEmail("roman@gulyako.by");
        System.out.println(foundReader);

        List<Reader> readersByAuthor = app.readerService.findByAuthor("Джоан Роулинг");
        readersByAuthor.forEach(System.out::println);

        Page<Reader> registeredReaders = app.readerService.findSortedByRegistrationDate(PageRequest.of(0,3));
        registeredReaders.getContent().forEach(System.out::println);
    }
}
