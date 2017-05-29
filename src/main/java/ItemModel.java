/**
 * Created by irishmarquez on 5/27/17.
 */
public class ItemModel {

    //private int    Id;
    private String generalName;
    //private String product;
    //private double cost;
    //private String description;
    private String imageLocation;

    //public void setId(int Id) {this.Id = Id; }
    public void setGeneralName(String generalName) { this.generalName = generalName; }
    // public void setProduct(String product) { this.product = product; }
    // public void setCost(double cost) {this.cost = cost; }
    //public void setDescription(String description) { this.description = description; }
    public void setImageLocation(String imageLocation) { this.imageLocation = imageLocation; }

    //public int    getId() { return this.Id; }
    public String getGeneralName() { return this.generalName; }
    //public String getProduct() {return this.product; }
    //public double getCost() { return this.cost; }
    //public String getDescription() {return this.description; }
    public String getImageLocation() { return this.imageLocation; }
}
