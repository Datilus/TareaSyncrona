package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Folio;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface FolioService {
    ResponseDataWithCode<ArrayList<Folio>> fetch();

    void addList(ArrayList<Folio> folios);

    void addObject(Folio folio);
}
