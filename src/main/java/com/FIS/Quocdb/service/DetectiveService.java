package com.FIS.Quocdb.service;

import com.FIS.Quocdb.entities.Detective;

import java.util.Set;

public interface DetectiveService {
    Detective addDetective(Detective detective);

    Detective updateDetective(Detective detective);

    Set<Detective> getDetectives();

    Detective getDetective(Long id);

    void deleteDetective(Long id);

}
