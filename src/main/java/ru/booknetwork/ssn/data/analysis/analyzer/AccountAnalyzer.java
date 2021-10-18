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
    public void analysis(AnalysisDTO analysisDTO) throws Exception {
        Data data = new Data(analysisDTO.getName(), analysisDTO.getAction(), (String) analysisDTO.getData());
        dataRepository.addData(data);
    }
}
