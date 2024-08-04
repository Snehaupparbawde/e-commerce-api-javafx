package org.dnyanyog.product_screen;

import org.dnyanyog.addProduct.AddProduct;
import org.dnyanyog.home.HomeScreen;

public class ProductScreenController {
	public void addproductClicked() {
		new AddProduct().show();
	}

	public void exitProductScreen() {
		new HomeScreen().show();

	}

}
/*
 * public void updateProductClick() { new UpdateProduct().show();
 * 
 * }
 * 
 * public void searchProductClick() { new SearchProduct().show();
 * 
 * }
 * 
 * public void deleteProductClick() { new DeleteProduct().show();
 * 
 * }
 */
