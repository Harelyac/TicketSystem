import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class StatisticManager implements ITicketSeverityStatisticsManager{

    private HashMap<String, Integer> stats = new HashMap<>();
    private ArrayList<ITicket> ticketBuckets = new ArrayList<>();

    @Override
    public void addTicketForAnalyzing(ITicketSeverity ticket) {
        stats.put(ticket.getSeverity().toString(), stats.getOrDefault(ticket.getSeverity().toString(), 0) + 1);
        if (ticket instanceof BestPracticeTicket || ticket instanceof SecurityTicket){
            stats.put(((ITicketCVE)ticket).getCVE() ,stats.getOrDefault(((ITicketCVE)ticket).getCVE(), 0) + 1);
        }

    }

    @Override
    public String calcStatistics() {
        return stats.entrySet().stream()
                .filter(e -> e.getKey().equals(ITicketSeverity.Severity.ERROR.toString()) ||
                        e.getKey().equals(ITicketSeverity.Severity.INFORMATION.toString()) ||
                        e.getKey().equals(ITicketSeverity.Severity.WARNING.toString()))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    @Override
    public String calcCVEStatistics() {
        return stats.entrySet().stream()
                .filter(e -> !e.getKey().equals(ITicketSeverity.Severity.ERROR.toString()) &&
                        !e.getKey().equals(ITicketSeverity.Severity.INFORMATION.toString()) &&
                        !e.getKey().equals(ITicketSeverity.Severity.WARNING.toString()))
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
