package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Price;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface PriceService {
    ResponseDataWithCode<ArrayList<Price>> fetch();

    void addList(ArrayList<Price> prices);

    void addObject(Price price);
}
