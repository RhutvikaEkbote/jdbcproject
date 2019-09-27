package jdbc;
import java.sql.*;
import java.util.*;
public class TestjdbcApplication {

	public static void main(String[] args) {
		int i=0;
		Scanner sc=new Scanner(System.in);
		PreparedStatement ps=null;
		Statement stat;
		ResultSet rs=null;
		try {
			int ch;
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456789");
			System.out.println("connection established....."+con);
			System.out.println("\n1-insert\n2-delete\n3-search\n4-display");
			System.out.println("enter choice--");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				ps=con.prepareStatement("insert into xyz values (?,?,?)");
				ps.setInt(1, 5);
				ps.setString(2, "rinku");
				ps.setFloat(3, 89.89f);
				i=ps.executeUpdate();
				if(i>0) {
					System.out.println("record inserted");

				}else {System.out.println("not inserted");}
				break;

			case 2:
				System.out.println("enter id no to delete");
				int no=sc.nextInt();
				ps=con.prepareStatement("delete from xyz where id=?");
				ps.setInt(1,no);
				i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println("record deleted");
				}
				else 
				{
					System.out.println("record not deleted");
				}
				break;
			case 3:
				System.out.println("Enter the no to search: ");
				no=sc.nextInt();
				ps=con.prepareStatement("select * from xyz where id=?");
				ps.setInt(1, no);
				rs=ps.executeQuery();
				rs.next();
				int id=rs.getInt(1);
				String name=rs.getString(2);
				float per=rs.getFloat(3);
				System.out.println(id+"\t"+name+"\t"+per);
				break;
			case 4:
				stat=con.createStatement();
				String str="select * from xyz";
				ResultSet rs1=stat.executeQuery(str);
				ResultSetMetaData rsmd=rs1.getMetaData();
				for(i=1;i<=rsmd.getColumnCount();i++)
				{
					System.out.print(rsmd.getColumnName(i)+"\t");
				}
				System.out.println("\n============================================================\n");
				while (rs1.next())
				{
					System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3));
				}
				break;
		
			}	}	
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
