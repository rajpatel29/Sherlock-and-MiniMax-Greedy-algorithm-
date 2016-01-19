import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution 
{

	public static void main(String[] args) throws Exception 
	{
		
		int lengthOfArray ;
		
		
		BufferedReader br = new BufferedReader(new FileReader("input"));
		
		
		lengthOfArray = Integer.parseInt(br.readLine());
		
		
		int array[] = new int[lengthOfArray + 1];
		boolean check[] = new boolean[lengthOfArray + 1];
		
		String tmp = br.readLine(); 
		String elements[] = tmp.split(" ");
		
		
		for (int i = 1; i <= lengthOfArray ; i++) 
		{
			array[i] = Integer.parseInt(elements[i - 1]);
			check[i] =true;
		}
		
		String tmp1 = br.readLine(); 
		String elements1[] = tmp1.split(" ");
		
		int p =Integer.parseInt( elements1[0] );
		
		int q = Integer.parseInt(elements1[1] );
		
		
		long startTime = System.currentTimeMillis();
		
		Arrays.sort(array);
		
		
		
		
		int x= 0;
		int result = 0;
		int answer = 0 ;
		boolean first = true;
		boolean allGreater = false;
		
		int r  = 1;
		
		int count = 0;
		int e = p;
		
		
		for (int i = p; i <= q; i++)
		{
			int min = 1000000000; 
			int map;
			int c = 0;
			for (int j = r; j <= lengthOfArray; j++) 
			{
				
				System.out.println("i " + i + " array : " + array[j]);
				
				count++;
				
				c = j;
		
				
				if(array[j] == i)
				{
					
					System.out.println("1");
					min = 0;
					r++;
					e =i ;
					break;
				}
				else if(i < array[j])
				{
					if(j == 1)
					{
						System.out.println("2");
						min = Math.abs(array[j] - i);
//						i = array[j];
						e = i;
						break;
					}
					else
					{
						if(array[j - 1] <=  i &&  i <= array[j])
						{
							System.out.println("3");
							
							int t1 = Math.abs(array[j] - i); 
							int t2  = Math.abs(array[j - 1] - i); 
							if(t1 < t2)
							{
								min = t1;
								
							}else
							{
								min = t2;
							}
							if(check[j])
							{
								i = i +  ((array[j] - array[j - 1] )/ 2)- 2 ;
								check[j] = false;
							}
							e = i;
							
							System.out.println("i : " + i + " j " + j);
							break;
							}
					}
				}
				else
				{
					System.out.println("4");
					r++;
				}
			}
			
			if(min == 1000000000 )
			{
				min = Math.abs(array[lengthOfArray] - q);
				allGreater = true;
//				System.out.println("these many times :"  + i);
//				i = q-2;
				
				map = min;
				
				if(first)
				{
					result = map;
					answer = p;
					first = false;
				}
				else
				{
					if(map > result)
					{
						result = map;
						answer = q;
					}
				}
				
				break;
			}
			else
			{
				map = min;
				
				if(first)
				{
					result = map;
					answer = p;
					first = false;
				}
				else
				{
					if(map > result)
					{
						result = map;
						answer = e;
						
					}
				}
				
				
			}
			
		}
		
	System.out.println("count : " + count);
		
		

		/*
			if(array[j] <=  i &&  i <= array[j + 1] )
					{
						int t1 = Math.abs(array[j] - i); 
						int t2  = Math.abs(array[j + 1] - i); 
						if(t1 < t2)
						{
							min = t1;
							
						}else
						{
							min = t2;
						}
						break;
					}
					else
					{
						min = Math.abs(array[j] - i);
						break;
					}		
		 */
				
				
/*					
					if(array[j - 1] <=  i &&  i <= array[j])
					{
						int t1 = Math.abs(array[j] - i); 
						int t2  = Math.abs(array[j - 1] - i); 
						if(t1 < t2)
						{
							min = t1;
							
						}else
						{
							min = t2;
						}
						break;
					}
*/					
				
				
		
		
/*		
		int map ;
		
		int result = 0;
		int answer = 0 ;
		boolean first = true;
		
		int r = 1;
		for (int i = p; i <= q; i++) 
		{
			int min =1000000000;
			
			for (int j = r; j <= lengthOfArray; j++) 
			{
				int tm = Math.abs(array[j] - i);
				
				if(array[j] < p)
				{
					r = j;
				}
				
				
				if(min > tm)
				{
					min = tm;
				}
				if(min == 0)
				{
					break;
				}
			}
			map = min;
			
			if(first)
			{
				result = map;
				answer = i;
				first = false;
			}
			else
			{
				if(map > result)
				{
					result = map;
					answer = i;
				}
			}
					
		}
		
		System.out.println( answer);
		
*/
		
		
		
		System.out.println("Answer " +  answer);
		System.out.println();
		System.out.println();
		System.out.println();
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Time took " + totalTime);
	}
}


