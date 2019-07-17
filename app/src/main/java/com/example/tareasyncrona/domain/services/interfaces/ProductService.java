package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Product;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface ProductService {
    ResponseDataWithCode<ArrayList<Product>> fetch();

    void addList(ArrayList<Product> products);

    void addObject(Product product);
}
