package ru.booknetwork.ssn.data.analysis.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.booknetwork.ssn.data.analysis.Data;
import ru.booknetwork.ssn.data.analysis.database.DataRepository;

import java.util.LinkedHashMap;

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

        LinkedHashMap analysisDTOData = (LinkedHashMap) analysisDTO.getData();

        Data data = new Data(analysisDTO.getName(), analysisDTO.getAction(),  analysisDTOData.get("id") + "=" + analysisDTOData.get("text"));
        dataRepository.addData(data);
    }
}
