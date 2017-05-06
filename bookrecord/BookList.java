
 
import java.util.*;

public class BookList
{
	static Book book = null;
	static LinkedList list = null;
	static int record;
	
	public BookList()
	{}
		
	public BookList(Book book,LinkedList list)
	{
		this.book = book;
		this.list    = list;
	}
	
	public Book getbookList()
	{
		return book;
	}
	
	public void setRecord(int n)
	{
		record = n;
	}
	
	public int getRecord()
	{
		return record;
	}
	
	public LinkedList getList()
	{
		return list;
	}

	public static int getSize()
	{
		return list.size();
	}
}