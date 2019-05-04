package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.Product;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ProductService {
    ResponseDataWithCode<ArrayList<Product>> fetch();

    void addList(ArrayList<Product> products);
}
