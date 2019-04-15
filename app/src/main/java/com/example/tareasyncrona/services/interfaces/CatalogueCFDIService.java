package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.CatalogueCFDI;

import java.util.ArrayList;

public interface CatalogueCFDIService {
    ArrayList<CatalogueCFDI> fetch();

    void addList(ArrayList<CatalogueCFDI> catalogueCFDIS);
}
