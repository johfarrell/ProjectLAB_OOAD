package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import model.CartModel;
import model.ProductModel;
import model.TransactionItemModel;
import model.TransactionModel;
import model.VoucherModel;
import view.ViewHRM;
import view.ViewM;
import view.ViewMDetail;
import view.ViewTM;

public class TransactionHandler {
	
	private static TransactionHandler transactionHandler;
	private TransactionModel transaction = new TransactionModel();
	private TransactionItemModel transactionitem = new TransactionItemModel();
	private CartModel cart = new CartModel();
	
	public static String m;
	public static String y;
	
	public static TransactionHandler getInstance(){
		if(transactionHandler == null){
			return new TransactionHandler();
		} else{
			return transactionHandler;
		}
	}
	
	public ViewM view(){
		return new ViewM();
	}
	
	public Vector<TransactionModel> getAllTransaction(String Month, String Year){
		return transaction.getAllTransaction(Month, Year);
	}
	
	public Vector<TransactionItemModel> getAllTransactionItem(String X){
		return transactionitem.getAllTransactionItem(X);
	}
	
	public ViewMDetail viewMDetail() {
		return new ViewMDetail();
	}
	
	public String addProductToCart(Integer ProductID, Integer Quantity) {
		
		String itemstatus;
		
		Vector<Integer> ProID = new Vector<Integer>();
		ProID = ProductHandler.getInstance().getAllProductID();
		
		if(ProID.contains(ProductID) != true) {
			PopUpController.getInstance().idnotfound();
		}else if(ProID.contains(ProductID)) {
			Integer index = ProID.indexOf(ProductID);
			Vector<ProductModel> product = new Vector<ProductModel>();
			product = ProductHandler.getInstance().getAllProduct();
			
			ProductModel checkstock = product.elementAt(index);
			String ProductName = checkstock.getName();
			
			if(Quantity == 0 || Quantity>checkstock.getStock()) {
				PopUpController.getInstance().checkquantity();
			}else if(Quantity != 0 && Quantity<=checkstock.getStock()) {
				
				Vector<Integer> cartItemID = new Vector<Integer>();
				cartItemID = CartHandler.getInstance().getAllItemID();
				
				Vector<CartModel> cartItem = new Vector<CartModel>();
				cartItem = CartHandler.getInstance().getAllItem();
				
				if(cartItemID.contains(ProductID)) {	//Ada di cart, ganti quantity nya
					Integer indexcart = cartItemID.indexOf(ProductID);
					CartModel productUpdate = cartItem.elementAt(indexcart);
					Integer oldQuantity = productUpdate.getQuantity();
					Integer newQuantity = oldQuantity+Quantity;
					
					
					if(newQuantity>checkstock.getStock()) {
						PopUpController.getInstance().checkquantity();
						itemstatus="exist_outofstock";
						return itemstatus;
					}else if(newQuantity<=checkstock.getStock()) {
						productUpdate.setQuantity(newQuantity);
						
						CartHandler.getInstance().changeCartItem(indexcart, productUpdate);
						indexcart=0;
						itemstatus="exist_instock";
						return itemstatus;
					}
				}else if (cartItemID.contains(ProductID) != true) { //Blom ada di cart, tambah baru

					CartHandler.getInstance().addToCart(ProductID, ProductName, Quantity);
					itemstatus="not_exist";
					return itemstatus;	
					
				}				
			}
		}
		itemstatus="false";
		return itemstatus;
	}
	
