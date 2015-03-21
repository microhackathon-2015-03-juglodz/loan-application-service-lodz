package pl.loan.application.service.lodz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.loan.application.service.lodz.Consumer;

import java.math.BigDecimal;

@Service
public class MainService implements Consumer{

    @Autowired
    private Consumer dbService;
    @Autowired
    private Consumer fraudService;
    @Autowired
    private Consumer reportingService;

    @Override
    public void consume(BigDecimal amount, String msg) {
        dbService.consume(amount, msg);
        fraudService.consume(amount, msg);
        reportingService.consume(amount, msg);
    }
}
