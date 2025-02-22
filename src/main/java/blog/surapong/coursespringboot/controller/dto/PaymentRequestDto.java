package blog.surapong.coursespringboot.controller.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class PaymentRequestDto {
    private String sourceAccount;
    private String destinationAccount;
    private Long amount;
}
