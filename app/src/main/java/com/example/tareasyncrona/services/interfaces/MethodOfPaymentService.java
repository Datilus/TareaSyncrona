package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.MethodOfPayment;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface MethodOfPaymentService {
    ResponseDataWithCode<ArrayList<MethodOfPayment>> fetch();

    void addList(ArrayList<MethodOfPayment> methodOfPayments);
}
