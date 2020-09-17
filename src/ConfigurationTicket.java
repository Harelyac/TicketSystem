public class ConfigurationTicket implements ITicket, ITicketSeverity{
    private int ticketId;
    private String description;
    private String resolution;
    private Severity severity;

    public ConfigurationTicket(int ticketId, String description, String resolution, Severity severity) {
        this.ticketId = ticketId;
        this.description = description;
        this.resolution = resolution;
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
    public Severity getSeverity() {
        return null;
    }
}
