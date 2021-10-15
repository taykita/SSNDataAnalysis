package ru.booknetwork.SSNDataAnalysis.analyzer;

import org.springframework.stereotype.Service;

@Service
public class PostAnalyzer implements Analyzer {
    private final String analyzerName = "Post";

    public String getAnalyzerName() {
        return analyzerName;
    }

    @Override
    public void analysis(String message) {
        String[] data = message.split("-");

    }
}
