package SgSuperStore.app;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.*;

public class AdminDialogController extends AbstractAdminDialog{
	private AdminService adminService=new AdminService();
	public AdminDialogController() {
		super();
	}
	public AdminDialogController(Frame owner,boolean modal) {
		super(owner,modal);
		queryCargoItem();
	}
	@Override
	public void queryCargoItem() {
		String [] thead={"货物编号","货物名称","货物单价(/元)","计价单位"};
		ArrayList<CargoItem> dataList=adminService.queryCargoItem();
		String[][] tbody=list2Array(dataList);
		TableModel dataModel=new DefaultTableModel(tbody,thead);
		table.setModel(dataModel);
	}

	public String[][] list2Array(ArrayList<CargoItem> list) {
		String[][] tbody=new String[list.size()][4];
		for(int i=0;i<list.size();i++) {
			CargoItem cargoItem=list.get(i);
			tbody[i][0]=cargoItem.getNumber();
			tbody[i][1]=cargoItem.getName();
			tbody[i][2]=cargoItem.getPrice()+"";
			tbody[i][3]=cargoItem.getUnit();
		}
		return tbody;
	}
	public void addCargoItem() {
		String addNumber=addNumberText.getText();
		String addName=addNameText.getText();
		String addPrice=addPriceText.getText();
		String addUnit=addUnitText.getText();
		boolean addSuccess=adminService.addCargoItem(addNumber, addName, addPrice, addUnit);
		if(addSuccess) {
			queryCargoItem();
		}else {
			JOptionPane.showMessageDialog(this, "货物编号不能重复，请检查数据!");
		}
	}

	public void updateCargoItem() {
		ArrayList<CargoItem> flush = new ArrayList<CargoItem>();
		String updateNumber=updateNumberText.getText();
		String updateName=updateNameText.getText();
		String updatePrice=updatePriceText.getText();
		String updateUnit=updateUnitText.getText();
		boolean updateSuccess=adminService.updateCargoItem(updateNumber,updateName, updatePrice, updateUnit);
		if(updateSuccess) {
			queryCargoItem();
		}else {
			JOptionPane.showMessageDialog(this, "没有这个编号的货物,请检查数据!");
		}
		
	}

	public void delCargoItem() {
		String delNumber=delNumberText.getText();
		boolean delSuccess=adminService.delCargoItem(delNumber);
		if(delSuccess) {
			queryCargoItem();
		}else {
			JOptionPane.showMessageDialog(this, "没有这个编号的货物,请检查数据!");
		}
	}
	
}
