package example.spmvc.project10;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ProductInfo {
	
	@NotEmpty
	@NotBlank
	private String productname;
	
	
	public String getProductname() {return productname; }
	
	public void setProductname(String productname) {this.productname=productname; }
}
