
public class BookBasic
{
	private String bname;
	private String aname;
	
	public BookBasic(String bookname, String authorname)
	{
		bname = bookname;
		aname = authorname;
	}
	
	public void setbookname(String bookname)
	{
		bname = bookname;
	}
	
	public void setauthorname(String authorname)
	{
		aname = authorname;
	}
	
	public String getbookname()
	{
		return bname;
	}
	
	public String getauthorname()
	{
		return aname;
	}
}