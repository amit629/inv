package smallComp;

public class CustomerInfo {
	private String customerName;
    private String customerMob;
    private String customerEmail;

    public CustomerInfo() {
        this.customerName = "";
        this.customerMob = "";
        this.customerEmail = "";
    }

    public CustomerInfo(String name, String mob, String email) {
        this.customerName = name;
        this.customerMob = mob;
        this.customerEmail = email;
    }

   
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerMob() {
        return customerMob;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void setCustomerMob(String mob) {
        this.customerMob = mob;
    }

    public void setCustomerEmail(String email) {
        this.customerEmail = email;
    }
}
