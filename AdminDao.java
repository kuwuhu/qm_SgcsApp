package SgSuperStore.app;
import java.util.ArrayList;
public class AdminDao {
	public ArrayList<CargoItem> queryAllData(){
		return DataBase.data;
	}
	public void addCargoItem(CargoItem fruitItem) {
		DataBase.data.add(fruitItem);
	}
	
    public void delCargoItem(String delNumber) {
    	for(int i=0;i<DataBase.data.size();i++) {
    		CargoItem thisFruitItem=DataBase.data.get(i);
    		if(thisFruitItem.getNumber().equals(delNumber)) {
    			DataBase.data.remove(i);
    		}
    	}
    }
}
