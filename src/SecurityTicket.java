public class SecurityTicket implements ITicket, ITicketCVE, ITicketSeverity{
    private int ticketId;
    private String description;
    private String resolution;
    private String cve;
    private Severity severity;

    public SecurityTicket(int ticketId, String description, String resolution, String cve, Severity severity) {
        this.ticketId = ticketId;
        this.description = description;
        this.resolution = resolution;
        this.cve = cve;
        this.severity = severity;
    }

    @Override
    public int getId() {
        return ticketId;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getResolution() {
        return resolution;
    }

    @Override
    public String getCVE() {
        return cve;
    }

    @Override
    public Severity getSeverity() {
        return severity;
    }
}
