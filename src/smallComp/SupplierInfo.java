package smallComp;

public class SupplierInfo {
	private String name;
    private String phone;
    private String email;
    private String paymentTerms;

    public SupplierInfo() {
        this.name = "";
        this.phone = "";
        this.email = "";
        this.paymentTerms = "";
    }

    public SupplierInfo(String name, String phone, String email, String paymentTerms) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.paymentTerms = paymentTerms;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }
}
