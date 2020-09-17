public class Main {
    public static void main(String [] args){

        // get manager instance
        GeneralManager generalManager = GeneralManager.getInstance();

        BestPracticeTicket bpt1 = new BestPracticeTicket(1, "bpt1", "new install", "mongo", ITicketSeverity.Severity.ERROR);
        BestPracticeTicket bpt2 = new BestPracticeTicket(2, "bpt1", "reboot", "mongo", ITicketSeverity.Severity.ERROR);

        SecurityTicket st1 = new SecurityTicket(3, "st1", "new install", "mongo", ITicketSeverity.Severity.ERROR);
        SecurityTicket st2 = new SecurityTicket(4, "st2", "reboot", "postgres", ITicketSeverity.Severity.ERROR);
        SecurityTicket st3 = new SecurityTicket(5, "st3", "storage usage", "postgres", ITicketSeverity.Severity.WARNING);

        ConfigurationTicket ct1 = new ConfigurationTicket(6, "ct1", "new install", ITicketSeverity.Severity.ERROR);
        ConfigurationTicket ct2 = new ConfigurationTicket(7, "ct2", "reboot", ITicketSeverity.Severity.ERROR);
        ConfigurationTicket ct3 = new ConfigurationTicket(8, "ct3", "disk failure",  ITicketSeverity.Severity.WARNING);
        ConfigurationTicket ct4 = new ConfigurationTicket(9, "ct4", "service down", ITicketSeverity.Severity.INFORMATION);

        generalManager.addTicket(bpt1);
        generalManager.addTicket(bpt2);
        generalManager.addTicket(st1);
        generalManager.addTicket(st2);
        generalManager.addTicket(st3);
        generalManager.addTicket(ct1);
        generalManager.addTicket(ct2);
        generalManager.addTicket(ct3);
        generalManager.addTicket(ct4);


        // check if tickets has been entered to system by the one and only manager
        System.out.println(generalManager.getTickets().size());

        System.out.println("\n");

        // get ticket number 1
        System.out.println(generalManager.getTicket(1));

        System.out.println("\n");

        // remote ticket number 2
        generalManager.removeTicket(generalManager.getTicket(2));

        // try to get 2 expect null
        System.out.println(generalManager.getTicket(2));

        // let's create statistical manager to get our stats straight
        StatisticManager sm = new StatisticManager();

        // let's add them all
        sm.addTicketForAnalyzing(bpt1);
        sm.addTicketForAnalyzing(bpt2);
        sm.addTicketForAnalyzing(st1);
        sm.addTicketForAnalyzing(st2);
        sm.addTicketForAnalyzing(st3);
        sm.addTicketForAnalyzing(ct1);
        sm.addTicketForAnalyzing(ct2);
        sm.addTicketForAnalyzing(ct3);
        sm.addTicketForAnalyzing(ct4);

        System.out.println("stats start here!!!!");

        System.out.println(sm.calcStatistics());

        System.out.println("\n\n\n");

        System.out.println(sm.calcCVEStatistics());
    }
}
