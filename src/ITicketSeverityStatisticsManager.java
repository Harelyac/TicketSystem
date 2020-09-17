public interface ITicketSeverityStatisticsManager {
    void addTicketForAnalyzing(ITicketSeverity ticket);
    String calcStatistics();
    String calcCVEStatistics();
}
