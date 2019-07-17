package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Payment;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface PaymentService {
    ResponseDataWithCode<ArrayList<Payment>> fetch();

    void addList(ArrayList<Payment> payments);

    void addObject(Payment payment);
}
