/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Huu Dat
 */
public class Connect {
    public Connection getConnection(){
      Connection conn =null;
      try{
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSEVER:1433;databaseName=QLKS;user=sa;password=sa");
          if(conn != null){
              System.out.println("Ket noi thanh cong");
          }
      }catch(Exception ex){
          System.out.println(ex.toString());
      }
      return conn;
    }
    
}

