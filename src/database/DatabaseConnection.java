package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import helperClass.HelperUtils;
import smallComp.AlertMessagePanel;
import smallComp.Category;
import smallComp.ProductSchema;
import smallComp.UserDetails;
public class DatabaseConnection {
    private Connection connection;
    
    // Constructor - Establishes the database connection
    public DatabaseConnection(String databaseName) {
        try {
            // Load the SQLite JDBC driver
//            Class.forName("org.sqlite.JDBC");
            
            String jdbcUrl = "jdbc:postgresql://localhost:5432/"+databaseName;
            String username = "postgres";
            String password = "amit22440";
            // Connect to the specified database
            connection = DriverManager.getConnection(jdbcUrl,username,password);
//            this.createSchema();
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
            new AlertMessagePanel("Database cannot connect");
            
        }
    }
    
    public boolean hasConnection(){
    	if(connection!=null) {
    		return true;
    	}
    	return false;
    }
    
    
    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the database.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database connection: " + e.getMessage());
        }
    }
    
//    Create the database schema for the application
    public void createSchema() {
        try {
            // Create the products table
            
            
            // Create the categories table
//            String createCategoriesTableQuery = "CREATE TABLE IF NOT EXISTS categories (" +
//                    "id serial PRIMARY KEY," +
//                    "name TEXT NOT NULL)";
//            Statement createCategoriesTableStatement = connection.createStatement();
//            createCategoriesTableStatement.execute(createCategoriesTableQuery);
//            createCategoriesTableStatement.close();
            
            // Create the product_categories table
//            String createProductCategoriesTableQuery = "CREATE TABLE IF NOT EXISTS product_categories (" +
//                    "product_id INT," +
//                    "category_id INT," +
//                    "FOREIGN KEY (product_id) REFERENCES products(id)," +
//                    "FOREIGN KEY (category_id) REFERENCES categories(id)," +
//                    "PRIMARY KEY (product_id, category_id))";
//            
//            Statement createProductCategoriesTableStatement = connection.createStatement();
//            createProductCategoriesTableStatement.execute(createProductCategoriesTableQuery);
//            createProductCategoriesTableStatement.close();
            String createUserTableQuery = "CREATE TABLE IF NOT EXISTS UserData (" +
                    "id serial PRIMARY KEY," +
                    "username TEXT NOT NULL," +
                    "name TEXT NOT NULL," +
                    "email VARCHAR(100) NOT NULL," +	
                    "password VARCHAR(50) NOT NULL," +
                    "is_admin Boolean DEFAULT false)";
            Statement createUserTableStatement = connection.createStatement();
            createUserTableStatement.execute(createUserTableQuery);
            createUserTableStatement.close();
            
            String createSupplierTableQuery="CREATE TABLE IF NOT EXISTS Supplier ("+
            		"SupplierID SERIAL PRIMARY KEY,"+
            	    "Name VARCHAR(100) NOT NULL,"+
            	    "ContactName VARCHAR(100),"+
            	    "Phone VARCHAR(20),"+
            	    "Email VARCHAR(100),"+
            	    "PaymentTerms VARCHAR(50))";
            Statement createSupplierTableStatement=connection.createStatement();
            createSupplierTableStatement.execute(createSupplierTableQuery);
            createSupplierTableStatement.close();
            
            
            String createProductsTableQuery = "CREATE TABLE IF NOT EXISTS Products (" +
            		"ProductID SERIAL PRIMARY KEY,"+
            	    "SKU VARCHAR(50) NOT NULL,"+
            	    "Name VARCHAR(100) NOT NULL,"+
            	    "Description TEXT,"+
            	    "Price DECIMAL(10, 2) NOT NULL,"+
            	    "QuantityInStock INT,"+
                    "created_at timestamptz DEFAULT now()," +
                    "updated_at timestamptz DEFAULT now())";
            Statement createProductsTableStatement = connection.createStatement();
            createProductsTableStatement.execute(createProductsTableQuery);
            createProductsTableStatement.close();
            
            String createProductCategoryTable = "CREATE TABLE IF NOT EXISTS ProductCategory (" +
                    "CategoryID SERIAL PRIMARY KEY, " +
                    "CategoryName VARCHAR(50) NOT NULL " +
                    ")";
                Statement stmt1 = connection.createStatement();
                stmt1.execute(createProductCategoryTable);
                
             
                String createAssignProductToCategory="CREATE TABLE IF NOT EXISTS ProductHasCategory ("+
                		"id SERIAL PRIMARY KEY,"+
                		"ProductID INTEGER," +
                        "CategoryID INTEGER );";
                
                stmt1.execute(createAssignProductToCategory);
                
                stmt1.close();
                
            String createProductSupplierTable = "CREATE TABLE IF NOT EXISTS ProductSupplier (" +
                    "ProductSupplierID SERIAL PRIMARY KEY, " +
                    "ProductID INT, " +
                    "SupplierID INT) ";
                  
                Statement stmt2 = connection.createStatement();
                stmt2.execute(createProductSupplierTable); 
                stmt2.close();
            
            
            
            String createSalesOrderTableQuery="CREATE TABLE IF NOT EXISTS SalesOrder ("+
            		"OrderID SERIAL PRIMARY KEY,"+
            	    "CustomerName VARCHAR(100) NOT NULL,"+
            	    "TotalAmount DECIMAL(10, 2) NOT NULL,"+
            	    "OrderDate DATE,"+
            	    "UserID INT,"+
            	    "created_at timestamptz DEFAULT now())";
            Statement createSalesOrderTableStatement=connection.createStatement();
            createSalesOrderTableStatement.execute(createSalesOrderTableQuery);
            createSalesOrderTableStatement.close();
            
            String createSalesOrderItemQuery="CREATE TABLE IF NOT EXISTS SalesOrderItem ("+
            		"OrderItemID SERIAL PRIMARY KEY,"+
            	    "OrderID INT,"+
            	    "ProductID INT,"+
            	    "Quantity INT NOT NULL )";
            
            Statement createSalesOrderItemStatement=connection.createStatement();
            createSalesOrderItemStatement.execute(createSalesOrderItemQuery);
            createSalesOrderItemStatement.close();
            
            
            String createInvoiceTableQuery = "CREATE TABLE IF NOT EXISTS Invoice (" +
                    "InvoiceID SERIAL PRIMARY KEY, " +
                    "InvoiceDate DATE, " +
                    "AmountDue DECIMAL(10, 2) NOT NULL, " +
                    "OrderID INT UNIQUE )";
            
                Statement createInvoiceTableStatament = connection.createStatement();
                createInvoiceTableStatament.execute(createInvoiceTableQuery);
                createInvoiceTableStatament.close();
            
                Statement exQuery=connection.createStatement();
                
                String addProductCategoryForeignKeyQuery = "ALTER TABLE ProductHasCategory " +
                        "ADD FOREIGN KEY (ProductID) REFERENCES Products(ProductID),"+
                        "ADD FOREIGN KEY (CategoryID) REFERENCES ProductCategory(CategoryID)";
                exQuery.execute(addProductCategoryForeignKeyQuery);
                
                String addProductSupplierForeignKeyQuery = "ALTER TABLE ProductSupplier " +
                        "ADD FOREIGN KEY (ProductID) REFERENCES Products(ProductID), " +
                        "ADD FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID)";
                exQuery.execute(addProductSupplierForeignKeyQuery);
                
                String addInvoiceOrderForeignKeyQuery = "ALTER TABLE Invoice " +
                	    "ADD FOREIGN KEY (OrderID) REFERENCES SalesOrder(OrderID)";
                exQuery.execute(addInvoiceOrderForeignKeyQuery);
                
                String addSalesOrderItemOrderForeignKeyQuery = "ALTER TABLE SalesOrderItem " +
                	    "ADD FOREIGN KEY (OrderID) REFERENCES SalesOrder(OrderID), " +
                	    "ADD FOREIGN KEY (ProductID) REFERENCES Products(ProductID)";
                exQuery.execute(addSalesOrderItemOrderForeignKeyQuery);
                
                String addSalesOrderUserForeignKeyQuery = "ALTER TABLE SalesOrder " +
                	    "ADD FOREIGN KEY (UserID) REFERENCES UserData(id)";
                exQuery.execute(addSalesOrderUserForeignKeyQuery);
                
                exQuery.close();
            
           
            
            
            System.out.println("Schema created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create schema: " + e.getMessage());
        }
    }

    
    
    //check user privlage
    public boolean isAdmin(String email) {
    	String query="SELECT is_admin from UserData where email='"+email+"';";
    	try {
    		boolean isAdm=false;
    		Statement st=connection.createStatement();
    		ResultSet rs=st.executeQuery(query);
    		while(rs.next()) {
    			if(rs.getBoolean(1)) {
    				isAdm=true;
    				break;
    			}
    		}
    		return isAdm;
    	}catch(SQLException e) {
    		System.out.println("database error: " + e.getMessage());
    		return false;
    	}
    }
    
    public TableModel getUsers(String email){
    	String quer="SELECT id,name,username,email,password from UserData where is_admin=false;";
    	try {
    		if(!this.isAdmin(email)) {
    			return null;
    		}	
    		ArrayList<String[]>ans=new ArrayList<>();
    		Statement st=connection.createStatement();
    		ResultSet rs=st.executeQuery(quer);
    		return HelperUtils.resultSetToTableModel(rs);
    	}catch(SQLException e) {
    		System.out.println("database error: "+e.getMessage());
    		 return null;
    	}
    }
    
    //get single user det
    public UserDetails getSingleUserDetails(String authEmail,String id) {
//    	int uid=Integer.parseInt(id);
    	String query="SELECT * from userData where id='"+id+"' and is_admin=false;";
    	try {
    		Statement st=connection.createStatement();
    		ResultSet rs=st.executeQuery(query);
    		UserDetails ret=new UserDetails();
    		while(rs.next()) {
    			ret=new UserDetails(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6));
    		}
    		return ret;
    	}catch(SQLException e) {
    		new AlertMessagePanel("problem with database");
    		System.out.println(e.getMessage());
    		return new UserDetails();
    	}
    	
    }
    
    //Add new User
    public boolean addUser(String authEmail,String name,String username,String email,String password,boolean is_admin) {
    	try {
    		boolean check=this.isAdmin(authEmail);
    		if(check) {
    			String query="INSERT INTO userdata(username,name,email,password,is_admin) values (?,?,?,?,?);";
    			PreparedStatement st=connection.prepareStatement(query);
    			st.setString(1, username);
    			st.setString(2, name);
    			st.setString(3, email);
    			st.setString(4, password);
    			st.setBoolean(5, is_admin);
    			int insertedRows=st.executeUpdate();
    			if(insertedRows>0) {
    				new AlertMessagePanel("User Succesfully added");
    				return true;
    			}
    			else {
    				new AlertMessagePanel("Problem with database");
    				return false;
    				
    			}
    			
    		}
    		else {
    			new AlertMessagePanel("Only Admin Can Perform this Operation");
    			return false;
    		}
    	}
    	catch(SQLException e) {
    		new AlertMessagePanel("there some problem with database");
    		System.out.println(e.getMessage());
    		return false;
    	}
    	catch(Exception e) {
    		new AlertMessagePanel("User Cannot be added");
    		System.out.println(e.getMessage());
    		return false;
    	}
		
    }
    

    
    //checkLogin
    public boolean isAuthorized(String username,String password){
    	String getUserQuery="select * from UserData where email='"+username+"' OR username='"+username+"';";
    	
    	try {
    		UserDetails us=new UserDetails();
    		Statement up=connection.createStatement();
    		ResultSet rp=up.executeQuery(getUserQuery);
    		while(rp.next()) {
    			String user=rp.getString(2);
    			if(user.length()!=0) {
    				us=new UserDetails(rp.getString(2),rp.getString(3),rp.getString(4),rp.getString(5),rp.getBoolean(6));
				System.out.println(rp.getString(2)+rp.getString(3)+rp.getString(4)+rp.getString(5)+rp.getBoolean(6));
    				
    			}
    		}
    		up.close();
    		rp.close();
    		
    		if(us.getEmail().length()==0) {
    			return false;
    		}
    		else {
    			if(us.getPassword().equals(password)) {
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
    	}catch (SQLException e) {
             System.out.println(e.getMessage());
             return false;
        }
    }
    public UserDetails GetUserDetails(String username,String password){
    	String getUserQuery="select * from UserData where email='"+username+"' OR username='"+username+"';";
    	UserDetails ud=new UserDetails();
    	try {
    		Statement up=connection.createStatement();
    		ResultSet rp=up.executeQuery(getUserQuery);   
    		while(rp.next()) {
    			ud=new UserDetails(rp.getString(2),rp.getString(3),rp.getString(4),rp.getString(5),rp.getBoolean(6));
    		}
    		return ud;
    	}catch (SQLException e) {
             System.out.println(e.getMessage());
             return ud;
        }
    	
    }
    
    //get all product categories
    public ArrayList<Category> getCategories() {
    	String getUserQuery="select categoryid,categoryname from productcategory";
    	try {
    		Statement st=connection.createStatement();
    		ResultSet rs=st.executeQuery(getUserQuery);
    		ResultSetMetaData mt=rs.getMetaData();
    		int rows=rs.getFetchSize();
    		System.out.println(rows);
    		ArrayList<Category>cat=new ArrayList<>();
    		
    		while(rs.next()) {
    			
    			cat.add(new Category(rs.getString(2),rs.getInt(1)));
    		}
    		return cat;
    		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    		return new ArrayList<Category>();
    		
    	}
    }
    
    //get Product Name Only
    public String[] getCategoryName() {
    	ArrayList<Category> cat=this.getCategories();
    	if(cat.size()==0) {
    		return new String[] {"problem"};
    	}
    	String catName[]=new String[cat.size()];
    	for(int i=0;i<cat.size();i++) {
    		catName[i]=cat.get(i).getCategoryName();
    	}
    	return catName;
    }
    
    public TableModel getCategoryTable() {
    	String getUserQuery="select categoryid as Category_Id ,categoryname as Category_Name from productcategory";
    	try {
    		Statement st=connection.createStatement();
    		ResultSet rs=st.executeQuery(getUserQuery);
    		return HelperUtils.resultSetToTableModel(rs);
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    		return new DefaultTableModel();
    	}
    }
    
    public boolean AddCategory(String catName,String authEmail) {
    	boolean privlage=this.isAdmin(authEmail);
    	if(!privlage) {
    		new AlertMessagePanel("Not enough privlage");
    		return false;
    	}
    	String Query="INSERT INTO productcategory(categoryname) values(?);";
    	try {
    		PreparedStatement st=connection.prepareStatement(Query);
    		st.setString(1, catName);
    		int rowsUpdated=st.executeUpdate();
    		if(rowsUpdated>0) {
    			new AlertMessagePanel("Category Successfully created");
    			return true;
    		}
    		else {
    			new AlertMessagePanel("Databse Error");
    			return false;
    		}
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    		new AlertMessagePanel(e.getMessage());
    		return false;
    	}
    }
    
    
    public boolean AddProduct(ProductSchema pr,String AuthorizedMail){
    		String Query="INSERT INTO products(sku,name,description,price,quantityinstock) values(?,?,?,?,?);";
    		try {
    			PreparedStatement st=connection.prepareStatement(Query);
    			st.setString(1, pr.getSKU());
    			st.setString(2, pr.getName());
    			st.setString(3, pr.getDescription());
    			st.setInt(4, pr.getPrice());
    			st.setInt(5, pr.getQuantity());
    			int rowsAffected=st.executeUpdate();
    			if(rowsAffected>0) {
    				new AlertMessagePanel("Product Added Succesfully");
    				return true;
    			}else {
    				new AlertMessagePanel("Unsuccesfull");
    				return false;
    			}
    			
    		}catch(SQLException e) {
    			System.out.println(e.getMessage());
    			new AlertMessagePanel("Databse Problem");
    			return false;
    		}
    		
    }
    
    public TableModel getProducts(String Type) {
    	String Query="";
    	if(Type=="add") {
    		Query="SELECT productid as Product_Id,sku as SKU,name as Name,description,price,quantityinstock as Units_In_Stock ,created_at as Added_On FROM products;";
    	}else {
    		Query="SELECT productid as Product_Id,name as Name,quantityinstock as Units_In_Stock  FROM products;";
    	}
    	try {
    		Statement st=connection.createStatement();
    		ResultSet rs=st.executeQuery(Query);
    		return HelperUtils.resultSetToTableModel(rs);
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    		return new DefaultTableModel();
    	}
    }
    public String[] getAllCategoryId() {
    	ArrayList<Category>arr=this.getCategories();
    	String pid[]=new String[arr.size()];
    	for(int i=0;i<arr.size();i++) {
    		pid[i]=Integer.toString(arr.get(i).getCategoryId());
    	}
    	return pid;
    }
    
    public Category getCategoryById(int pid) {
    	String Query="SELECT * from productcategory where categoryid=?;";
    	Category cd=new Category();
    	try {
    		PreparedStatement st=connection.prepareStatement(Query);
    		st.setInt(1, pid);
    		ResultSet rs=st.executeQuery();
    		while(rs.next()) {
    			cd=new Category(rs.getString(2),rs.getInt(1));
    		}
    		return cd;
    	}catch(SQLException e) {
    		new AlertMessagePanel("database problem");
    		return cd;
    	}
    }
    public String[] getAllProductId() {
    	String Query="SELECT productid from products";
    	try {
    		Statement st=connection.createStatement();
    		ResultSet rs=st.executeQuery(Query);
    		ArrayList<String>arr=new ArrayList<>();
    		while(rs.next()) {
    			arr.add(Integer.toString(rs.getInt(1)));
    		}
    		return arr.toArray(new String[arr.size()]);
    	}
    	catch(SQLException e){
    		System.out.println(e.getMessage());
    		return new String[] {"Cannot Load"};
    	}
    }
    
    public ProductSchema getProductData(int pid) {
    	String Query="SELECT * FROM products where productid=?;";
    	ProductSchema pr=new ProductSchema();
    	try {
    		PreparedStatement st=connection.prepareStatement(Query);
    		st.setInt(1, pid);
    		ResultSet rs=st.executeQuery();
    		while(rs.next()) {
    			pr=new ProductSchema(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
    		}
    		return pr;
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    		return pr;
    	}
    }
    
    public TableModel ProductWithCategories(){
    	String Query="SELECT c.id,p.productId,p.name,b.categoryid,b.categoryname from products p inner join "
    			+ "producthascategory c on p.productid=c.productid inner join"
    			+ " productcategory b on c.categoryid=b.categoryid ";
    	try {
    		Statement st=connection.createStatement();
    		ResultSet rs=st.executeQuery(Query);
    		return HelperUtils.resultSetToTableModel(rs);
    	}
    	catch(SQLException e) {
    		System.out.println(e.getMessage());
    		return new DefaultTableModel();
    	}
    }
    
    public boolean AssignProductToCategory(int productid,int categoryid){
    	String Query="INSERT INTO producthascategory(productid,categoryid) values(?,?);";
    	try {
    		PreparedStatement pt=connection.prepareStatement(Query);
    		pt.setInt(1, productid);
    		pt.setInt(2, categoryid);
    		int rowsInserted=pt.executeUpdate();
    		if(rowsInserted>0) {
    			new AlertMessagePanel("Category Assigned");
    			return true;
    		}
    		else {
    			new AlertMessagePanel("Unsuccesfull");
    			return false;
    		}
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    		new AlertMessagePanel("Database Error");
    		return false;
    	}
    }
    
    

}
