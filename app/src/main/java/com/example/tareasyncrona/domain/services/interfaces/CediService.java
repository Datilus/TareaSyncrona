package com.example.tareasyncrona.domain.services.interfaces;

import com.example.tareasyncrona.data.api.Cedi;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;

import java.util.ArrayList;

public interface CediService {
    ResponseDataWithCode<Cedi> fetch();

    void addList(ArrayList<Cedi> cedis);

    void addObject(Cedi cedi);
}
