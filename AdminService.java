package SgSuperStore.app;
import java.util.ArrayList;
public class AdminService {
	private AdminDao adminDao = new AdminDao();

	public ArrayList<CargoItem> queryCargoItem() {
		ArrayList<CargoItem> data = adminDao.queryAllData();
		return data;
	}

	public boolean addCargoItem(String number, String name, String price, String unit) {
		ArrayList<CargoItem> data = queryCargoItem();
		for (int i = 0; i < data.size(); i++) {
			CargoItem cargoItem = data.get(i);
			if (number.equals(cargoItem.getNumber())) {
				return false;
			}
		}
		CargoItem thisCargoItem = new CargoItem(number, name, Double.parseDouble(price), unit);
		adminDao.addCargoItem(thisCargoItem);
		return true;
	}

	public boolean updateCargoItem(String number, String name, String price, String unit) {
		ArrayList<CargoItem> data = queryCargoItem();
		for (int i = 0; i < data.size(); i++) {
			CargoItem cargoItem = data.get(i);
			if (number.equals(cargoItem.getNumber())) {
				adminDao.delCargoItem(number);
				CargoItem thisCargoItem = new CargoItem(number, name, Double.parseDouble(price), unit);
				adminDao.addCargoItem(thisCargoItem);
				return true;
			}
		}
		return false;
	}

	public boolean delCargoItem(String delNumber) {
		ArrayList<CargoItem> data = queryCargoItem();
		for (int i = 0; i < data.size(); i++) {
			CargoItem cargoItem = data.get(i);
			if (delNumber.equals(cargoItem.getNumber())) {
				adminDao.delCargoItem(delNumber);
				return true;
			}
		}
		return false;
	}

}
