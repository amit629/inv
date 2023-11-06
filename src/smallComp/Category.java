package smallComp;

public class Category {
	private String categoryName;
	private int categoryId;
	public Category(){
		this.categoryId=-1;
		this.categoryName="";
		
	}
	public Category(String catName,int catId){
		this.categoryId=catId;
		this.categoryName=catName;
	}
	
	public String getCategoryName() {
        return categoryName;
    }

    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

   
    public int getCategoryId() {
        return categoryId;
    }

    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
