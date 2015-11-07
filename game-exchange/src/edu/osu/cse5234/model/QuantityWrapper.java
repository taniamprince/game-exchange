package edu.osu.cse5234.model;

import java.util.ArrayList;
import java.util.List;

public class QuantityWrapper implements java.io.Serializable {
		
		public List<Integer> quantity;

		public QuantityWrapper() {
			quantity = new ArrayList<Integer>();

			
	    }
		
		
	    public void setQuantity(List<Integer> orderList) {
	        this.quantity = orderList;
	    }
		
		public List<Integer> getQuantity(){
			return quantity;
		}
		
		
}
