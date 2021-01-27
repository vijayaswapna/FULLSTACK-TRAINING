package bean;

public class Product {
private int pid;
private String pname;
private Float price;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public Float getPrice() {
	return price;
}
public void setPrice(Float price) {
	this.price = price;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
}

public Product(int pid, String pname, Float price) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
}

public Product() {
	super();
	// TODO Auto-generated constructor stub
}

}



package service;
import bean.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductService implements Serializable
{
        ArrayList<Product> al=new ArrayList<Product>(); 
        Product pro[]=new Product[1000];
       int i=0,k;
        Product p;
        public int addproduct(int id,String pname,float price)
        {
        	pro[i]=new Product(id,pname,price);
        	al.add(pro[i]);
        	i++;
        	return id;
        }
        
        public Product updateProduct(int id,float price)
    	{    
        	  for(Product j:al)
        	  {
        		  if(id==j.getPid())
        		  {
        			  j.setPrice(price);
        			  p=j;
        		  }
        	  }
        	  return p;
        }
        
        public int deleteProduct(int id)
    	{
        	Iterator<Product> iterator = al.iterator();
        	while(iterator.hasNext()) {
        	   Product next = iterator.next();
        	   if(next.getPid()==id) {
        	       iterator.remove();
        	   }
    	}
        	return 1;
        	}
    	
    	public ArrayList displayAllProduct()
    	{		
    		return al;
    	}
    	
    	public float retrieveProductPrice(int id)
    	{
    		 for(Product j:al)
       	  {
       		  if(id==j.getPid())
       		  {
       			 j.getPrice();
       		
       		  }
     		 return j.getPrice();
       	  }
    		 return 1;

    	}
    	

}




package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import bean.Product;
import service.ProductService;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int k,num,temp,ch=0;
		String name;
		float price;
		boolean flag = true;
		int a = 1,id;
	
		ProductService ps = new ProductService();
	    ArrayList<Product> al=new ArrayList<Product>();
		
		
		do
		{
			System.out.println("Enter the Appropriate Option");

			System.out.println("1. Add Product\n2. Update the Product Price\n3. Delete the Product\n4. View All Product\n5. View Price of the Product\n6. Exit");
			
			
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1:
						al = ps.displayAllProduct();
						
						Iterator it1 = al.iterator();
						System.out.println("\n Enter Your Product Name ane Price");
						name = sc.next();
						price = sc.nextFloat();
						boolean inflag = true;
						while(it1.hasNext())
						{
							Product pct = (Product)it1.next();
							if(pct.getPname().equals(name))
							{
								System.out.println(" This Product already Ragistred : " + pct.getPname());
								System.out.println();
								inflag=false;
								break;
							}						
						}
						if(inflag)
						{
							id = ps.addproduct(a,name, price);
							a++;
							System.out.println("\n Please note Your Product Id : " + id);
							ch=0;
						}
						break;
				case 2:
						System.out.println("  Enter Your Product Id");
						id = sc.nextInt();
						System.out.println("Enter Your Product Price");
						price = sc.nextFloat();
						ps.updateProduct(id, price);
						System.out.println("\n Product Price Updated");
						break;
				case 3:
						System.out.println("Enter Your Product Id");
						id = sc.nextInt();
						ps.deleteProduct(id);
						System.out.println("\n Product Deleted");
						break;
				case 4:
						al = ps.displayAllProduct();
						Iterator it = al.iterator();
						while(it.hasNext())
						{
							System.out.println(it.next()); ;
						}
						break;
				case 5:
						System.out.println("\n Enter Your Product Id");
						id = sc.nextInt();
						System.out.println(ps.retrieveProductPrice(id));
						break;
				case 6:		
						System.exit(0);
	
						
						break;
				default:
						System.out.println("\n Enter Appropriate option");
						
			}
		    try
	        {
	            FileOutputStream fos = new FileOutputStream("employeeData");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(al);
	            oos.close();
	            fos.close();
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
			
		}while(flag);
		System.out.println("test 1");

	}

}




