package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import model.VoucherModel;
import view.ViewPM;

public class PMController {

	private static PMController pmController;
	private VoucherModel voucher = new VoucherModel();
	
	public static PMController getInstance(){
		if(pmController == null){
			return new PMController();
		} else{
			return pmController;
		}
	}
	
	public ViewPM view(){
		return new ViewPM();
	}
	
	public void addVoucher(float Discount, String ValidDate){
		
		//String NowDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		//int foo = Integer.parseInt(timeStamp);
		
		//if(ValidDate < timeStamp) {
		//	System.out.println("Valid Date must more than Now Date"); //CONSOLE
		//} else{
		String Status = "NotUsed";
		voucher.addVoucher(Discount, ValidDate, Status);
		System.out.println("Insert Success"); //CONSOLE
		//}
	}
	
	public void updateVoucher(Integer VoucherID, float Discount, String ValidDate){	
		voucher.updateVoucher(VoucherID, Discount, ValidDate);
		System.out.println("Update Success"); //CONSOLE
	}
	
	public void deleteVoucher(Integer VoucherID){	
		voucher.deleteVoucher(VoucherID);
		System.out.println("Delete Success"); //CONSOLE
	}
	
	public Vector<VoucherModel> getAllVoucher(){
		return voucher.getAllVoucher();
	}
}
