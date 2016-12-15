package controllers;

import play.api.Enviroment;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


import views.html.*;

import models.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

private FormFactory formfactory;


@Inject
public HomeController(FormFactory f) {
	this.formFactory = f;
}

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Hello World"));
    }

    public Result BMI() {
        return ok(BMI.render("Hello World"));

    }

    public Result Exercise() {
        return ok(Exercise.render("Hello World"));

    }

    public Result contact() {
        return ok(contact.render("Hello World"));

    }

     public Result Breakfast() {
        return ok(Breakfast.render("Hello World"));

    }

     public Result Lunch() {
        return ok(Lunch.render("Hello World"));

    }

     public Result Dinner() {
        return ok(Dinner.render("Hello World"));

    }

     public Result Products() {
	List<Products> productsList = Products.findall();
        return ok(Products.render(ProductsList));

    }
  
    public Result addProduct() {
	Form<Product> addProductForm = formFactory.form(Product.class);
	return ok(addProduct.render(addProductForm));
}

    public Result addProductSubmit(){

	Form<Product> newProductForm = formFactory.form(Product.class).bindFromRequest();
	if(newProductForm.hasErrors()){
	return badRequest(addProduct.render(newProductForm));
}

	Product newProduct = newProductForm.get();

	newProduct.save();

	flash("success", "Product" + newProduct.getName() + "has been created");
	
	return redirect(controllers.routes.HomeController.products());
}

	public Result deleteProduct(Long id) {
	Product.find.ref(id).delete();
	flash("success", "Product has been deleted");
	return redirect(routes.HomeControllers.products());
}	
}


}

        


