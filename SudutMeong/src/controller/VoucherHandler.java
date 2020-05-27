package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import model.VoucherModel;
import view.ViewPM;

public class VoucherHandler {

	private static VoucherHandler voucherHandler;
	private VoucherModel voucher = new VoucherModel();
	
	public static VoucherHandler getInstance(){
		if(voucherHandler == null){
			return new VoucherHandler();
		} else{
			return voucherHandler;
		}
	}
	
	public ViewPM view(){
		return new ViewPM();
	}
	
	public void addVoucher(float Discount, String ValidDate) throws ParseException{

		Vector<Integer> VouID = new Vector<Integer>();
		VouID = VoucherHandler.getInstance().getAllVoucherId();
		Integer lastid = VouID.lastElement()+1;
		
		String Status = "NotUsed";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date ValidDa = dateFormat.parse(ValidDate);  
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Date today_withouttime = formatter.parse(formatter.format(today));
		
		if(ValidDa.before(today_withouttime)) {
			PopUpController.getInstance().mustmoredate();
		}if(Discount<1 || Discount>100) {
			PopUpController.getInstance().notvaliddisc();
		}else if((Discount>0 && Discount<101) && (ValidDa.after(today_withouttime))) {
			voucher.addVoucher(Discount, ValidDate, Status, lastid);
			PopUpController.getInstance().insertsuccess();
		}
	}
	
	public void updateVoucher(Integer VoucherID, float Discount, String ValidDate) throws ParseException{	
		
		Vector<Integer> VouID = new Vector<Integer>();
		VouID = VoucherHandler.getInstance().getAllVoucherId();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date ValidDa = dateFormat.parse(ValidDate);  
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Date today_withouttime = formatter.parse(formatter.format(today));
		
		if(VouID.contains(VoucherID) != true) {
			PopUpController.getInstance().idnotfound();
		}else if(VouID.contains(VoucherID)){
			if(ValidDa.before(today_withouttime)) {
				PopUpController.getInstance().mustmoredate();
			}if(Discount<1 || Discount>100) {
				PopUpController.getInstance().notvaliddisc();
			}else if(VouID.contains(VoucherID) && (ValidDa.after(today_withouttime))) {
				voucher.updateVoucher(VoucherID, Discount, ValidDate);
				PopUpController.getInstance().updatesuccess();
			}
		}
	}
	
	public void deleteVoucher(Integer VoucherID){	
		Vector<Integer> VouID = new Vector<Integer>();
		VouID = VoucherHandler.getInstance().getAllVoucherId();
		
		if(VouID.contains(VoucherID) != true) {
			PopUpController.getInstance().idnotfound();
		}else if(VouID.contains(VoucherID)){
			voucher.deleteVoucher(VoucherID);
			PopUpController.getInstance().voucherdel();
		}
	}
	
	public Vector<VoucherModel> getAllVoucher(){
		return voucher.getAllVoucher();
	}
	
	public Vector<Integer> getAllVoucherId(){
		return voucher.getAllVoucherId();
	}
}
