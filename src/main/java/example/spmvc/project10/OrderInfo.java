package example.spmvc.project10;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderInfo {
	
	@NotEmpty
	@NotBlank
	private String orderProductName; 
	
	@DateTimeFormat(pattern="yyyyMMdd")
	private LocalDate orderDate; 
	
	public String getorderProductName() {return orderProductName;}
	public LocalDate getorderDate() {return orderDate; }
	
	
	public void setorderProductName(String orderproduct) {this.orderProductName=orderproduct; }
	public void setorderDate(LocalDate orderDate) {this.orderDate=orderDate;}
}
