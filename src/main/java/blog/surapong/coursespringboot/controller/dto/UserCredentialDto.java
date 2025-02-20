package blog.surapong.coursespringboot.controller.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserCredentialDto {

    private String username;
    private String password;
}
