package parser_sep;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Code {
	static TreeMap<Integer,String> byteCodeMap = new TreeMap<Integer,String>(); //MEG: not using HashMap as it has no ordering.
	static Map<String,Integer> temp_map = new HashMap<String,Integer>();

	static int ptr_var = 0;
	
	public static String operator_byteCode(char op_var) {
		switch(op_var) {
		case '*':  return "imul";
		case '/':  return "idiv";
		case '+' : return "iadd";
		case '-':  return "isub";
		default: return "";
		}
	}
	
	public static void tempMap_push(String id, int byteCode){
		temp_map.put(id, byteCode);
	}

	public static boolean tempMap_present(String id){
		return temp_map.containsKey(id);
	}

	public static Integer tempMap_retrieve(String id){
		return temp_map.get(id);
	}

	public static void byteCodeMap_push(String s) {
		byteCodeMap.put(ptr_var++, s); //because 'istore_' uses 1 byte
	}


	public static void output() {
		for (Integer key: byteCodeMap.keySet())
			System.out.println(key+": "+byteCodeMap.get(key));
	}
}