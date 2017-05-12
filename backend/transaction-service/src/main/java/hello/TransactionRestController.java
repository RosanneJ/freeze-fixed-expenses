package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
public class TransactionRestController {
    private final FreezeTransactionService service;

    @Autowired
    public TransactionRestController(final FreezeTransactionService service) {
        this.service = service;
    }

    @RequestMapping("/saldo")
    public List<Double> retrieveSaldo() {
        return Collections.singletonList(1405.26);
    }

    @RequestMapping("/transactions")
    @ResponseBody
    public List<Transaction> retrieveTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.builder()//
            .id(654564L)//
            .amount(-4.25)//
            .date(LocalDateTime.now())//
            .comment("Broodje")//
            .receiver("Brood & Co")//
            .receiverIban("NL55INGB03055869544")//
            .build());
        transactions.add(Transaction.builder()//
            .id(121212L)//
            .amount(-54.95)//
            .date(LocalDateTime.now())//
            .comment("Schoenen")//
            .receiver("Van Haren")//
            .receiverIban("NL12ABNA02016523223")//
            .build());
        transactions.add(Transaction.builder()//
            .id(121212L)//
            .amount(-39.12)//
            .date(LocalDateTime.of(2017, 4, 26, 12, 5))//
            .comment("Aanslagnummer:00000000000000040219846Gecomb aanslag 2017 Amsterdam Restbedrag eur 234,75")//
            .receiver("Gemeente Amsterdam Belastingen")//
            .receiverIban("NL85INGB0004585329")//
            .incassantId("NL89DBA343669660000")//
            .build());
        transactions.add(Transaction.builder()//
            .id(121212L)//
            .amount(-82.25)//
            .date(LocalDateTime.of(2017, 5, 18, 9, 0))//
            .comment("Besured-FACTNR 70343558 DEB 2095141674-Zorgverzekering-")//
            .receiver("CARESCO BV")//
            .receiverIban("NL50ABNA0479966524")//
            .incassantId("NL24ZZZ557727650000")//
            .build());
        return transactions;
    }

    @RequestMapping("/freeze-fixed-expenses")
    public void freezeFixedExpenses(@RequestParam Transaction transactionToFreeze) {
        if (transactionToFreeze.getIncassantId() == null) {
            throw new IllegalArgumentException();
        }
        service.addTransaction(transactionToFreeze);
    }
}
