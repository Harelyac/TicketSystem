import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class GeneralManager implements ITicketManager{
    /**
     * this class behave as singleton, where only one instance is being created when first being used and
     * later on just get same instance over and over
     */


    private static GeneralManager firstInstance = null;

    private static HashMap<Integer, ITicket> tickets = new HashMap<>();

    private static ArrayList<ITicketSeverity> analyzedTickets = new ArrayList<>();

    // declared private for instantiation only inside the class (from getInstance())
    private GeneralManager(){
    }

    public static GeneralManager getInstance(){
        if (firstInstance == null){
            firstInstance = new GeneralManager();
        }

        return firstInstance;
    }

    @Override
    public void addTicket(ITicket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    @Override
    public void removeTicket(ITicket ticket) {
        tickets.remove(ticket.getId());
    }

    @Override
    public ITicket getTicket(int id) {
        return tickets.get(id);
    }

    @Override
    public Collection<ITicket> getTickets() {
        return tickets.values();
    }
}
