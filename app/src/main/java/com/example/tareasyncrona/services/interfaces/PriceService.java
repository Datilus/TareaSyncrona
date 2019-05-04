package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.Price;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface PriceService {
    ResponseDataWithCode<ArrayList<Price>> fetch();

    void addList(ArrayList<Price> prices);
}
