package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Product;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface ProductService {
    ResponseDataWithCode<ArrayList<Product>> fetch();

    void addList(ArrayList<Product> products);
}
