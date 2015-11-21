package edu.osu.cse5234.model;

import java.util.ArrayList;
import java.util.List;

public class QuantityWrapper implements java.io.Serializable {
		
		public List<String> quantity;

		public QuantityWrapper() {
			quantity = new ArrayList<String>();

			
	    }
		
		
	    public void setQuantity(List<String> orderList) {
	        this.quantity = orderList;
	    }
		
		public List<String> getQuantity(){
			return quantity;
		}
		
		
}
