package com.boavista.step;

import com.boavista.model.CompBoss;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorCompBoss implements ItemProcessor<CompBoss, CompBoss> {

    private static final Logger log = LoggerFactory.getLogger(CompBoss.class);

    @Override
    public CompBoss process(CompBoss compBoss) throws Exception {

        final Long id = compBoss.getId();
        final String componenttypeid = compBoss.getComponenttypeid();
        final String type = compBoss.getType();
        final String connectiontypeid = compBoss.getConnectiontypeid();
        final String outsideshape = compBoss.getOutsideshape();
        final String basetype = compBoss.getBasetype();
        final String heightovertube = compBoss.getHeightovertube();
        final String boltpatternlong = compBoss.getBoltpatternlong();
        final String boltpatternwide = compBoss.getBoltpatternwide();
        final String groove = compBoss.getGroove();
        final String basediameter = compBoss.getBasediameter();
        final String shoulderdiameter = compBoss.getShoulderdiameter();
        final String uniquefeature = compBoss.getUniquefeature();
        final String orientation = compBoss.getOrientation();
        final String weight = compBoss.getWeight();

        final CompBoss fixedCompBoss = new CompBoss(id, componenttypeid, type, connectiontypeid, outsideshape, basetype, heightovertube,
                boltpatternlong, boltpatternwide, groove, basediameter, shoulderdiameter, uniquefeature, orientation, weight );

        log.info("Converting (" + compBoss + ") into (" + fixedCompBoss + ")");

        return fixedCompBoss;
    }

}
