package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;





public class Jdbc1Query01{

    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    
    // 1) ilgili driver ı yüklemeliyiz. tv nin fişini tak, mesela başka alet çalışmasın, ne çalışacağını bilsin
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	
    	
    	
   // 2) Bağlantı oluşturmalıyız. uydu şifrelerini girmeliyiz
    	
    	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "hüdavendigar33.");
    	
    	
   // 3)SQL komutları için bir Statement nesnesi oluştur. Her kanal için kumanda da yer ayarlamak
    	
    	  Statement st=con.createStatement();
    	  
   // 4)SQL ifadeleri yazabilir ve çalışabiliriz yani kumandada 1 basarız trt 1 gelir
    	  
    ResultSet veri=	  st.executeQuery("SELECT isim, maas FROM personel WHERE id=123456789");
    	  
    // 5) sonuçları aldık ve işledik
    	  
    	  while(veri.next()) {
    		  
    		  System.out.println(veri.getString("isim")+" " +veri.getInt("maas") );
    	      
    		  System.out.println("Personel Adı:" +veri.getString(1)+" "+"Maas:"+veri.getInt(2) );
    	  
    	  }
    	  
    	  // 6) oluşturulan nesneleri bellekten kaldıralım
    	  
    	  con.close();
    	  st.close();
    	  veri.close();
    	  
        
    }
}
