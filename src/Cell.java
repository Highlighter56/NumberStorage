package src;

import java.util.Map;

public class Cell implements Comparable<Cell>{
	
	private Map<Integer, Integer> adress;
	private String data;

	// --Constructors--
	// Default
	public Cell(Map<Integer, Integer> adress) {
		setData(null);
		setAdress(adress);
	}
	public Cell(Map<Integer, Integer> adress, String data) {
		setData(data);
		setAdress(adress);
	}
	
	
	// --Getters--
	public Map<Integer, Integer> getAdress() {
		return adress;
	}
	public String getData() {
		return data;
	}

	// --Setters--
	public void setAdress(Map<Integer, Integer> adress) {
		this.adress = adress;
	}
	public void setData(String data) {		// Need to add checks
		if (data.length()<=3)
			this.data = data;
		else {
			this.data = data.substring(data.length()-3);
		}
	}

	// --compareTo--
	public int compareTo(Cell cell) {
		return this.data.compareTo(data);
	}
	
	// --toString--
	public String toString() {
		if (data == null)
			return "   ";
		else if (data.length() == 1)
			return "  "+data;
		else if (data.length() == 2)
			return " "+data;
		return data;
	}

}
