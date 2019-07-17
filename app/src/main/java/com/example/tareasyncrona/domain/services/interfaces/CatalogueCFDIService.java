package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.CatalogueCFDI;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface CatalogueCFDIService {
    ResponseDataWithCode<ArrayList<CatalogueCFDI>> fetch();

    void addList(ArrayList<CatalogueCFDI> catalogueCFDIS);

    void addObject(CatalogueCFDI catalogueCFDI);
}
