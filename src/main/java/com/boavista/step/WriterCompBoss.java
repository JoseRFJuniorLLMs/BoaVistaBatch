package com.boavista.step;

import com.boavista.dao.CompBossDao;
import com.boavista.model.CompBoss;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class WriterCompBoss implements ItemWriter<CompBoss> {

    private final CompBossDao compBossDao;

    public WriterCompBoss(CompBossDao compBossDao) {
        this.compBossDao = compBossDao;
    }

    @Override
    public void write(List<? extends CompBoss> compBosses) throws Exception {
        compBossDao.insert(compBosses);
    }
}
