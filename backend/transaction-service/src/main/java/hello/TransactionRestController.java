package hello;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionRestController {

    @RequestMapping("/transactions")
    @ResponseBody
    public List<Transaction> retrieveTransactions(@RequestParam(value = "name", defaultValue = "World") String name) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.builder()//
            .id(654564L)//
            .amount(new BigDecimal(4.25))//
            .date(LocalDate.now())//
            .incassantId("98753")//
            .build());
        return transactions;
    }
}
