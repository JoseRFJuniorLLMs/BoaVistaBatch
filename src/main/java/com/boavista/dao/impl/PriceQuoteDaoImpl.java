package com.boavista.dao.impl;

import com.boavista.dao.PriceQuoteDao;
import com.boavista.model.PriceQuote;
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
public class PriceQuoteDaoImpl extends JdbcDaoSupport implements PriceQuoteDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(List<? extends PriceQuote> priceQuotes) {

        String sql = "INSERT INTO pricequote " + "( id, tube_assembly_id, supplier, quote_date, annual_usage, min_order_quantity, bracket_pricing, quantity, cost) " +
                                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                PriceQuote priceQuote = priceQuotes.get(i);
                ps.setLong(1, priceQuote.getId());
                ps.setString(2, priceQuote.getTubeassemblyid());
                ps.setString(3, priceQuote.getSupplier());
                ps.setString(4, priceQuote.getQuotedate());
                ps.setString(5, priceQuote.getAnnualusage());
                ps.setString(6, priceQuote.getMinorderquantity());
                ps.setString(7, priceQuote.getBracketpricing());
                ps.setString(8, priceQuote.getQuantity());
                ps.setString(9, priceQuote.getCost());
            }
            public int getBatchSize() {
                return priceQuotes.size();
            }
        });

    }

    @Override
    public List<PriceQuote> loadAllPricesQuotes() {
        String sql = "SELECT * FROM pricequote";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<PriceQuote> result = new ArrayList<PriceQuote>();
        for (Map<String, Object> row : rows) {
            PriceQuote priceQuote = new PriceQuote();
            priceQuote.setId((Long) row.get("id"));
            priceQuote.setTubeassemblyid((String) row.get("tube_assembly_id"));
            priceQuote.setSupplier((String) row.get("supplier"));
            priceQuote.setQuotedate((String) row.get("quote_date"));
            priceQuote.setAnnualusage((String) row.get("annual_usage"));
            priceQuote.setMinorderquantity((String) row.get("min_order_quantity"));
            priceQuote.setBracketpricing((String) row.get("bracket_pricing"));
            priceQuote.setQuantity((String) row.get("quantity"));
            priceQuote.setCost((String) row.get("cost"));
            result.add(priceQuote);
        }
        return result;
    }
}
