class Payment {
    private int paymentId;
    private double amount;
    private String method;

    Payment(int paymentId, double amount, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
    }

    void showPaymentInfo() {
        System.out.println("Payment ID   : " + paymentId);
        System.out.println("Method       : " + method);
        System.out.println("Amount       : " + amount + " Tk");
        System.out.println("Status       : Paid");
    }
}
