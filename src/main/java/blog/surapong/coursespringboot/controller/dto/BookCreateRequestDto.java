package blog.surapong.coursespringboot.controller.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class BookCreateRequestDto {
    private String bookName;
    private Long noPage;
}
