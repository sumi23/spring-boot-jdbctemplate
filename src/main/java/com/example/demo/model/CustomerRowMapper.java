package com.example.demo.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs,int rowNum) throws SQLException{
		
		Customer details =new Customer();
    	details.setId(rs.getInt("id"));
        details.setName(rs.getString("name"));
        details.setAge(rs.getInt("age"));
        return details;
		
	}

}
