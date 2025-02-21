package blog.surapong.coursespringboot.service;

import blog.surapong.coursespringboot.entity.Book;
import blog.surapong.coursespringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book get(String id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public Book create(String bookName, Long noPage) {
        Book book = new Book()
                .setBookId(UUID.randomUUID().toString())
                .setBookName(bookName)
                .setNoPage(noPage);
        return bookRepository.save(book);
    }

    public Book update(Book book) {
        Book bookInDatabase = bookRepository.findById(book.getBookId()).orElseThrow();
        bookInDatabase
                .setBookName( book.getBookName() )
                .setNoPage(book.getNoPage());

        return bookRepository.save(bookInDatabase);
    }

    public void delete(String id) {
        bookRepository.deleteById(id);
    }


}
