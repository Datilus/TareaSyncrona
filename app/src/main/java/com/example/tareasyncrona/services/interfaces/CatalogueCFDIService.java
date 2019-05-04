package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.CatalogueCFDI;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface CatalogueCFDIService {
    ResponseDataWithCode<ArrayList<CatalogueCFDI>> fetch();

    void addList(ArrayList<CatalogueCFDI> catalogueCFDIS);
}
