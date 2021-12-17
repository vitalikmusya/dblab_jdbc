package com.mus.model.DAO;

public class ParcelDao implements com.mus.model.DAO.interfaces.ParcelDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Parcel");
        }
        return queryGenerator;
    }
}
