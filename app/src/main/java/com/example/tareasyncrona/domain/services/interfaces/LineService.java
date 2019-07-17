package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Line;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface LineService {
    ResponseDataWithCode<ArrayList<Line>> fetch();

    void addList(ArrayList<Line> lines);

    void addObject(Line line);
}
