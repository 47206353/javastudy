package com.ws.ami.common.pro;

import oracle.jdbc.OracleTypes;

import java.sql.*;

/**
 * Created by hp on 2015/7/21.
 */
public class StockProcedure {
    public static void main(String[] args) {
        System.out.println("123");
        int re;

        String driver = "oracle.jdbc.driver.OracleDriver";

        String strUrl = "jdbc:oracle:thin:@10.32.70.157:1521:KDCC";
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(strUrl, " crm_select", " crm_select");
            CallableStatement proc = null;
            proc = conn.prepareCall("{call crm_select.AJYDEV_HQ_GET_KHCC_real(?,?,?,?,?,?)}");
            proc.registerOutParameter(1, Types.INTEGER);

            //proc.setLong(4, 460029197001240019);
            proc.registerOutParameter(1, Types.INTEGER);
            proc.registerOutParameter(2,Types.VARCHAR);
            proc.registerOutParameter(3,oracle.jdbc.OracleTypes.CURSOR);
            proc.setInt(4, 20004618);

            proc.setString(5,null);
            proc.setString(6,null);



            proc.execute();

            ResultSet result = (ResultSet) proc.getObject(3);

           // Object ooo =  result.getObject(1);

            while(result.next()){
                Object o1 = result.getString(1);
                System.out.println(result.getString(1));//获取具体的值
            }



            System.out.println("123");
        } catch (SQLException ex2) {
            ex2.printStackTrace();
        } catch (Exception ex2) {
            ex2.printStackTrace();
            ex2.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                }
            } catch (SQLException ex1) {
            }
        }
    }
}
