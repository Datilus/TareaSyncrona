package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.CatalogueCFDI;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;

import java.util.ArrayList;

public interface CatalogueCFDIService {
    ResponseDataWithCode<ArrayList<CatalogueCFDI>> fetch();

    void addList(ArrayList<CatalogueCFDI> catalogueCFDIS);
}