	public String updateCartQuantity(Integer ProductID, Integer Quantity) {
		String itemstatus;
		
		Vector<Integer> cartItemID = new Vector<Integer>();
		cartItemID = CartHandler.getInstance().getAllItemID();
		
		Vector<CartModel> cartItem = new Vector<CartModel>();
		cartItem = CartHandler.getInstance().getAllItem();
		
		Vector<Integer> ProID = new Vector<Integer>();
		ProID = ProductHandler.getInstance().getAllProductID();
		
		Integer index = ProID.indexOf(ProductID);
		Vector<ProductModel> product = new Vector<ProductModel>();
		product = ProductHandler.getInstance().getAllProduct();
		
		ProductModel checkstock = product.elementAt(index);
		
		Integer indexcart = cartItemID.indexOf(ProductID);
		CartModel productUpdate = cartItem.elementAt(indexcart);
		
		if(Quantity <= -1) {
			PopUpController.getInstance().checkquantity();
		}else if(Quantity != -1) {
			if(Quantity>0) {
				
				if(Quantity>checkstock.getStock()) {
					PopUpController.getInstance().checkquantity();
					itemstatus="outofstock";
					return itemstatus;
				}else if(Quantity<=checkstock.getStock()) {
					productUpdate.setQuantity(Quantity);
					CartHandler.getInstance().changeCartItem(indexcart, productUpdate);

					itemstatus="quantity_changed";
					return itemstatus;
				}
				
			}else if(Quantity==0) {
				CartHandler.getInstance().removeCartItem(indexcart);
				itemstatus="product_removed";
				return itemstatus;
			}
		}
		
		itemstatus="false";
		return itemstatus;
	}
	
	
	public float addCheckOutVoucher(Integer VoucherID) throws ParseException {
		Vector<Integer> VouID = new Vector<Integer>();
		VouID = VoucherHandler.getInstance().getAllVoucherId();
		
		Vector<VoucherModel> voucher = new Vector<VoucherModel>();
		voucher = VoucherHandler.getInstance().getAllVoucher();
		
		if(VouID.contains(VoucherID) != true) {
			PopUpController.getInstance().idnotfound();
		}else if(VouID.contains(VoucherID)){
			Integer index = VouID.indexOf(VoucherID);
			VoucherModel checkdiscount = voucher.elementAt(index);
			
			if(checkdiscount.getStatus().equals("NotUsed")) {
				
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date today = new Date();
				Date today_withouttime = formatter.parse(formatter.format(today));
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date ValidDate = dateFormat.parse(checkdiscount.getDate());  
				
				Float discount = checkdiscount.getDiscount().floatValue();
				
				if(ValidDate.before(today_withouttime)) {
					PopUpController.getInstance().voucherexpired();
					return 0.0f;
				}else if(ValidDate.after(today_withouttime)) {	
					PopUpController.getInstance().voucherapplied();
					return discount;
				}
			}else if(checkdiscount.getStatus().equals("Used")) {
				PopUpController.getInstance().voucheralreadyused();
				return 0.0f;
			}
		}
		return 0.0f;
	}
	
	public String checkoutTransaction(Integer EmployeeID, Integer VoucherID, String PaymentType, Float TotalPrice, Float Money) throws ParseException {
		
		String checkoutStatus;
		
		VoucherHandler.getInstance().useVoucher(VoucherID);

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String timestamp = formatter.format(today);
		Vector<CartModel> Cart = new Vector<CartModel>();
		Cart = cart.getAllItem();
		
		if (Cart.isEmpty()){
			PopUpController.getInstance().cartisempty();
			checkoutStatus="emptycart";
			return checkoutStatus;
		}else if (Cart.isEmpty()!=true) {

			if(PaymentType.equals("Credit")) {
				transaction.checkoutTransaction(VoucherID, EmployeeID, PaymentType, timestamp);
				Integer index = transaction.getIndex();
				Integer ProductId = 0;
				Integer Quantity = 0;
				for(CartModel cart2 : Cart){
					ProductId = cart2.getProductID();
					Quantity = cart2.getQuantity();
					transactionitem.addTransactionItem(index, ProductId, Quantity);
					ProductHandler.getInstance().updateStock(ProductId, Quantity);
				}

				CartHandler.getInstance().emptyCart();
				PopUpController.getInstance().checkoutsuccess(0f);
				
				checkoutStatus="done";
				return checkoutStatus;
				
			}else if(PaymentType.equals("Cash")) {
				if(Money<TotalPrice) {
					PopUpController.getInstance().checkmoney();
				}else if(Money>=TotalPrice) {
					transaction.checkoutTransaction(VoucherID, EmployeeID, PaymentType, timestamp);
					Integer index = transaction.getIndex();
					Integer ProductId = 0;
					Integer Quantity = 0;
					for(CartModel cart2 : Cart){
						ProductId = cart2.getProductID();
						Quantity = cart2.getQuantity();
						transactionitem.addTransactionItem(index, ProductId, Quantity);
						ProductHandler.getInstance().updateStock(ProductId, Quantity);
					}

					Float Changes = Money-TotalPrice;
					CartHandler.getInstance().emptyCart();
					PopUpController.getInstance().checkoutsuccess(Changes);
					
					checkoutStatus="done";
					return checkoutStatus;
				}
			}	
		}
		
		checkoutStatus="false";
		return checkoutStatus;
	}
}





















