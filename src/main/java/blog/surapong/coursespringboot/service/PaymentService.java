package blog.surapong.coursespringboot.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentService {
    private String serverPaymentEndpoint;

    // Another config
    public boolean payment(String sourceAccount, String destinationAccount, Long amount) {
        log.info("sourceAccount : {}", sourceAccount);
        log.info("destinationAccount : {}", destinationAccount );
        log.info("amount : {}", amount);
        log.info("serverPaymentEndpoint : {}", serverPaymentEndpoint);
        return true;
    }

}
