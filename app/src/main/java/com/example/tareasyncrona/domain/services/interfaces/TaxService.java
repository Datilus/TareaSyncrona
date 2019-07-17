package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.Tax;

import java.util.ArrayList;

public interface TaxService {
    ResponseDataWithCode<ArrayList<Tax>> fetch();

    void addList(ArrayList<Tax> taxes);

    void addObject(Tax tax);
}
