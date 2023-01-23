package assignment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class zomato_1 {
	public static void main(String[] args) {
		HashMap <Integer,String>h1 = new HashMap();
		h1.put(1, "naren");
		h1.put(2, "naveen");
		h1.put(3, "diwahar");
		h1.put(4, "loki");
		System.out.println(h1);
	//	h1.put(4, 44); //old value will be replaced by new value
		System.out.println(h1);
		System.out.println(h1.size());
		System.out.println(h1.isEmpty());
		System.out.println(h1.get(4));
		System.out.println(h1.remove(2));
		System.out.println(h1);
		System.out.println(h1.containsValue("diwahar"));
		System.out.println(h1.containsKey(3));
		System.out.println(h1.get(3));
		System.out.println(h1.keySet());
		System.out.println(h1.values());
		System.out.println(h1.entrySet());
		Set s3 = h1.keySet();
		for(Object var :s3) {
			System.out.println(var);
			
		}
		Collection c1= h1.values(); 
		for(Object var :c1) {
			System.out.println(var);
		}
		Set s1 = h1.entrySet();
		for(Object var : s1) {
			System.out.println(var);
		}
	}
	
}
