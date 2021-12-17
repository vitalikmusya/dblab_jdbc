package com.mus.model.DAO;

public class DeliveryDao implements com.mus.model.DAO.interfaces.DeliveryDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Delivery");
        }
        return queryGenerator;
    }
}
