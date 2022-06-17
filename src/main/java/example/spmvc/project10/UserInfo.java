package example.spmvc.project10;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import org.springframework.format.annotation.DateTimeFormat;

public class UserInfo {
	
	@NotEmpty
	@Email
	private String email; 
	
	@NotEmpty
	private String addr;

	@NotEmpty
	private String phone;
	
	public String getEmail() {return email; }
	public String getAddr() {return addr;}
	public String getPhone() {return phone;}
	
	
	public void setEmail(String email) {this.email=email;}
	public void setAddr(String addr) {this.addr=addr;}
	public void setPhone(String phone) {this.phone=phone;}
	
}
