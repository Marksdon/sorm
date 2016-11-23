package com.rand.sorm.core;

import java.util.List;

/**
 * 负责提供持久化服务的核心
 * @author randall
 *
 */
public interface Query {

	/**
	 * 执行sql语句
	 * @param sql sql语句
	 * @param params 参数
	 * @return 这行该这个操作后，影响行数
	 */
	public int executeDML(String sql, Object[] params);

	/**
	 * 将对象{@code obj}插入到数据中
	 * @param obj 需要插入的对象
	 */
	public void insert(Object obj);
	/**
	 * 将对象{@code obj}更新的数据库
	 * @param obj 需要更新的对象
	 * @param fieldNams 更新的字段
	 * @return 执行后影响行数
	 */
	public int update(Object obj, String[] fieldNams);
	/**
	 * 将对象从数据库中删除,对象的类对应到表,对象的对应到表的记录
	 * @param obj 需要删除的对象
	 */
	public void delete(Object obj);
	/**
	 * 删除类{@code clazz}对应的表，根据主键{@code id}来确定记录在表中的记录
	 * @param clazz {@link Class}对象
	 * @param id 用于指定主键的
	 */
	public void delete(Class<?> clazz, Object id);
	/**
	 * 查询多行多列，并将数据封装到{@code clazz}对应类的对象中
	 * @param sql sql语句
	 * @param clazz {@link Class}对象
	 * @param params 参数
	 * @return 查询的结果
	 */
	public List<?> queryRows(String sql, Class<?> clazz, Object[] params);
	/**
	 * 查询一行记录，直接返回
	 * @param sql sql语句
	 * @param params 参数
	 * @return 查询的结果
	 */
	public Object queryUinqueRow(String sql, Object[] parrms);
	/**
	 * 查询一行，并将数据封装到{@code clazz}对应类的对象中
	 * @param sql sql语句
	 * @param params 参数
	 * @return 查询的结果
	 */
	public Object queryValue(String sql, Object[] params);
	/**
	 * 查询一个值，将结果返回
	 * @param sql sql语句
	 * @param params 参数
	 * @return 查询的结果
	 */
	public Number queryNmber(String sql, Object[] params);

	
}
