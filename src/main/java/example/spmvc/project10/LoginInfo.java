package example.spmvc.project10;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class LoginInfo {
	@NotEmpty
	@NotBlank
	private String id; 
	
	@NotEmpty
	@NotBlank
	private String pwd; 
	
	private Boolean rememberid; 
	
	public String getId() {return id; }
	public String getPwd() {return pwd; }
	public Boolean getRememberid() {return rememberid;}
	
	
	public void setId(String id) {this.id=id; }
	public void setPwd(String pwd) {this.pwd=pwd;}
	public void setRememberid(Boolean rememberid) {this.rememberid=rememberid; }
	
	
	
	

}
