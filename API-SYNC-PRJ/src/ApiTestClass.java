import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_fshlc_api"); /*URL*/
	        try {
//				urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZgO5bqT7X4YEb%2BqGO3hVuffwH2QQIcJ9NUsx%2BqiuOh5kP%2FtScXyV0j0NNf%2FVp8rC0ZO1JlOgdIwpcmxF8iEw%2FQ%3D%3D");
				urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZgO5bqT7X4YEb+qGO3hVuffwH2QQIcJ9NUsx+qiuOh5kP/tScXyV0j0NNf/Vp8rC0ZO1JlOgdIwpcmxF8iEw/Q==");
				
				
				urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("0", "UTF-8")); /*������ ��ȣ*/
				urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*�� ������ ��� ��*/
				urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*XML/JSON ����*/
				
				
				urlBuilder.append("&" + URLEncoder.encode("fshlcNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�����͸�*/
				urlBuilder.append("&" + URLEncoder.encode("fshlcType","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*����������*/
				urlBuilder.append("&" + URLEncoder.encode("rdnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���������θ��ּ�*/
				urlBuilder.append("&" + URLEncoder.encode("lnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�����������ּ�*/
				urlBuilder.append("&" + URLEncoder.encode("latitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*����*/
				urlBuilder.append("&" + URLEncoder.encode("longitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�浵*/
				urlBuilder.append("&" + URLEncoder.encode("fshlcPhoneNumber","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*��������ȭ��ȣ*/
				urlBuilder.append("&" + URLEncoder.encode("waterAr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*������*/
				urlBuilder.append("&" + URLEncoder.encode("kdfsh","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�ֿ����*/
				urlBuilder.append("&" + URLEncoder.encode("aceptncCo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�ִ�����ο�*/
				urlBuilder.append("&" + URLEncoder.encode("wtrcFcltyType","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*����ü�������*/
				urlBuilder.append("&" + URLEncoder.encode("useCharge","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�̿���*/
				urlBuilder.append("&" + URLEncoder.encode("mainPoint","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�ֿ�����Ʈ*/
				urlBuilder.append("&" + URLEncoder.encode("safentl","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�����ü���Ȳ*/
				urlBuilder.append("&" + URLEncoder.encode("cvntl","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���ͽü���Ȳ*/
				urlBuilder.append("&" + URLEncoder.encode("cfrTrrsrt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�ֺ�������*/
				urlBuilder.append("&" + URLEncoder.encode("phoneNumber","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���������ȭ��ȣ*/
				urlBuilder.append("&" + URLEncoder.encode("institutionNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���������*/
				urlBuilder.append("&" + URLEncoder.encode("referenceDate","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�����ͱ�������*/
				
				
				urlBuilder.append("&" + URLEncoder.encode("instt_code","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*��������ڵ�*/
				urlBuilder.append("&" + URLEncoder.encode("instt_nm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*������������*/
				
				
				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
				
				System.out.println("Response code: " + conn.getResponseCode());
				
				
				BufferedReader rd;
				if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				}
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
				rd.close();
				conn.disconnect();
				System.out.println(sb.toString());
				
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}

}
