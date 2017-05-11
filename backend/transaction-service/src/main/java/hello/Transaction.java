package hello;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Transaction {
    private long id;
    private BigDecimal amount;
    private String receiver;
    private String receiverIban;
    private LocalDate date;
    private String incassantId;
}
