package structural.adapter;

import java.util.List;

public class PrintableListAdapter implements PrintableList {

	@Override
	public void printList(List<String> pStringList) {
		StringBuilder sb = new StringBuilder("{");
		String sep = "";
		for(String s : pStringList) {
			sb.append(sep).append(s);
			sep = ",";
		}
		sb.append("}");
		PrintString ps = new PrintString();
		ps.print(sb.toString());
	}

}
