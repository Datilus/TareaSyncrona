package com.example.tareasyncrona.services.interfaces;

import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.jsonModel.Route;

public interface RouteService {
    ResponseDataWithCode<Route> fetch();

    void addObject(Route route);
}
