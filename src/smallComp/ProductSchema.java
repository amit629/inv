package smallComp;

public class ProductSchema {
	private int id;
	private String SKU;
	private String name;
	private String description;
	private int price;
	private int quantity;
	
	public ProductSchema() {
        this.id = -1;
        this.SKU = "";
        this.name = "";
        this.description = "";
        this.price = 0;
        this.quantity = 0;
    }
    public ProductSchema(int id, String SKU, String name, String description, int price, int quantity) {
        this.id = id;
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    public ProductSchema(String SKU, String name, String description, int price, int quantity) {
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    
    
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for SKU
    public String getSKU() {
        return SKU;
    }

    // Setter for SKU
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(int price) {
        this.price = price;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
	
}
