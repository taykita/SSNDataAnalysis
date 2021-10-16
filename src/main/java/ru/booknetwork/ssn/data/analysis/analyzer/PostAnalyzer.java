package ru.booknetwork.ssn.data.analysis.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.booknetwork.ssn.data.analysis.Data;
import ru.booknetwork.ssn.data.analysis.database.DataRepository;

@Service
public class PostAnalyzer implements Analyzer {
    @Autowired
    public PostAnalyzer(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    private final DataRepository dataRepository;
    private final String analyzerName = "Post";

    public String getAnalyzerName() {
        return analyzerName;
    }

    @Override
    public void analysis(AnalysisDTO analysisDTO) throws Exception {
        System.out.println(analysisDTO.toString());

        //Data data = new Data(splitMessage[0], splitMessage[1], splitMessage[2] + "-" + splitMessage[3]);
        //dataRepository.addData(data);
    }
}
