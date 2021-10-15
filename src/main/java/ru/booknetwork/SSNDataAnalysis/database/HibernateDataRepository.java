package ru.booknetwork.SSNDataAnalysis.database;

import org.springframework.stereotype.Repository;
import ru.booknetwork.SSNDataAnalysis.Data;

@Repository
public class HibernateDataRepository implements DataRepository {
    @Override
    public Data addData(Data data) {
        return null;
    }
}
