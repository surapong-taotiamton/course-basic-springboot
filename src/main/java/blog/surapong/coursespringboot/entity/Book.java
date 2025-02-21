package blog.surapong.coursespringboot.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
public class Book {

    @Id
    private String bookId;

    private String bookName;

    private Long noPage;

}
