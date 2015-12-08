import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InventoryUpdater {

	public static void main(String[] args) {
		System.out.println("Starting Inventory Update ...");
		try{
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds,conn);
			updateInventory(orderedItems,conn);
			updateOrderStatus(newOrderIds,conn);
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	private static Connection createConnection() throws SQLException, ClassNotFoundException{
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:C:\\workspace\\data\\game-exchange-db","sa","");
		return conn;
	}
	
	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException{
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rset = conn.createStatement().executeQuery("select ID from CUSTOMER_ORDER where STATUS = 'Pending'");
		while(rset.next()){
			orderIds.add(new Integer(rset.getInt("ID")));
		}
		return orderIds;
		
	}
	
	// This method returns a map of two integers. The first Integer is item ID, and 
    // the second is cumulative requested quantity across all new orders
	private static Map<Integer,Integer> getOrderedLineItems(Collection<Integer> newOrderIds, Connection conn) throws SQLException{
		Map<Integer,Integer> itemQuantity = new HashMap<Integer,Integer>();
		Iterator<Integer> iter = newOrderIds.iterator();
		while(iter.hasNext()){
			// Get order ID
			Integer orderId = iter.next();
			
			// Get all line items for that order
			ResultSet rset = conn.createStatement().executeQuery("select * from CUSTOMER_ORDER_LINE_ITEM where CUSTOMER_ORDER_ID_FK = "+ orderId);
			
			while(rset.next()){
				// Get the item ID
				int itemID = new Integer(rset.getInt("ITEM_ID"));
				
				// If the item ID doesn't exist in the quantity map then add it
				if (!itemQuantity.containsKey(itemID)){
					itemQuantity.put(new Integer(itemID), new Integer(rset.getInt("QUANTITY")));
				}
				else {
					// The item ID exists so update the quantity
					itemQuantity.put(new Integer(itemID), new Integer(itemQuantity.get(itemID) + rset.getInt("QUANTITY")));
				}
			}
		}	
		return itemQuantity;
	}
	
	private static void updateInventory(Map<Integer,Integer> orderedItems, Connection conn) throws SQLException{
		Iterator<Integer> iter = orderedItems.keySet().iterator();
		while(iter.hasNext()){
			int itemId = iter.next();
			int itemQuantity = orderedItems.get(itemId);
			System.out.println("Item quantity: " + itemQuantity);
			ResultSet rset = conn.createStatement().executeQuery("select * from ITEM where ID = "+ itemId);
			rset.next();
			int oldQuantity = (new Integer(rset.getInt("AVAILABLE_QUANTITY")));
			conn.createStatement().executeUpdate("UPDATE ITEM SET AVAILABLE_QUANTITY="+(oldQuantity - itemQuantity)+" WHERE ID="+ itemId);
		}
	}
	
	private static void updateOrderStatus(Collection<Integer> newOrderIds, Connection conn) throws SQLException{
		Iterator<Integer> iter = newOrderIds.iterator();
		while(iter.hasNext()){
			conn.createStatement().executeUpdate("UPDATE CUSTOMER_ORDER SET STATUS='Processed' WHERE ID="+ iter.next());
		}
		System.out.println("Update complete");
	}
	
}