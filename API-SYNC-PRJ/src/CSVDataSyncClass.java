import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.opencsv.CSVReader;

public class CSVDataSyncClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:oracle:thin:@devplace.co.kr:1521:REDSOFT";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int fileNum = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver load 성공!");
			conn = DriverManager.getConnection(url, "REDTEST", "REDTEST123");
			System.out.println("DB 연결 성공!");
			
			psmt = conn.prepareStatement("DELETE FROM TBL_FSHLC");
			psmt.execute();
			
			
			String sql = "INSERT INTO TBL_FSHLC ("
					+ "FSHLC_NM,"
					+ "FSHLC_TYPE,"
					+ "RDNMADR,"
					+ "LNMADR,"
					+ "LATITUDE,"
					+ "LONGITUDE,"
					+ "FSHLC_PHONE_NUMBER,"
					+ "WATER_AR,"
					+ "KDFSH,"
					+ "ACEPTNC_CO,"
					+ "WTRC_FCLTY_TYPE,"
					+ "USE_CHARGE,"
					+ "MAIN_POINT,"
					+ "SAFENTL,"
					+ "CVNTL,"
					+ "CFR_TRRSRT,"
					+ "PHONE_NUMBER,"
					+ "INSTITUTION_NM,"
					+ "REFERENCE_DATE"
					+ ") VALUES (?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?,?,?)";
			
			
			psmt =  conn.prepareStatement(sql); 
			
			
			for (fileNum = 0; fileNum<41; fileNum++) {
				
				//CSV DATA 읽기
				CSVReader reader = new CSVReader(new FileReader("D:/dev/projects/APT-TRANS/attach/upload/"+fileNum+".csv"));
				String[] nextLine;
				
				int cnt = 0;
				
				while ((nextLine = reader.readNext()) != null) {
					if(cnt != 0) {
						for (int i = 0; i< nextLine.length; i++) {
							
							String value = nextLine[i]==null || "".equals(nextLine[i]) ? "":nextLine[i];
							psmt.setString(i+1, value);
							System.out.println("value="+value);
						}
						psmt.execute();
					}
					cnt++;
				}
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver load 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
			System.out.println(fileNum);
		} catch(Exception e1){
			e1.printStackTrace();
		}finally {
			
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
