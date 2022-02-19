import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

	

    String src = "";
    for(String key : map.keySet()){
        
        boolean ans = false;
        for(String a : map.keySet()){
            if(map.get(a).equals(key)){
                ans = true;
                break;
            }
        }
        
        if(ans == false){
            src = key;
            break;
        }
    }
    
    String ans = src;
    
    while(map.containsKey(src)){
        ans = ans + " -> " + map.get(src);
        src = map.get(src);
	}
	
	System.out.println(ans + ".");
	
}
}
