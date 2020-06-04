package controller;

import view.CartIsEmpty;
import view.CheckMoneyAmount;
import view.CheckQuantity;
import view.CheckoutSuccess;
import view.ConfirmationDeleteProduct;
import view.ConfirmationDeleteVoucher;
import view.ConfirmationFire;
import view.ConfirmationResetPassword;
import view.DateMustLess;
import view.DateMustMore;
import view.DeleteProductSuccess;
import view.DeleteVoucherSuccess;
import view.DescriptionLong;
import view.FireSuccess;
import view.IDNotFound;
import view.InactiveEmployee;
import view.InsertSuccess;
import view.NameCannotEmpty;
import view.NotValidDiscount;
import view.NotValidPrice;
import view.NotValidRole;
import view.NotValidStock;
import view.ResetSuccess;
import view.SalaryMustMore;
import view.UpdateSuccess;
import view.UsernameNotFound;
import view.UsernameUsed;
import view.VoucherApplied;
import view.VoucherExpired;
import view.VoucherUsed;
import view.WrongPassword;

public class PopUpController {

	private static PopUpController popupController;
	
	public static PopUpController getInstance() {
		if(popupController == null){
			return new PopUpController();
		} else{
			return popupController;
		}
	}
	
	public PopUpController() {
		
	}

	public ConfirmationFire confirm_fire(Integer EmployeeID) {
		return new ConfirmationFire(EmployeeID);
	}
	
	public ConfirmationDeleteProduct confirm_del_product(Integer ProductID) {
		return new ConfirmationDeleteProduct(ProductID);
	}
	
	public ConfirmationDeleteVoucher confirm_del_voucher(Integer VoucherID) {
		return new ConfirmationDeleteVoucher(VoucherID);
	}
	
	public ConfirmationResetPassword confirm_reset_pass(Integer EmployeeID) {
		return new ConfirmationResetPassword(EmployeeID);
	}
	
	public CheckMoneyAmount checkmoney() {
		return new CheckMoneyAmount();
	}
	
	public WrongPassword wrongpass() {
		return new WrongPassword();
	}
	
	public UsernameNotFound usernamenotfound() {
		return new UsernameNotFound();
	}
	
	public InactiveEmployee inactive() {
		return new InactiveEmployee();
	}
	
	public InsertSuccess insertsuccess() {
		return new InsertSuccess();
	}
	
	public UpdateSuccess updatesuccess() {
		return new UpdateSuccess();
	}
	
	public ResetSuccess resetpasssuccess(String password) {
		return new ResetSuccess(password);
	}
	
	public CheckoutSuccess checkoutsuccess(float Changes) {
		return new CheckoutSuccess(Changes);
	}
	
	public CartIsEmpty cartisempty() {
		return new CartIsEmpty();
	}
	
	public UsernameUsed usernameused() {
		return new UsernameUsed();
	}
	
	public FireSuccess fired() {
		return new FireSuccess();
	}
	
	public DeleteVoucherSuccess voucherdel() {
		return new DeleteVoucherSuccess();
	}
	
	public VoucherUsed voucheralreadyused() {
		return new VoucherUsed();
	}
	
	public VoucherApplied voucherapplied() {
		return new VoucherApplied();
	}
	
	public VoucherExpired voucherexpired() {
		return new VoucherExpired();
	}
	
	public DeleteProductSuccess productdel() {
		return new DeleteProductSuccess();
	}	
	
	public NotValidRole notvalidrole() {
		return new NotValidRole();
	}
	
	public NotValidPrice notvalidprice() {
		return new NotValidPrice();
	}
	
	public CheckQuantity checkquantity() {
		return new CheckQuantity();
	}
	
	public NameCannotEmpty namecannotbeempty() {
		return new NameCannotEmpty();
	}
	
	public DescriptionLong desctoolong() {
		return new DescriptionLong();
	}
	
	public NotValidStock notvalidstock() {
		return new NotValidStock();
	}
	
	public NotValidDiscount notvaliddisc() {
		return new NotValidDiscount();
	}
	
	public DateMustLess mustlessdate() {
		return new DateMustLess();
	}
	
	public DateMustMore mustmoredate() {
		return new DateMustMore();
	}
	
	public SalaryMustMore mustmoresalary() {
		return new SalaryMustMore();
	}
	
	public IDNotFound idnotfound() {
		return new IDNotFound();
	}
	
}
