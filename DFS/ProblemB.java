package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ProblemB {

	public static void main(String[] args){
		BufferedReader   stdin=new BufferedReader(new InputStreamReader(System.in));
		
		try{		
			String line;        
			String result="";			
			char mc=0;
			char nc=0;
			int testCaseCount=1;
			int mValue=0;
			int nValue=0;		
			ArrayList<Integer> x=new ArrayList<Integer>();
			ArrayList<Integer> y=new ArrayList<Integer>();

			while ( !(line=stdin.readLine()).equals("")) {
				mc=line.charAt(0);
				nc=line.charAt(2);
				mValue = Integer.parseInt(String.valueOf(mc));
				nValue = Integer.parseInt(String.valueOf(nc));

				for(int i=0;i<nValue;i++)
				{
					line=stdin.readLine();
					char xm=line.charAt(0);
					char xn=line.charAt(2);
					x.add(i, Integer.parseInt(String.valueOf(xm)));
					y.add(i, Integer.parseInt(String.valueOf(xn)));
				}

				if(testCaseCount<6){						
					result=checkLogic(mValue,nValue,x,y);
					System.out.println("case "+testCaseCount+": "+result);
					testCaseCount++;					
				}
				if(!stdin.ready()){
					stdin.close();
					System.exit(0);
				}
			}
			stdin.close();
			System.exit(0);
		}catch(Exception e){

		}
		System.exit(0);
	}







	public static String checkLogic(int m,int n,List<Integer> x,List<Integer> y){
		List<Integer>  u=new ArrayList<Integer>();
		List<Integer> v=new ArrayList<Integer>();
		int a=0;		
		int end=(m*(m-1))/2;
		String result="";
		String invalidResult="";
		boolean check2=false;
				
		ListIterator<Integer> itrdup1=x.listIterator();
		ListIterator<Integer> itrdup2=y.listIterator();
		String dupp[]=new String[n];		
		
		try{
		for(int dup=0;itrdup1.hasNext() && dup<dupp.length;dup++){
		dupp[dup]=(itrdup1.next().toString()+itrdup2.next().toString()).trim();
		}
				

		Set<String> dupes = new HashSet<String>();
		for (String dup : dupp) 
		{ if (!dupes.add(dup))
		{
		check2=true;
		break;
		}
		}
	
		if(n<=end ){
			int i=0,j=1;
			while(i<n && j<=n){					

				if((j==n && m<n)|| j==n){
					if((j==n && m> n))
						j=j++;	
					else
						j=0;
				}
				u.add(a,i);
				v.add(a,j);

				i++;
				j++;
				a++;
			}

		}else{			
			result= "invalid";
		}

		}catch(Exception e){			
		}
		
		
		
		
		
		
		ListIterator<Integer> itrc1=x.listIterator();
		ListIterator<Integer> itrc2=y.listIterator();
		ListIterator<Integer> itrd1=x.listIterator();
		ListIterator<Integer> itrd2=y.listIterator();
		int first,second;
		boolean check1=false;
		
		while(itrc1.hasNext() && itrd1.hasNext()){

			try{
				String one;
				String two;
				String three;
				String four;				
				
				for(int t=0;itrc1.hasNext();t++){
					one=(itrc1.next()).toString();
					two=(itrc2.next()).toString();
					
					for(int t1=0;itrd1.hasNext();t1++){
						three=(itrd1.next()).toString();
						four=(itrd2.next()).toString();						

						if((one+two).equals(four+three)){
							check1=true;						 
						}					
					}					
				}
			}catch(Exception e){}
		}

		//order maintaining valid check
		ListIterator<Integer> match1=x.listIterator();
		ListIterator<Integer> match2=y.listIterator();
		ListIterator<Integer> match3=u.listIterator(); 
		ListIterator<Integer> match4=v.listIterator();  
		
		String matchx[]=new String[n];	
		String matchy[]=new String[n];
		
		
		
		for(int mat=0;match1.hasNext() && mat<matchx.length;mat++){
			matchx[mat]=(match1.next().toString()+match2.next().toString()).trim();
			matchy[mat]=(match3.next().toString()+match4.next().toString()).trim();
		}
		
		Arrays.sort(matchx);
		
		for(int ck=0;ck<matchy.length;ck++){
			//System.out.println("matchx"+matchx[ck]+" "+matchy[ck]);
		}
		
		boolean results= Arrays.equals(matchx, matchy);
		//System.out.println("order of sucess check "+results);
		
		
		


		ListIterator<Integer> itr=x.listIterator();
		ListIterator<Integer> itr1=y.listIterator();
		ListIterator<Integer> itr2=u.listIterator(); 
		ListIterator<Integer> itr4=v.listIterator();  
		int third,fourth;


		while(itr.hasNext() && itr1.hasNext()){	
			try{					
								
				first=(int)itr.next();
				second=(int)itr1.next();
				third=(int)itr2.next();
				fourth=(int)itr4.next();				
				int rowCount=0;	
				if(first==third && second==fourth){					
					result="valid";					
				}			
				
				else if(first==fourth && second==third){
					if(rowCount==0){						
						invalidResult=invalidResult+first+" "+second+" ,";
					}
					if(invalidResult.contains(",")){
						invalidResult=invalidResult.substring(0, 4);
						rowCount++;
					}

				}else{					
					result="invalid";
				}
				
				
			}catch(Exception e){
			}
		}			

		
		if(results){
		return result="valid";
		}
		else if(check1 || check2){			
			return result="invalid";
		} else if(!invalidResult.equals("")){
			return invalidResult;
		}
		else if(invalidResult.equals("")){
			return result;
		}else{			
			return result;
		}


	}

}
