package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity

public class Products extends Model {

@ID
private long ID;

@Constraints.Required
private string name;

@Constraints.Required
private double price;

@Constraints.Required
private int stock;


public Products() {
    
   }


public Products(long ID, string name, double price, int stock) {
 this.ID = ID;
 this.name = name;
 this.price = price;
 this.stock = stock;
}

public long getID(){
	return ID;
}

public void setID(long ID) {
	this.ID = ID;
}

public string getname() {
	return name;
}

public void setname(string name) {
	this.ID = ID;
}

public double getprice() {
	return price;
}

public void setprice(double price) {
	this.price;
]

public int getstock() {
	return stock;
}

public void setstock(int stock) {
	this.stock;
}

	}
public static Finder<Long,Products> find = new Finder<Long,Products>(Products.class);

public static List<Products> findAll() {
	return Products.find.all();
}
   		
  
     
       


  

   }
