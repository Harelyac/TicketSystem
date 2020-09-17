public class BestPracticeTicket implements ITicket, ITicketCVE, ITicketSeverity {
    private int ticketId;
    private String description;
    private String resolution;
    private String cve;
    private Severity severity;

    public BestPracticeTicket(int ticketId, String description, String resolution, String cve, Severity severity) {
        this.ticketId = ticketId;
        this.description = description;
        this.resolution = resolution;
        this.cve = cve;
        this.severity = severity;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getResolution() {
        return null;
    }

    @Override
    public String getCVE() {
        return null;
    }

    @Override
    public Severity getSeverity() {
        return null;
    }
}
