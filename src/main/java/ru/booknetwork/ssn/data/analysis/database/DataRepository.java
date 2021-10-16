package ru.booknetwork.ssn.data.analysis.database;

import ru.booknetwork.ssn.data.analysis.Data;
import ru.booknetwork.ssn.data.analysis.controllers.StatisticDTO;

public interface DataRepository {
    Data addData(Data data) throws Exception;

    StatisticDTO getStatisticDTO() throws Exception;
}
