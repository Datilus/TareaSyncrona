package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.ProductRMI;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface ProductRMIService {
    ResponseDataWithCode<ArrayList<ProductRMI>> fetch();

    void addList(ArrayList<ProductRMI> productRMIS);

    void addObject(ProductRMI productRMI);
}
