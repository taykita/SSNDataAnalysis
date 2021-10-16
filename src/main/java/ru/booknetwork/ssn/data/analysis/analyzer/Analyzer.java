package ru.booknetwork.ssn.data.analysis.analyzer;

public interface Analyzer {
    String getAnalyzerName();

    void analysis(AnalysisDTO analysisDTO) throws Exception;
}
