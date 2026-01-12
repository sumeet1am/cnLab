
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPS {
   public TCPS() {
   }

   public static void main(String[] var0) throws Exception {
      ServerSocket var1 = new ServerSocket(4000);
      System.out.println("Server ready for connection");
      Socket var2 = var1.accept();
      System.out.println("Connection Is successful and waiting for the client request");
      BufferedReader var3 = new BufferedReader(new InputStreamReader(var2.getInputStream()));
      String var4 = var3.readLine();
      PrintWriter var5 = new PrintWriter(var2.getOutputStream(), true);
      BufferedReader var6 = new BufferedReader(new FileReader(var4));

      String var7;
      while((var7 = var6.readLine()) != null) {
         var5.println(var7);
      }

      var6.close();
      var2.close();
      var1.close();
   }
}
