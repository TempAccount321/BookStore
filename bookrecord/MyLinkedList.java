


public class MyLinkedList
{
	private Node head,tail;
	private int size;
	private int temp;
		
	public void add(Object data)
	{
		addEnd(data);
		size++;
	}
	
	public void addFront(Object data)
	{
		Node newNode = new Node(data,null);
		newNode.setNext(head);
		head = newNode;
	}
		
	public void addEnd(Object data)
	{
		if(isEmpty()){
			head = new Node(data,null);
			tail = head;
		}
		else{
			Node p = tail;
			tail = new Node(data,p.getNext());
			p.setNext(tail);
		}
	}
	
	public boolean remove(Object data)
	{
		boolean remove = false;
		Node p = head;
		Node prev = head;
		
		if(p.getData().equals(data)){
			head = p.getNext();
			p.setNext(null);
			remove = true;
		}
		else{
			while(p.getNext() != null){
				prev = p;
				p = p.getNext();
			
				if(p.getData().equals(data)){
					prev.setNext(p.getNext());
					p.setNext(null);
			 		remove = true;
				}
			}
		}
		System.gc();
		return remove;
	}
	
	public Object getFirst()
	{
		return head.getData();
	}
	
	public Object getLast()
	{
		return tail.getData();
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		Node p = head;
		
		while(p != null)
		{
			sb.append(p.getData());
			p = p.getNext();
			if(p != null)
			{
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		MyLinkedList linklist = new MyLinkedList();
		StringBuffer sb = new StringBuffer();
		
		linklist.add("adsf");
		linklist.add("02938");
		linklist.add("asdfasdf");
		System.out.println(linklist);
	}
}