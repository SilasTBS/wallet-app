package com.wallet.tracker;

import java.util.ArrayList;
import java.util.List;

public class TransactionStore {

    public static final List<String> transactions = new ArrayList<>();

    public static void add(String transaction) {
        transactions.add(0, transaction);
    }
}