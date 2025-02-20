package blog.surapong.coursespringboot.controller.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class TestReturnDto {

    private String title;
    private String description;

}
