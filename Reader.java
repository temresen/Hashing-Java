import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//-----------------------------------------------------
//Title: My tester class.
//Author: T.Emre Sen
//Description: This class reads the twitter file and hash the hashtags and
//finds the top 10 hashtags.
//-----------------------------------------------------
public class Reader {

	public static void main(String [] args) throws IOException
	{
		BufferedReader b = new BufferedReader(new FileReader("C:/Users/user/Desktop/twitter.txt"));
		Hash table = new Hash();
		ArrayList<String> contains = new ArrayList<String>();
		int count = 0;
		long baslangic = System.nanoTime();
		for(String list = b.readLine(); list != null; list = b.readLine())
		{
			String words[] = list.split(" ");
			count++;
			for(int i=0; i<words.length; i++){
				if(words[i].contains("#"))
				{
					table.put(words[i].substring(1).toLowerCase());				
				}
			}
		}
		long bitis = System.nanoTime(); 
		System.out.println("Time for Hash1:" + (bitis-baslangic)/1000);
		table.findTop10();
	}
}