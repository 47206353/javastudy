package com.ws.ami.persistence.mapper;

import com.ws.ami.persistence.model.TestBean;
import com.ws.ami.persistence.TestSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by hp on 2015/1/6.
 */
//@CacheNamespace(size = 512) ： 定义在该命名空间内允许使用内置缓存，
// 最大值为512个对象引用，读写默认是开启的，缓存内省刷新时间为默认3600000毫秒，
// 写策略是拷贝整个对象镜像到全新堆（如同CopyOnWriteList）因此线程安全。
@CacheNamespace(size = 512)
public interface TestMapper {

    //@SelectProvider(type = TestSqlProvider.class, method = "getSql") ：
    // 提供查询的SQL语句，如果你不用这个注解，你也可以直接使用@Select("select * from ....")注解，
    // 把查询SQL抽取到一个类里面，方便管理，同时复杂的SQL也容易操作，
    // type = TestSqlProvider.class就是存放SQL语句的类，而method = "getSql"
    // 表示get接口方法需要到TestSqlProvider类的getSql方法中获取SQL语句。
    //@Options(useCache = true, flushCache = false, timeout = 10000) ： 一些查询的选项开关，
    // 比如useCache = true
    // 表示本次查询结果被缓存以提高下次查询速度，
    // flushCache = false表示下次查询时不刷新缓存，timeout = 10000表示查询结果缓存10000秒。

    //@Param("id") ：全局限定别名，定义查询参数在sql语句中的位置不再是顺序下标0,1,2,3....的形式，
    // 而是对应名称，该名称就在这里定义。
    @SelectProvider(type = TestSqlProvider.class, method = "getSql")
    @Options(useCache = true, flushCache = false, timeout = 10000)
    @Results(value = {
            @Result(id = true, property = "id", column = "test_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "testText", column = "test_text", javaType = String.class, jdbcType = JdbcType.VARCHAR)
                    })

    public TestBean get(@Param("id") String id);

    // Results(value = {
    // @Result(id = true, property = "id", column = "test_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    //  @Result(property = "testText", column = "test_text", javaType = String.class, jdbcType = JdbcType.VARCHAR) }) ：
    // 表示sql查询返回的结果集，@Results是以@Result为元素的数组，
    // @Result表示单条属性-字段的映射关系，如：
    // @Result(id = true, property = "id", column = "test_id", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    // 可以简写为：@Result(id = true, property = "id", column = "test_id")，id = true表示这个test_id字段是个PK，
    // 查询时mybatis会给予必要的优化，应该说数组中所有的@Result组成了单个记录的映射关系，而@Results则单个记录的集合。
    // 另外还有一个非常重要的注解@ResultMap也和@Results差不多，到时会讲到。

    /**
     * get all tests.
     * @return
     */
    @SelectProvider(type = TestSqlProvider.class, method = "getAllSql")
    @Options(useCache = true, flushCache = false, timeout = 10000)
    @Results(value = {
            @Result(id = true, property = "id", column = "test_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "testText", column = "test_text", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TestBean> getAll();

    /**
     * get tests by test text.
     *
     * @param testText
     * @return
     */
    //@ResultMap(value = "getByTestText") ：重要的注解，可以解决复杂的映射关系，
    // 包括resultMap嵌套，鉴别器discriminator等等。注意一旦你启用该注解，
    // 你将不得不在你的映射文件中配置你的resultMap，
    // 而value = "getByTestText"即为映射文件中的resultMap ID(注意此处的value = "getByTestText"，
    // 必须是在映射文件中指定命名空间路径)。@ResultMap在某些简单场合可以用@Results代替，
    // 但是复杂查询，比如联合、嵌套查询@ResultMap就会显得解耦方便更容易管理。
    @SelectProvider(type = TestSqlProvider.class, method = "getByTestTextSql")
    @Options(useCache = true, flushCache = false, timeout = 10000)
    @ResultMap(value = "getByTestText")
    public List<TestBean> getByTestText(@Param("testText") String testText);


   //@InsertProvider(type = TestSqlProvider.class, method = "insertSql") ：
   // 用法和含义@SelectProvider一样，只不过是用来插入数据库而用的。
  // @Options(flushCache = true, timeout = 20000) ：对于需要更新数据库的操作，
  // 需要重新刷新缓存flushCache = true使缓存同步。
    /**
     * insert a test bean into database.
     *
     * @param testBean
     */
    @InsertProvider(type = TestSqlProvider.class, method = "insertSql")
    @Options(flushCache = true, timeout = 20000)
    public Integer insert(@Param("testBean") TestBean testBean);

    //@UpdateProvider(type = TestSqlProvider.class, method = "updateSql") ：
    // 用法和含义@SelectProvider一样，只不过是用来更新数据库而用的。
    //@Param("testBean") ：是一个自定义的对象，指定了sql语句中的表现形式，
    // 如果要在sql中引用对象里面的属性，只要使用testBean.id，testBean.textText即可，mybatis会通过反射找到这些属性值。

    /**
     * update a test bean with database.
     *
     * @param testBean
     */
    @UpdateProvider(type = TestSqlProvider.class, method = "updateSql")
    @Options(flushCache = true, timeout = 20000)
    public void update(@Param("testBean") TestBean testBean);

    //@DeleteProvider(type = TestSqlProvider.class, method = "deleteSql") ：
    // 用法和含义@SelectProvider一样，只不过是用来删除数据而用的。
    /**
     * delete a test by UID.
     *
     * @param id
     */
    @DeleteProvider(type = TestSqlProvider.class, method = "deleteSql")
    @Options(flushCache = true, timeout = 20000)
    public void delete(@Param("id") String id);
}

