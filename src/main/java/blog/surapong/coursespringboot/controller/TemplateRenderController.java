package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.controller.dto.TestRenderRequestDto;
import blog.surapong.coursespringboot.controller.dto.UserCredentialDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Slf4j
@Controller
public class TemplateRenderController {

        public TemplateRenderController() {
                log.info("######### In constructor : TemplateRenderController");
        }

        @PostMapping("/test-render")
        public String testRender(@ModelAttribute TestRenderRequestDto requestDto, Model model) {
                model.addAttribute("title", requestDto.getTitle());
                model.addAttribute("currentDateTime", "Current date time : " + new Date());
                return "my-template";
        }

}
