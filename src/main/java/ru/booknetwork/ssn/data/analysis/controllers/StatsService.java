package ru.booknetwork.ssn.data.analysis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.booknetwork.ssn.data.analysis.database.DataRepository;

@Service
public class StatsService {
    @Autowired
    public StatsService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    private final DataRepository dataRepository;

    public StatisticDTO getStatisticDTO() throws Exception {
        return dataRepository.getStatisticDTO();
    }

}
