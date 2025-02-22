package blog.surapong.coursespringboot.controller;

import blog.surapong.coursespringboot.controller.dto.PaymentRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/payment")
    public String payment(@RequestBody PaymentRequestDto paymentRequestDto) {
        return null;
    }


}
