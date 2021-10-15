package ru.booknetwork.SSNDataAnalysis.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainListener {
    @Autowired
    public MainListener(Analyzer postAnalyzer) {
        analyzerList.add(postAnalyzer);
    }

    private final List<Analyzer> analyzerList = new ArrayList<>();

    private boolean equalsMessage(String analyzerName, String kafkaMessage) {
        for (int i = 0; i < analyzerName.length(); i++) {
            if (analyzerName.charAt(i) != kafkaMessage.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @KafkaListener(topics = "booknetwork-events", groupId = "booknetwork-consumer-group")
    public void listenMessage(String message) throws Exception {
        for (Analyzer analyzer: analyzerList) {
            if (equalsMessage(analyzer.getAnalyzerName(), message)) {
                analyzer.analysis(message);
                break;
            }
        }
    }

}
