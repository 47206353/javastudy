package com.ws.ami.common.pro;

import java.sql.*;

/**
 * Created by hp on 2015/6/22.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("123");
        int re;

        String driver = "oracle.jdbc.driver.OracleDriver";
        String strUrl = "jdbc:oracle:thin:@192.168.92.1:1521:ORCL";
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(strUrl, " hs_asset", " hundsun");
            CallableStatement proc = null;
            // proc = conn.prepareCall("{?=call hs_asset.AP_SUR_QUERYFARE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            proc = conn.prepareCall("{?=call hs_asset.AP_SUR_QUERYFARE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            // int re = 0;
            // proc.setInt(1,1);


            proc.registerOutParameter(1, Types.INTEGER);
            // proc.setString(6,"1");   //   lpSP->registerOutParameter(1,HSQL_DATATYPE_INT,0); //��1���ʺ��Ƿ���ֵ
            //���������
            proc.setInt(2, 1); //  lpSP->setInt(2,p_op_branch_no);
            proc.setString(3, "d");   //  lpSP->setString(3,p_operator_no);
            proc.setString(4, "d");  //  lpSP->setChar(4,p_user_type);
            proc.setString(5, "d");// lpSP->setString(5,p_op_password);
            proc.setString(6, "d"); //  lpSP->setString(6,p_op_station);
            proc.setString(7, "d"); //  lpSP->setChar(7,p_op_entrust_way);

            proc.setInt(8, 1);
            proc.setInt(9, 1);
            proc.setInt(10, 1);
            proc.setString(11, "d");
            proc.setString(12, "d");
            proc.setString(13, "d");
            proc.setString(14, "d");
            proc.setString(15, "d");
            proc.setString(16, "d");
            proc.setString(17, "d");
            proc.registerOutParameter(18, Types.CHAR);

            proc.registerOutParameter(19, Types.CHAR);
            proc.registerOutParameter(20, Types.INTEGER);
            proc.registerOutParameter(21, Types.INTEGER);
            proc.registerOutParameter(22, Types.CHAR);


            //   proc.setInt(9,1);//  lpSP->setInt(9,p_function_id);
            //  proc.setInt(10,1); //   lpSP->setInt(10,p_branch_no);
            //  proc.setString(11, "d");//  lpSP->setString(11,p_fund_account);
            //  proc.setString(12,"d");//  lpSP->setString(12,p_password);
            //  proc.setString(13,"1"); // lpSP->setChar(13,p_entrust_bs);
            //  proc.setString(14,"d");//  lpSP->setString(14,p_exchange_type);
            //  proc.setString(15,"d"); // lpSP->setString(15,p_stock_account);
            //  proc.setString(16,"d"); // lpSP->setString(16,p_stock_type);
            // proc.setString(17,"d");// lpSP->setString(17,v_error_pathinfo);

            // proc.setString(18,"d");//  lpSP->setString(17,v_error_pathinfo);
         /*   proc.registerOutParameter(17, Types.CHAR);
            proc.registerOutParameter(18, Types.CHAR);
            proc.registerOutParameter(19, Types.INTEGER);
            proc.registerOutParameter(20, Types.INTEGER);
            proc.registerOutParameter(21, Types.CHAR);*/

            proc.execute();

            Object resultObject = proc.getObject(1);
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


