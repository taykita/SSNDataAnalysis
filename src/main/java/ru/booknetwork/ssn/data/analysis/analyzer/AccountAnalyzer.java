package ru.booknetwork.ssn.data.analysis.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.booknetwork.ssn.data.analysis.Data;
import ru.booknetwork.ssn.data.analysis.database.DataRepository;

@Service
public class AccountAnalyzer implements Analyzer {
    @Autowired
    public AccountAnalyzer(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    private final DataRepository dataRepository;
    private final String analyzerName = "Account";

    @Override
    public String getAnalyzerName() {
        return analyzerName;
    }

    @Override
    public void analysis(String message) throws Exception {
        String[] splitMessage = message.split("-");
        Data data = new Data(splitMessage[0], splitMessage[1], splitMessage[2] + "-" + splitMessage[3]);
        dataRepository.addData(data);
    }
}
