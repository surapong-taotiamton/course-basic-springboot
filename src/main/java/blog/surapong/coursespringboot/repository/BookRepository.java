package blog.surapong.coursespringboot.repository;

import blog.surapong.coursespringboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
