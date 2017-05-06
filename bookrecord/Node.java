
public class Node
{
	private Object data;
	private Node next;
	
	public Node()
	{
		data = null;
		next = null;
	}
	
	public Node(Object data)
	{
		this.data = data;
	}
	
	public Node(Object data,Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public Object getData()
	{
		return data;
	}
}