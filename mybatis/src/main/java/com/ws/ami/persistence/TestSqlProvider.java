package com.ws.ami.persistence;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

//BEGIN();表示刷新本地线程，某些变量为了线程安全，会先在本地存放变量，此处需要刷新。
//SELECT，FROM，WHERE等等都是sqlbuilder定义的公用静态方法，用来组成你的sql字符串。
// 如果你在testMapper中调用该方法的某个接口方法已经定义了参数@Param()，
// 那么该方法的参数Map<String, Object> parameters即组装了@Param()定义的参数，
// 比如testMapper接口方法中定义参数为@Param("testId"),@Param("testText")，
// 那么parameters的形态就是：[key="testId",value=object1],[key="testText",value=object2]，
// 如果接口方法没有定义@Param()，那么parameters的key就是参数的顺序小标：[key=0,value=object1],[key=1,value=object2]，
// SQL()将返回最终append结束的字符串，sql语句中的形如
// #{id,javaType=string,jdbcType=VARCHAR}完全可简写为#{id}，我只是为了规整如此写而已。
// 另外，对于复杂查询还有很多标签可用，比如：JOIN，INNER_JOIN，GROUP_BY，ORDER_BY等等，具体使用详情，你可以查看源码。
//  最后记得把你的Mapper接口注入到你的DAO类中，在DAO中引用Mapper接口方法即可。我在BaseDAO中的注解注入如下：

/**
 * Created by hp on 2015/1/6.
 */
public class TestSqlProvider {
    /**
     * table name, here is test
     */
    private static final String TABLE_NAME = "test";

    /**
     * get test by id sql script.
     *
     * @param parameters
     * @return
     */
    public String getSql(Map<String, Object> parameters) {
        String uid = (String) parameters.get("id");
        BEGIN();
        SELECT("test_id, test_text");
        FROM(TABLE_NAME);
        if (uid != null) {
            WHERE("test_id = #{id,javaType=string,jdbcType=VARCHAR}");
        }
        return SQL();
    }

    /**
     * get all tests sql script.
     *
     * @return
     */
    public String getAllSql() {
        BEGIN();
        SELECT("test_id, test_text");
        FROM(TABLE_NAME);
        return SQL();
    }

    /**
     * get test by test text sql script.
     *
     * @param parameters
     * @return
     */
    public String getByTestTextSql(Map<String, Object> parameters) {
        String tText = (String) parameters.get("testText");
        BEGIN();
        SELECT("test_id, test_text");
        FROM(TABLE_NAME);
        if (tText != null) {
            WHERE("test_text like #{testText,javaType=string,jdbcType=VARCHAR}");
        }
        return SQL();
    }

    /**
     * insert a test sql script.
     *
     * @return
     */
    public String insertSql() {
        BEGIN();
        INSERT_INTO(TABLE_NAME);
        VALUES("test_id", "#{testBean.id,javaType=string,jdbcType=VARCHAR}");
        VALUES("test_text", "#{testBean.testText,javaType=string,jdbcType=VARCHAR}");
        return SQL();
    }

    /**
     * update a test sql script.
     *
     * @return
     */
    public String updateSql() {
        BEGIN();
        UPDATE(TABLE_NAME);
        SET("test_text = #{testBean.testText,javaType=string,jdbcType=VARCHAR}");
        WHERE("test_id = #{testBean.id,javaType=string,jdbcType=VARCHAR}");
        return SQL();
    }

    /**
     * delete a test sql script.
     *
     * @return
     */
    public String deleteSql() {
        BEGIN();
        DELETE_FROM(TABLE_NAME);
        WHERE("test_id = #{id,javaType=string,jdbcType=VARCHAR}");
        return SQL();
    }
}
