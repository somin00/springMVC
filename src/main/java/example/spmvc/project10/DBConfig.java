package example.spmvc.project10;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;

public class DBConfig {
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		DataSource ds=new DataSource(); 
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/jdbctest?characterEncoding=utf8"); 
		ds.setUsername("root"); 
		ds.setPassword("dhthals0320"); 
		ds.setInitialSize(2); 
		ds.setMaxActive(10); 
		return ds; 
	}
	
	@Bean public RegisterQuery registerQuery() {
		return new RegisterQuery(dataSource());
	}
	
	@Bean public LoginQuery loginQuery() {
		return new LoginQuery(dataSource());
	}
	
	@Bean public UserInfoQuery userInfoQuery() {
		return new UserInfoQuery(dataSource());
	}
	
	@Bean public DeleteQuery deleteQuery() {
		return new DeleteQuery(dataSource());
	}
	
	@Bean public ProductQuery productQuery() {
		return new ProductQuery(dataSource());
	}
	
	@Bean public OrderQuery orderQuery() {
		return new OrderQuery(dataSource());
	}

}






