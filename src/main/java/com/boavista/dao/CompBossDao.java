package com.boavista.dao;

import com.boavista.model.CompBoss;

import java.util.List;

public interface CompBossDao {
    public void insert(List<? extends CompBoss> compBosses);
    List<CompBoss> loadAllCompBosses();
}
