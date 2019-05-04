package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.Payment;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface PaymentService {
    ResponseDataWithCode<ArrayList<Payment>> fetch();

    void addList(ArrayList<Payment> payments);
}
