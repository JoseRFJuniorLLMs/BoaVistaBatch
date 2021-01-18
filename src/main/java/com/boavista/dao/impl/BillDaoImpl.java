package com.boavista.dao.impl;

import com.boavista.dao.BillDao;
import com.boavista.model.Bill;
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
public class BillDaoImpl extends JdbcDaoSupport implements BillDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(List<? extends Bill> bills) {

        String sql = "INSERT INTO bill " + "( id,tube_assembly_id, component_id_1, quantity_1, component_id_2, quantity_2, component_id_3, quantity_3, component_id_4, quantity_4, component_id_5, quantity_5, component_id_6, quantity_6, component_id_7, quantity_7, component_id_8, quantity_8 ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Bill bill = bills.get(i);
                ps.setLong(1, bill.getId());
                ps.setString(2, bill.getTubeassemblyid());
                ps.setString(3, bill.getComponentid1());
                ps.setString(4, bill.getQuantity1());
                ps.setString(5, bill.getComponentid2());
                ps.setString(6, bill.getQuantity2());
                ps.setString(7, bill.getComponentid3());
                ps.setString(8, bill.getQuantity3());
                ps.setString(9, bill.getComponentid4());
                ps.setString(10, bill.getQuantity4());
                ps.setString(11, bill.getComponentid5());
                ps.setString(12, bill.getQuantity5());
                ps.setString(13, bill.getComponentid6());
                ps.setString(14, bill.getQuantity6());
                ps.setString(15, bill.getComponentid7());
                ps.setString(16, bill.getQuantity7());
                ps.setString(17, bill.getComponentid8());
                ps.setString(18, bill.getQuantity8());

            }
            public int getBatchSize() {
                return bills.size();
            }
        });

    }

    @Override
    public List<Bill> loadAllBill() {
        String sql = "SELECT * FROM bill";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Bill> result = new ArrayList<Bill>();
        for (Map<String, Object> row : rows) {
            Bill bill = new Bill();
            bill.setId((Long) row.get("id"));
            bill.setTubeassemblyid((String) row.get("tube_assembly_id"));
            bill.setComponentid1((String) row.get("component_id_1"));
            bill.setQuantity1((String) row.get("quantity_1"));
            bill.setComponentid2((String) row.get("component_id_2"));
            bill.setQuantity2((String) row.get("quantity_2"));
            bill.setComponentid3((String) row.get("component_id_3"));
            bill.setQuantity3((String) row.get("quantity_3"));
            bill.setComponentid4((String) row.get("component_id_4"));
            bill.setQuantity4((String) row.get("quantity_4"));
            bill.setComponentid5((String) row.get("component_id_5"));
            bill.setComponentid5((String) row.get("quantity_5"));
            bill.setComponentid6((String) row.get("component_id_6"));
            bill.setQuantity6((String) row.get("quantity_6"));
            bill.setComponentid7((String) row.get("component_id_7"));
            bill.setQuantity7((String) row.get("quantity_7"));
            bill.setComponentid8((String) row.get("component_id_8"));
            bill.setQuantity8((String) row.get("quantity_8"));

            result.add(bill);
        }
        return result;
    }

}
