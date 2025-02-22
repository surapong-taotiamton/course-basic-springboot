package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.controller.dto.TestReturnDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/test-api")
    public TestReturnDto testApi() {
        return new TestReturnDto()
                .setTitle("TITLE")
                .setDescription("JWT");
    }

}
