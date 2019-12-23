package SgSuperStore.app;

import java.awt.*;
import java.io.*;
import java.util.*;
public class DataBase {
	public static ArrayList<CargoItem> data = new ArrayList<CargoItem>();
	static {
		FileReader reader = null;
		try {
			reader = new FileReader("cargoes.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		String str = null;
		try {
			while ((str = br.readLine()) != null) {
				String[] s = str.split(",");
				data.add(new CargoItem(s[0], s[1], Double.parseDouble(s[2]), s[3]));
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	static {
		if(data.size()!=data.size()){
			FileWriter write = null;
			try {
				write = new FileWriter("cargoes.txt",true);
				BufferedWriter bw=new BufferedWriter(write);
				String[][] tbody=new String[data.size()][4];
				for(int i=0;i<data.size();i++) {
					CargoItem cargoItem=data.get(i);
					tbody[i][0]=cargoItem.getNumber()+",";
					tbody[i][1]=cargoItem.getName()+",";
					tbody[i][2]=cargoItem.getPrice()+",";
					tbody[i][3]=cargoItem.getUnit();
				}	
				bw.write(String.valueOf(tbody));
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}

	}
	
}
