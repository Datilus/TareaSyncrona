package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.jsonModel.Route;

public interface RouteService {
    ResponseDataWithCode<Route> fetch();

    void addObject(Route route);
}
