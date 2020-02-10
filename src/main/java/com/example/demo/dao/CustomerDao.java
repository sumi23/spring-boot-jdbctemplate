package com.example.demo.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.UpdateCustomerdto;
import com.example.demo.model.Customer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerRowMapper;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository

public class CustomerDao {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
     public List<Customer> viewCustomer(){
    	     
    	       String query = "select * from customer";
    	       CustomerRowMapper rowMapper=new CustomerRowMapper();
    	       List<Customer> list=jdbcTemplate.query(query, rowMapper);
    	       return list;   
    	   
    	}
       public void insertCustomer(Customer c) {
    	   

   			String query = "insert into customer(id,name,age) values ( ?,?,?)";
            jdbcTemplate.update(query,c.getId(),c.getName(),c.getAge());
   			
    	    	   
       }
       public  boolean deleteCustomer(int id){
   		
    	    int result;
   		    String query = "delete from customer where id= ?";
   			result=jdbcTemplate.update(query,id);
   			if(result>0)
   				return true;
   			else
   			    return false;

   	}
       public  boolean updateCustomerdao(UpdateCustomerdto uc) throws Exception {
      	
       	   int result;
      	    String query= "update customer set age=(?) where id=(?)";
      	    result=jdbcTemplate.update(query,uc.getAge(),uc.getId());
      		    if(result>0)
      		    	return true;
      		    else 
      		    	return false;
      	}
     
}