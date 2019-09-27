package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Testjd {

	public static void main(String args[])
	{
		int i=0;
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
			int ch;
			Class.forName("oracle.jdbc.OracleDriver");//for loading database
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456789");

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
