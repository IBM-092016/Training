package day8.module7;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements Serializable {
	private Map<String, Integer> mItemQuantityMap = new HashMap<>();

	public void addItem(String pItem) {
		if (mItemQuantityMap.containsKey(pItem)) {
			int currentQuantity = mItemQuantityMap.get(pItem);
			mItemQuantityMap.put(pItem, currentQuantity + 1);
		} else {
			mItemQuantityMap.put(pItem, 1);
		}
	}
	
	public void removeItem(String pItem) {
		if (mItemQuantityMap.containsKey(pItem)) {
			int currentQuantity = mItemQuantityMap.get(pItem);
			if(currentQuantity == 1) {
				mItemQuantityMap.remove(pItem);
			} else {
				mItemQuantityMap.put(pItem, currentQuantity - 1);
			}
		}
	}
	
	public String getCartHTML() {
		if(mItemQuantityMap.isEmpty()) {
			return "<B>Empty item cart</B>";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<TABLE><TR><TH>Item</TH><TH>Quantity</TH></TR>\n");
		for(Map.Entry<String, Integer> e : mItemQuantityMap.entrySet()) {
			sb.append("<TR><TD>").append(e.getKey()).append("</TD><TD>").append(e.getValue()).append("</TD></TR>\n");
		}
		sb.append("</TABLE>");
		return sb.toString();
	}
}
