package com.service;

import java.util.List;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductService {
	ProductDao pd=new ProductDao();
	public String storeProduct(Product prod)
	{
		if(prod.getPrice()>10000)
		{
			if(pd.storeProduct(prod)>0)
			{
				return "Product Stored Successfully";
			}
			else
			{
				return "Product didn't store";
			}
		}
		else
		{
			return "Product must greater than 10000";
		}
	}
	public String deleteProduct(int prodId) {
		// TODO Auto-generated method stub
		//return null;
		int res = pd.deleteProduct(prodId);
		if(res==1) {
			return "Product deleted successfully";
		}else if(res==2) {
			return "Exception generated";
		}else {
			return "Product didn't find";
		}
	}
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		//return null;
		return pd.getAllProduct();
	}
	public String updateProduct(Product prod) {
		// TODO Auto-generated method stub
		//return null;
		if(prod.getPrice()>10000)
		{
			if(pd.updateProduct(prod)>0)
			{
				return "Product Updated Successfully";
			}
			else
			{
				return "Product didn't update";
			}
		}
		else
		{
			return "Price must greater than 10000";
		}
		
	}
	public String storeCustomerProduct(Product prod) {
		// TODO Auto-generated method stub
		if(prod.getPrice()>10000)
		{
			if(pd.storeCustomerProduct(prod)>0)
			{
				return "Product Stored Successfully";
			}
			else
			{
				return "Product didn't store";
			}
		}
		else
		{
			return "Price must greater than 10000";
		}
	}

}
