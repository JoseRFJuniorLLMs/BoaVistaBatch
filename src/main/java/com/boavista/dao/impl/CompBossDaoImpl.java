package com.boavista.dao.impl;

import com.boavista.dao.CompBossDao;
import com.boavista.model.CompBoss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CompBossDaoImpl extends JdbcDaoSupport implements CompBossDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(List<? extends CompBoss> compBosses) {

        String sql = "INSERT INTO compboss " + "( id, component_id, component_type_id, type, connection_type_id, outside_shape, base_type, height_over_tube, " +
                "bolt_pattern_long, bolt_pattern_wide, groove, base_diameter, shoulder_diameter, unique_feature, orientation, weight) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                CompBoss compBoss = compBosses.get(i);
                ps.setLong(1, compBoss.getId());
                ps.setString(2, compBoss.getComponentid());
                ps.setString(3, compBoss.getComponenttypeid());
                ps.setString(4, compBoss.getType());
                ps.setString(5, compBoss.getConnectiontypeid());
                ps.setString(6, compBoss.getOutsideshape());
                ps.setString(7, compBoss.getBasetype());
                ps.setString(8, compBoss.getHeightovertube());
                ps.setString(9, compBoss.getBoltpatternlong());
                ps.setString(10, compBoss.getBoltpatternwide());
                ps.setString(11, compBoss.getGroove());
                ps.setString(12, compBoss.getBasediameter());
                ps.setString(13, compBoss.getShoulderdiameter());
                ps.setString(14, compBoss.getUniquefeature());
                ps.setString(15, compBoss.getOrientation());
                ps.setString(16, compBoss.getWeight());

            }
            public int getBatchSize() {
                return compBosses.size();
            }
        });

    }

    @Override
    public List<CompBoss> loadAllCompBosses() {
        String sql = "SELECT * FROM compboss";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<CompBoss> result = new ArrayList<CompBoss>();
        for (Map<String, Object> row : rows) {
            CompBoss compBoss = new CompBoss();
            compBoss.setId((Long) row.get("id"));
            compBoss.setComponenttypeid((String) row.get("component_type_id"));
            compBoss.setConnectiontypeid((String) row.get("connection_type_id"));
            compBoss.setOutsideshape((String) row.get("outside_shape"));
            compBoss.setBasetype((String) row.get("base_type"));
            compBoss.setHeightovertube((String) row.get("height_over_tube"));
            compBoss.setBoltpatternlong((String) row.get("bolt_pattern_long"));
            compBoss.setBoltpatternwide((String) row.get("bolt_pattern_wide"));
            compBoss.setGroove((String) row.get("groove"));
            compBoss.setBasediameter((String) row.get("base_diameter"));
            compBoss.setShoulderdiameter((String) row.get("shoulder_diameter"));
            compBoss.setUniquefeature((String) row.get("unique_feature"));
            compBoss.setOrientation((String) row.get("orientation"));
            compBoss.setWeight((String) row.get("weight"));
            result.add(compBoss);
        }
        return result;
    }
}
