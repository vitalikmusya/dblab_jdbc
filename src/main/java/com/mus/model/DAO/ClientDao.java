package com.mus.model.DAO;

public class ClientDao implements com.mus.model.DAO.interfaces.ClientDao {

    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Client");
        }
        return queryGenerator;
    }
}
