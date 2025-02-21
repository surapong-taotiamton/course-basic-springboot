package blog.surapong.coursespringboot.controller.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class BookUpdateRequestDto {
    private String bookId;
    private String bookName;
    private Long noPage;
}
