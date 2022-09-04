import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * Simula o comportamento de uma máquina de vender bilhetes
 */
public class TicketMachine {
    float price;
    float invoice; // Faturamento total
    float balance;

    HashMap<Float, Float> coinTypes;

    public TicketMachine(float price) {
        this.price = price;

        coinTypes = new HashMap<Float, Float>();

        coinTypes.put(0.5f, 0.5f);
        coinTypes.put(0.25f, 0.25f);
        coinTypes.put(0.10f, 0.10f);
        coinTypes.put(0.05f, 0.05f);
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
                    "Inserido " + amount + " cédulas, Você pode imprimir " + userCanPrint + " tickets"
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

    private void print(int quantityOfTickets) {
        for (int i = 0; i < quantityOfTickets; i++) {
            System.out.println(i + 1 + ". Imprimindo ticket");
        }
    }

    private void reduceBalance(float balance) {
        System.out.println("Troco total de: R$" + balance);

        float remainingBalance = balance;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");


        for (float coin : coinTypes.values()) {
            if (remainingBalance >= coin) remainingBalance -= coin;

            System.out.printf("Retornando moedas de troco: R$" + coin + "\n");
        }
    }

    private void refund(float balance) {
        reduceBalance(balance);
        this.balance -= balance;

        if (this.balance == 0) System.out.println("Operação realizada com justiça");
        else System.out.println("Deu ruim");
    }
}

