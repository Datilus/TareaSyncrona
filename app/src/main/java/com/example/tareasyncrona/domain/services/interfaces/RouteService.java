package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.Route;

import java.util.ArrayList;

public interface RouteService {
    ResponseDataWithCode<Route> fetch();

    void addList(ArrayList<Route> routes);

    void addObject(Route route);
}
