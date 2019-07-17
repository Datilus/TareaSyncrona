package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.FormVisit;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface FormVisitService {
    ResponseDataWithCode<ArrayList<FormVisit>> fetch();

    void addList(ArrayList<FormVisit> formVisits);

    void addObject(FormVisit formVisit);
}
