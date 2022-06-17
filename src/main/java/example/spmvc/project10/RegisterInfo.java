package example.spmvc.project10;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

public class RegisterInfo {
	@NotEmpty
	private String id;
	
	private String name; 

	@NotEmpty
	@Email
	private String email; 
	
	@NotEmpty
	private String pwd; 
	
	
	private String addr;
	private String phone;
	
	public String getId() {return id; }
	public String getName() {return name; }
	public String getEmail() {return email; }
	public String getPwd() {return pwd; }
	public String getAddr() {return addr;}
	public String getPhone() {return phone;}
	
	
	
//	@DateTimeFormat(pattern="yyyyMMdd")
//	public LocalDate getBirthday() {return birthday; }
	
	
	
	public void setId(String id) {this.id=id;}
	public void setName(String name) {this.name=name;}
	public void setEmail(String email) {this.email=email;}
	public void setPwd(String pwd) {this.pwd=pwd;}
	public void setAddr(String addr) {this.addr=addr;}
	public void setPhone(String phone) {this.phone=phone;}
	
}

