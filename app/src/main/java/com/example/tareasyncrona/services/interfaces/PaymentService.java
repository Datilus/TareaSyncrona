package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Payment;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface PaymentService {
    ResponseDataWithCode<ArrayList<Payment>> fetch();

    void addList(ArrayList<Payment> payments);
}
