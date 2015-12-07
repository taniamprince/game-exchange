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
	
	private static Map<Integer,Integer> getOrderedLineItems(Collection<Integer> newOrderIds, Connection conn) throws SQLException{
		Map<Integer,Integer> itemQuantity = new HashMap<Integer,Integer>();
		Iterator<Integer> iter = newOrderIds.iterator();
		while(iter.hasNext()){
			Integer orderId = iter.next();
			ResultSet rset = conn.createStatement().executeQuery("select ID from CUSTOMER_ORDER_LINE_ITEM where CUSTOMER_ORDER_ID_FK = "+orderId);
			itemQuantity.put(new Integer(rset.getInt("ID")), new Integer(rset.getInt("QUANTITY")));
		}
		
		return itemQuantity;
	}
	
	private static void updateInventory(Map<Integer,Integer> orderedItems, Connection conn) throws SQLException{
		Iterator<Integer> iter = orderedItems.keySet().iterator();
		while(iter.hasNext()){
			int itemId = iter.next();
			int itemQuantity = orderedItems.get(itemId);
			ResultSet rset = conn.createStatement().executeQuery("select Quantity from Inventory where ID = "+ itemId);
			int oldQuantity = rset.getInt("QUANTITY");
			conn.createStatement().executeQuery("UPDATE INVENTORY SET QUANTITY="+(oldQuantity - itemQuantity)+" WHERE ID="+ itemId);
		}
	}
	
	private static void updateOrderStatus(Collection<Integer> newOrderIds, Connection conn) throws SQLException{
		Iterator<Integer> iter = newOrderIds.iterator();
		while(iter.hasNext()){
			conn.createStatement().executeQuery("UPDATE CUSTOMER_ORDER SET STATUS='Processed' WHERE ID="+ iter.next());
		}
	}
	
}