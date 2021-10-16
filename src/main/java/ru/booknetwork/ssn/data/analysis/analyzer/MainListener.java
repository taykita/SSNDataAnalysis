package ru.booknetwork.ssn.data.analysis.analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainListener {
    @Autowired
    public MainListener(PostAnalyzer postAnalyzer, AccountAnalyzer accountAnalyzer, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        analyzerList.add(postAnalyzer);
        analyzerList.add(accountAnalyzer);
    }
    private final ObjectMapper objectMapper;
    private final List<Analyzer> analyzerList = new ArrayList<>();

    @KafkaListener(topics = "booknetwork-events", groupId = "booknetwork-consumer-group")
    public void listenMessage(String message) throws Exception {

        AnalysisDTO analysisDTO = objectMapper.readValue(message, AnalysisDTO.class);

        for (Analyzer analyzer: analyzerList) {
            if (analyzer.getAnalyzerName().equals(analysisDTO.getName())) {
                analyzer.analysis(analysisDTO);
                break;
            }
        }
    }

}
