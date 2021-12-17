package com.mus.model.DAO;

public class WorkerDao implements com.mus.model.DAO.interfaces.WorkerDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Worker");
        }
        return queryGenerator;
    }
}
