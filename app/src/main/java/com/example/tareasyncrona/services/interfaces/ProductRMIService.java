package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.ProductRMI;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ProductRMIService {
    ResponseDataWithCode<ArrayList<ProductRMI>> fetch();

    void addList(ArrayList<ProductRMI> productRMIS);
}
