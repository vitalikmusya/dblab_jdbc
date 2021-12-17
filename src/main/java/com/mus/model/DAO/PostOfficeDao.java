package com.mus.model.DAO;

public class PostOfficeDao implements com.mus.model.DAO.interfaces.PostOfficeDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("PostOffice");
        }
        return queryGenerator;
    }
}
