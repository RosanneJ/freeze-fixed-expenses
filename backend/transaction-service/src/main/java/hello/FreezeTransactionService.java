package hello;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FreezeTransactionService {
    private static Map<String, Transaction> frozenTransactions;

    public void addTransaction(final Transaction transaction) {
        if (frozenTransactions == null) {
            frozenTransactions = new HashMap();
        }
        frozenTransactions.put(transaction.getReceiverIban(), transaction);
    }
}
