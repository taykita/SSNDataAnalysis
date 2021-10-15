package ru.booknetwork.SSNDataAnalysis.database;

import ru.booknetwork.SSNDataAnalysis.Data;

public interface DataRepository {
    Data addData(Data data) throws Exception;
}
