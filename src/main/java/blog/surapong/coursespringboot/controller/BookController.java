package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.controller.dto.BookCreateRequestDto;
import blog.surapong.coursespringboot.controller.dto.BookUpdateRequestDto;
import blog.surapong.coursespringboot.entity.Book;
import blog.surapong.coursespringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> read(@PathVariable("id") String id) {
        Book book = bookService.get(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<Book> create(@RequestBody BookCreateRequestDto dto) {
        Book  book =  bookService.create(dto.getBookName(), dto.getNoPage());
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        bookService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/book")
    public ResponseEntity<Book> update(@RequestBody BookUpdateRequestDto dto) {

        Book book = new Book()
                .setBookId(dto.getBookId())
                .setBookName(dto.getBookName())
                .setNoPage(dto.getNoPage());

        Book afterUpdate = bookService.update(book);
        return new ResponseEntity<>(afterUpdate, HttpStatus.OK);
    }

}
