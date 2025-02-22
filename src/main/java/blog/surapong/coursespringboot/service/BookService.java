package blog.surapong.coursespringboot.service;

import blog.surapong.coursespringboot.entity.Book;
import blog.surapong.coursespringboot.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Cacheable(value = "book", key = "#id")
    public Book get(String id) {
        log.info("################# In case cache miss at key : {}", id);
        return bookRepository.findById(id).orElseThrow();
    }


    @CachePut(value = "book", key = "#result.bookId")
    public Book create(String bookName, Long noPage) {
        Book book = new Book()
                .setBookId(UUID.randomUUID().toString())
                .setBookName(bookName)
                .setNoPage(noPage);
        return bookRepository.save(book);
    }

    @CachePut(value = "book", key = "#result.bookId")
    public Book update(Book book) {
        Book bookInDatabase = bookRepository.findById(book.getBookId()).orElseThrow();
        bookInDatabase
                .setBookName( book.getBookName() )
                .setNoPage(book.getNoPage());

        return bookRepository.save(bookInDatabase);
    }

    @CacheEvict(value = "book", key = "#id")
    public void delete(String id) {
        bookRepository.deleteById(id);
    }


}
