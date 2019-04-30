package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.Line;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface LineService {
    ResponseDataWithCode<ArrayList<Line>> fetch();

    void addList(ArrayList<Line> lines);
}
