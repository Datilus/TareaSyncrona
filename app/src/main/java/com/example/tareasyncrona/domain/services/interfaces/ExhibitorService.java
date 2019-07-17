package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Exhibitor;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface ExhibitorService {
    ResponseDataWithCode<ArrayList<Exhibitor>> fetch();

    void addList(ArrayList<Exhibitor> exhibitors);

    void addObject(Exhibitor exhibitor);
}
