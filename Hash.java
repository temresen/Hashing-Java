//-----------------------------------------------------
// Title: Hash Table Class
// Author: T.Emre Sen
// Description: This class describes hash table.
//-----------------------------------------------------
public class Hash {

	public int M = 9;
	public Node[] ht = new Node[M];

	public int hash(String key) {
		return (key.hashCode() & 0xff) % M;	
		//0x7fffffff	hash1
		//0x70000000	hash2
		//0xff			hash3
	}

	public void put(String key) {
		int i = hash(key);
		Node n = ht[i];
		while(n != null) {
			if(key.equals(n.getKey())) {
				n.increaseCount();
				return;
			}
			else {
				n = n.getNext();
			}
		}
		ht[i] = new Node(key, ht[i]);
	}

	public void findTop10() {
		String[] top10hashtag = new String[10];
		int[] top10hashtagcount = new int[10];
		for(int i = 0; i < 10; i++) {
			String yxl = "";
			int max = 0;
			for(int j = 0; j < ht.length; j++) {
				for(Node n = ht[j]; n != null; n = n.getNext()) {
					if(n.getCount() > max) {
						yxl = n.getKey();
						max = n.getCount();
					}
				}
			}
			top10hashtag[i] = yxl;
			top10hashtagcount[i] = max;
			for(Node n = ht[hash(yxl)]; n != null; n = n.getNext()) {
				if(n.getKey().equals(yxl)){
					n.setCount(0);
				}
			}
		}
		for(int i = 0; i < 10; i++) {
			System.out.println("#" + top10hashtag[i] + ": " + top10hashtagcount[i]);
		}
	}

	private class Node {
		private String key;
		private Node next;
		private int count;
		public Node(String key, Node next) {
			this.key = key;
			this.next = next;
			this.count = 1;
		}
		public int getCount()
		{
			return count;
		}
		public void increaseCount() 
		{
			count++;
		}
		public String getKey() 
		{
			return key;
		}
		public Node getNext()
		{
			return next;
		}
		public void setKey(String key)
		{
			this.key = key;
		}
		public void setNext(Node next) 
		{
			this.next = next;
		}
		public void setCount(int count) 
		{
			this.count = count;
		}
	}
}
