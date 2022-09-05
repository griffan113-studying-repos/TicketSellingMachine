/**
 * Simula o comportamento de uma máquina de vender bilhetes
 */
public class TicketMachine {
    float price;
    float invoice; // Faturamento total
    float balance;

    float[] coinTypes;

    public TicketMachine(float price) {
        this.price = price;
        coinTypes = new float[]{1f, 0.5f, 0.25f, 0.10f, 0.05f};
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

            print(quantity);

            if (balance > 0) {
                refund(balance);
            }
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
        int index = 0;

        while(remainingBalance > 0) {
            float coin = coinTypes[index];

            if (remainingBalance >= coin) {
                remainingBalance -= coin;
                System.out.println("Retornando moeda de: R$" + coin);
            } else {
                index ++;
            }
        }
    }

    private void refund(float balance) {
        reduceBalance(balance);
        this.balance -= balance;

        if (this.balance == 0) System.out.println("Troco retornado com sucesso");
        else System.out.println("Deu ruim");
    }
}

