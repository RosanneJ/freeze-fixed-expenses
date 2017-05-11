package hello;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Transaction {
    private long id;
    private double amount;
    private String comment;
    private String receiver;
    private String receiverIban;
    private LocalDateTime date;
    private String incassantId;
    private boolean frozen;
}
