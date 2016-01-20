import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Solution 
{

	public static void main(String[] args) throws Exception 
	{
		//Number of elements
		int numberOfElement ;

		//declare object to read a file
		BufferedReader br = new BufferedReader(new FileReader("input"));
		
		//read file
		numberOfElement = Integer.parseInt(br.readLine());
		
		
		//Declare arrays
		int elements[] = new int[numberOfElement + 1];
		boolean check[] = new boolean[numberOfElement + 1];
		int ch[] = new int[numberOfElement + 1];
		
		
		//read file
		String tmp = br.readLine(); 
		String ele[] = tmp.split(" ");
		
		
		//Initialize array
		for (int i = 1; i <= numberOfElement ; i++) 
		{
			elements[i] = Integer.parseInt(ele[i - 1]);
			check[i] =true;
		}
		
		String tmp1 = br.readLine(); 
		String elements1[] = tmp1.split(" ");
		
		
		int P =Integer.parseInt( elements1[0] );
		int Q = Integer.parseInt(elements1[1] );
		

		
		long startTime = System.currentTimeMillis();
		

//Logic starts from here
		
		int max = 0;
		int answer = 0 ;
		boolean first = true;
		int incrementJ  = 1;
		int currentI = P;
		
		//sort the array
		Arrays.sort(elements);
		
		for (int i = P; i <= Q; i++)
		{
			int min = 1000000000; 
			
			for (int j = incrementJ; j <= numberOfElement; j++) 
			{
				if(elements[j] == i)
				{
					min = 0;
					incrementJ++;
					currentI =i ;
					break;
				}
				else if(i < elements[j])
				{
					if(j == 1)
					{
						min = Math.abs(elements[j] - i);
						i = elements[j];
						currentI = i;
						break;
					}
					else
					{
						if(elements[j - 1] <=  i &&  i <= elements[j])
						{
							if(check[j])
							{
								ch[j] = i +  ((elements[j] - elements[j - 1] )/ 2) ;
								check[j] = false;
							}
							
							if(i == ch[j] )
							{
								i = elements[j];
							}
							
							int t1 = Math.abs(elements[j] - i); 
							int t2  = Math.abs(elements[j - 1] - i); 
							if(t1 < t2)
							{
								min = t1;
								
							}
							else
							{
								min = t2;
							}
							currentI = i;
							break;
						}
					}
				}
				else
				{
					incrementJ++;
				}
			}
			
			if(min == 1000000000 )
			{
				min = Math.abs(elements[numberOfElement] - Q);
				
				if(first)
				{
					max = min;
					answer = P;
					first = false;
				}
				else
				{
					if(min > max)
					{
						max = min;
						answer = Q;
					}
				}
				break;
			}
			else
			{
				if(first)
				{
					max = min;
					answer = P;
					first = false;
				}
				else
				{
					if(min > max)
					{
						max = min;
						answer = currentI;
					}
				}
			}
		}

		System.out.println("Answer " +  answer);
		System.out.println();
		System.out.println();
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Time took " + totalTime);
	}
}


