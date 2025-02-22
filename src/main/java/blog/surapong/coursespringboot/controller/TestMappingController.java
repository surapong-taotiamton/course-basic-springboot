package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.controller.dto.TestReturnDto;
import blog.surapong.coursespringboot.controller.dto.UserCredentialDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TestMappingController {

    public TestMappingController() {
        log.info("############# In constructor : TestMappingController");
    }


    @GetMapping("/test-mapping/request-param")
    public void getRequestParam(@RequestParam("fname") String firstname ) {
        log.info("Request from param is : {}", firstname);
    }

    @GetMapping("/test-mapping/path-variable/{id}")
    public void getPathVariable(@PathVariable("id") String id ) {
        log.info("path variable is : {}", id);
    }

    @PostMapping("/test-mapping/form-submit")
    public void testFormSubmit(@ModelAttribute UserCredentialDto data) {
        log.info("form-submit username : {}  password : {}", data.getUsername(), data.getPassword());
    }

    @PostMapping("/test-mapping/test-json")
    public void getJson(@RequestBody UserCredentialDto data) {
        log.info("test-json username : {}  password : {}", data.getUsername(), data.getPassword());
    }

    @PostMapping("/test-mapping/header")
    public void getDataFromHeader(
            @RequestHeader("value-in-header") String valueInHeader
    ) {
        log.info("value-in-header : {}", valueInHeader);
    }

    @PostMapping("/test-mapping/combo")
    public void combo(
            @RequestBody UserCredentialDto userCredentialDto,
            @RequestHeader("header-data") String headerData,
            @RequestParam("param") String param
    ) {

        log.info("json : {}", userCredentialDto);
        log.info("header : {}", headerData);
        log.info("param : {}", param);
    }

    @PostMapping("/test-mapping/return-json")
    public TestReturnDto testReturnJson(@RequestParam("title") String title) {
        return new TestReturnDto()
                .setTitle(title)
                .setDescription("TEST DESCRIPTION");
    }


}
