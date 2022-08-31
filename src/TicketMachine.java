/**
 * Simula o comportamento de uma máquina de vender bilhetes
 */
public class TicketMachine {
    float price;
    float invoice; // Faturamento total
    float balance;

    public TicketMachine(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getInvoice() {
        return invoice;
    }

    public float getBalance() {
        return balance;
    }

    public void insertMoney(float amount) {
        if (amount > 0) {
            balance += amount;

            final int userCanPrint = (int) (balance / price);

            System.out.println(
                    "Inserido " + amount + "cédulas, Você pode imprimir " + userCanPrint + "tickets"
            );
        }
    }

    /**
     * Imprime uma quantidade fornecida de tickets,
     *
     * @param quantity Quantidade
     */
    public void printTicket(int quantity) {
        final int maxNumberOfTickets = (int) (balance / price);

        if (quantity <= maxNumberOfTickets) {
            final float total = quantity * price;

            invoice += total;
            balance -= total;

            if (balance > 0) {
                refund(balance);
            }

            print(quantity);
        }
    }

    public void print(int quantityOfTickets) {
        for (int i = 0; i < quantityOfTickets; i++) {
            System.out.println(i + ". Imprimindo ticket");
        }
    }

    public void refund(float balance) {
        System.out.println("Retornando seu troco: " + balance + " dinheiros");

        this.balance -= balance;

        if (balance == 0) System.out.println("Operação realizada com justiça");
        else System.out.println("Deu ruim");
    }
}
