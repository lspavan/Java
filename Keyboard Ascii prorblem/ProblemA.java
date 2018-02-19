/**
 * 
 */
/**
 * @author PAVAN
 *
 */

package easy;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemA {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		String input=sc.nextLine();
		System.out.println("Input string is:::"+input);
		
		HashMap<String, String> map = new HashMap<String,String>();		
		map.put("a","@");
		map.put("b","8");
		map.put("c","(");
		map.put("d","|)");
		map.put("e","3");
		map.put("f","#");
		map.put("g","6");
		map.put("h","[-]");
		map.put("i","|");
		map.put("j","_|");
		map.put("k","|<");
		map.put("l","1");
		map.put("m","[]"+"\\\\"+"/"+"[]");
		map.put("n","[]\\\\[]");
		map.put("o","0");
		map.put("p","|D");
		map.put("q","(,)");
		map.put("r","|Z");
		map.put("s","\\$");
		map.put("t","']['");
		map.put("u","|_|");
		map.put("v","\\\\"+"/");
		map.put("w","\\\\"+"/"+"\\\\"+"/");
		map.put("x","}{");
		map.put("y","`/");
		map.put("z","2");
	
		input=input.toLowerCase();
		Pattern p = Pattern.compile("[abcdefghijklmnopqrstuvwxyz]");		
		Matcher m = p.matcher(input);
		StringBuffer sb = new StringBuffer();
		while (m.find()){
		    m.appendReplacement(sb, map.get(m.group()));
		}
		m.appendTail(sb);

		System.out.println(sb);
        
        sc.close();
	}

}
