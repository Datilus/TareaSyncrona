package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.MethodOfPayment;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface MethodOfPaymentService {
    ResponseDataWithCode<ArrayList<MethodOfPayment>> fetch();

    void addList(ArrayList<MethodOfPayment> methodOfPayments);

    void addObject(MethodOfPayment methodOfPayment);
}
