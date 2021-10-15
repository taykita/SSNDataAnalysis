package ru.booknetwork.SSNDataAnalysis.analyzer;

public interface Analyzer {
    String getAnalyzerName();

    void analysis(String message);
}
