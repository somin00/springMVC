package example.spmvc.project10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.text.DateFormat;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//
//import example.spmvc.project10.OrderInfo;
//import example.spmvc.project10.CustomerInfo;
//import example.spmvc.project10.DBConfig;
import example.spmvc.project10.LoginInfo;
import example.spmvc.project10.ProductInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	UserInfo userInfo;
	ProductInfo product_info=new ProductInfo();
	
	
	
	@GetMapping("/")
	public String home() {
		return "home"; 
	}
	
	@RequestMapping(value="/userRegister", method=RequestMethod.GET)
	public String userRegister(RegisterInfo registerInfo, Errors errors) {
	
		return "userRegister"; 
	}
	
	@PostMapping("/registerResult")
	public String registerResult(@Valid RegisterInfo registerInfo, Errors errors) {

		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		RegisterQuery registerQuery=ctx.getBean(RegisterQuery.class); 
		
		//중복 검사
		if(registerQuery.duplicate("id", registerInfo.getId())>0) {
			errors.rejectValue("id", "duplicated"); 
		}
		if(registerQuery.duplicate("email", registerInfo.getEmail())>0) {
			errors.rejectValue("email", "duplicated"); 
		}
		if(errors.hasErrors()) {
			return "userRegister"; 
		}
		registerQuery.insertMember(registerInfo.getId(), registerInfo.getName(), registerInfo.getEmail(), registerInfo.getPwd(), registerInfo.getAddr(), registerInfo.getPhone(), errors); 

		return "registerResult";  
	}
	
	@RequestMapping(value="/userLogin",  method=RequestMethod.GET)
	public String userLogin(LoginInfo loginInfo, Model model, HttpSession session, @CookieValue(value="REMEMBERID", required=false) Cookie rCookie) {
		if(session!=null) {
			if(rCookie!=null) {
				loginInfo.setId(rCookie.getValue()); 
				loginInfo.setRememberid(true); 
			}
			model.addAttribute("authInfo", (LoginInfo)session.getAttribute("authInfo")); 
		}
		return "userLogin"; 
	}
	
	@PostMapping("/loginResult")
	public String loginResult(@Valid LoginInfo loginInfo, Errors errors, HttpSession session,  HttpServletResponse response) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		LoginQuery loginQuery=ctx.getBean(LoginQuery.class); 

		if(loginQuery.checkLogin("id", loginInfo.getId(), "pwd", loginInfo.getPwd())!=1) {
			errors.rejectValue("pwd", "noSame"); 
		}
		if(errors.hasErrors()) {
			return "userLogin"; 
		}
		
//		userInfo.setEmail(loginQuery.setUser("id", loginInfo.getId(), "pwd", loginInfo.getPwd()));
		
		session.setAttribute("authInfo", loginInfo); 
		
		
		Cookie rememberCookie=new Cookie("REMEMBERID", loginInfo.getId()); 
		rememberCookie.setPath("/"); 
		if(loginInfo.getRememberid()) {
			rememberCookie.setMaxAge(60*60*24*30); 
		}else {
			rememberCookie.setMaxAge(0); 
		}response.addCookie(rememberCookie); 
		
		
		return "loginResult";  
	}

	//정보 조회
	@RequestMapping("/userInfo/{id}")
	public String userinfo(@PathVariable("id") String userId, HttpSession session, UserInfo userInfo) {

		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		UserInfoQuery userInfoQuery=ctx.getBean(UserInfoQuery.class); 
		userInfo=userInfoQuery.setUserInfo(userId, userInfo); 
		userInfo.setEmail(userInfo.getEmail());
		userInfo.setAddr(userInfo.getAddr());
		userInfo.setPhone(userInfo.getPhone()); 
		return "userinfo"; 
	}
