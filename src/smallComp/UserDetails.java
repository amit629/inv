package smallComp;

public class UserDetails {
	private String username;
	private String name;
	private String email;
	private String password;
	private Boolean isAdmin;
	public UserDetails(String username,String name,String email,String password,Boolean isAdmin){
		this.username=username;
		this.password=password;
		this.name=name;
		this.email=email;
		this.isAdmin=isAdmin;
	}
	public UserDetails(){
		username="";
		password="";
		name="";
		email="";
	}
	
	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
