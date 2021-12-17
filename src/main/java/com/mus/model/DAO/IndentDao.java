package com.mus.model.DAO;

public class IndentDao implements com.mus.model.DAO.interfaces.IndentDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Indent");
        }
        return queryGenerator;
    }
}
