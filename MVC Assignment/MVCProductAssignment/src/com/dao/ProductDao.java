package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;
import com.resource.DbResource;

public class ProductDao {
Connection con;
PreparedStatement pstmt;
ResultSet rs;
	public int storeProduct(Product prod) {
		// TODO Auto-generated method stub
		try {
		con=DbResource.getDbConnection();
		pstmt=con.prepareStatement("insert into product values(?,?,?,?)");
		pstmt.setInt(1, prod.getId());
		pstmt.setString(2, prod.getName());
		pstmt.setFloat(3, prod.getPrice());
		pstmt.setString(4, prod.getStoredate());
		return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	public int deleteProduct(int prodId) {
		try {
			con = DbResource.getDbConnection();
			pstmt = con.prepareStatement("delete from product where id = ?");
			pstmt.setInt(1, prodId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			return 2;
		}
	}
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> listOfProd = new ArrayList<>();
		try {
			con = DbResource.getDbConnection();
			pstmt = con.prepareStatement("select * from product");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt(1));
				prod.setName(rs.getString(2));
				prod.setPrice(rs.getFloat(3));
				prod.setStoredate(rs.getString(4));
				listOfProd.add(prod);
			}
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
		return listOfProd;
	}
	public int updateProduct(Product prod) {
		// TODO Auto-generated method stub
		//return 0;
		try {
			con=DbResource.getDbConnection();
			pstmt=con.prepareStatement("update product set price=? where id=?");
			pstmt.setFloat(1, prod.getPrice());
			pstmt.setInt(2, prod.getId());
			return pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				return 0;
			}
	}
	public int storeCustomerProduct(Product prod) {
		// TODO Auto-generated method stub
		//return 0;
		try {
			con=DbResource.getDbConnection();
			pstmt=con.prepareStatement("insert into customer_product values(?,?,?,?)");
			pstmt.setInt(1, prod.getId());
			pstmt.setString(2, prod.getName());
			pstmt.setFloat(3, prod.getPrice());
			pstmt.setString(4, prod.getStoredate());
			return pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				return 0;
			}
	}
	
	

}