//	@GetMapping("/submit")
//	public String loginRedirect() {
//		return "redirect:/";
//	}
//	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session!=null) session.invalidate(); 
		return "logout"; 
	}
	
	@RequestMapping("/userDelete/{id}")
	public String userDelete(@PathVariable("id") String userId,HttpSession session, LoginInfo loginInfo) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		DeleteQuery deleteQuery=ctx.getBean(DeleteQuery.class);
		deleteQuery.deleteUser(loginInfo.getId()); 
		if(session!=null) session.invalidate(); 
		return "userDelete"; 
	}
	

	
	
	@RequestMapping("/modifyUserInfo")
	public String modifyuserinfo(UserInfo userInfo) 
	{
		
		return"modifyuserinfo";
	}

	
	@PostMapping("/submituserinfo")
	public String modifyUserInfoResult(@Valid UserInfo userInfo, Errors errors) 
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		UserInfoQuery userInfoQuery=ctx.getBean(UserInfoQuery.class);
		userInfoQuery.updateUserInfo(userInfo.getEmail(), userInfo.getAddr(), userInfo.getPhone());
		if(errors.hasErrors()) 
		{
			return"modifyuserinfo";
		}
		return "userinfo"; 
	}
	
	@RequestMapping("/lookup")
	public String lookupProduct() {
	
		return "lookup"; 
	}
	
	@RequestMapping(value="/allProduct", method=RequestMethod.GET)
	public String allProduct(Model model) {
	
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		ProductQuery productQuery=ctx.getBean(ProductQuery.class);
		model.addAttribute("allProductResult", productQuery.showProductList());
	
		
		return "allProduct"; 
	}
	
	@RequestMapping(value="/allInfo", method=RequestMethod.GET)
	public String allProductInfo(Model model) {
	
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		ProductQuery productQuery=ctx.getBean(ProductQuery.class);
		model.addAttribute("allProductInfo", productQuery.printInfo());
	
		
		return "allInfo"; 
	}
	
	
	@RequestMapping(value="/searchProduct", method=RequestMethod.GET)
	public String searchProduct(ProductInfo productInfo) {
		
		return "searchProduct"; 
	}
	
	@PostMapping("/searchResult")
	public String searchResult( ProductInfo productInfo, Model model) {

		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		ProductQuery productQuery=ctx.getBean(ProductQuery.class);
		System.out.println(productInfo.getProductname());
		
		model.addAttribute("searchProduct", productQuery.searchProduct(productInfo.getProductname()));

		product_info.setProductname(productInfo.getProductname());
	
		return "searchResult"; 
	}
	
	@RequestMapping("/productInfo")
	public String productInfo( ProductInfo productInfo, Model model) {

		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		ProductQuery productQuery=ctx.getBean(ProductQuery.class);
		model.addAttribute("productDetail", productQuery.productDetail(product_info.getProductname()));
		product_info.setProductname(productInfo.getProductname());
	
		return "productInfo"; 
	}
	
	@RequestMapping("/orderSearch")
	public String orderSearch() {

		return "orderSearch"; 
	}
	
	
	
	@RequestMapping("/orderComplete/{id}")
	public String orderComplete(@PathVariable("id") String name) {
		LocalDate now=LocalDate.now();
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		OrderQuery orderQuery=ctx.getBean(OrderQuery.class);
		
		orderQuery.addOrderList(name, product_info.getProductname(),  now);
	
		return "orderComplete";
	}
		
	
	@RequestMapping("/orderlist/{id}")
	public String orderList(@PathVariable("id") String name, Model model) {
		LocalDate now=LocalDate.now();
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		OrderQuery orderQuery=ctx.getBean(OrderQuery.class);
		model.addAttribute("orderResult", orderQuery.showOrderList(name)); 
	
		
		return "orderlist";
	}
	
	@RequestMapping(value="/searchOrderProduct", method=RequestMethod.GET)
	public String searchOrderProduct(OrderInfo orderInfo) {
		
		return "searchOrderProduct"; 
	}
	
	@PostMapping("/searchOrderList/{id}")
	public String searchOrderList( OrderInfo orderInfo, @PathVariable("id") String name, Model model, Errors errors) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		OrderQuery orderQuery=ctx.getBean(OrderQuery.class);	
		model.addAttribute("orderProduct", orderQuery.searchName(name, orderInfo.getorderProductName()));

		if(errors.hasErrors()) {
			return "searchOrderList";
		}
		return "searchOrderList"; 
	}
	
	@RequestMapping(value="/searchWithDate", method=RequestMethod.GET)
	public String searchWithDate(OrderInfo orderInfo) {
		
		return "searchWithDate"; 
	}
	
	@PostMapping("/dateSearchResult/{id}")
	public String dateSearchResult(OrderInfo orderInfo, @PathVariable("id") String name, Model model, Errors errors) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		OrderQuery orderQuery=ctx.getBean(OrderQuery.class);
		model.addAttribute("dateOrderResult", orderQuery.searchDate(name, orderInfo.getorderDate()));
		System.out.println(orderInfo.getorderDate());
		
		if(errors.hasErrors()) {
			return "searchWithDate"; 
		}
		return "dateSearchResult"; 
	}
}
	

	
