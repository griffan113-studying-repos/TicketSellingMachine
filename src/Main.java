public class Main {
    public static void main(String[] args) {
        final TicketMachine ticketMachine = new TicketMachine(1);

        ticketMachine.insertMoney(2);
        ticketMachine.insertMoney(2);
        ticketMachine.insertMoney(2);

        ticketMachine.printTicket(5);
    }
}