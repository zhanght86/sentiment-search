package zx.soft.sent.dao.firstpage;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import zx.soft.sent.dao.domain.firstpage.FirstPageInfo;

/**
 * OA首页信息接口
 * 
 * @author wanggang
 *
 */
public interface FirstPageMapper {

	/**
	 * 插入OA首页查询数据
	 */
	@Insert("INSERT INTO `oa_firstpage_query_cache` (`type`,`timestr`,`result`,`lasttime`) "
			+ "VALUES (#{type},#{timestr},#{result},UNIX_TIMESTAMP())")
	public void insertFirstPage(FirstPageInfo firstPageInfo);

	/**
	 * 更新OA首页查询数据
	 */
	@Update("UPDATE `oa_firstpage_query_cache` SET `result` = #{result} "
			+ "WHERE `type` = #{type} AND `timestr` = #{timestr}")
	public void updateFirstPage(FirstPageInfo firstPageInfo);

	/**
	 * 查询OA首页查询数据
	 */
	@Select("SELECT `result` FROM `oa_firstpage_query_cache` WHERE `type` = #{type} AND `timestr` = #{timestr}")
	@ConstructorArgs(value = { @Arg(column = "result", javaType = String.class) })
	public String selectFirstPage(@Param("type") int p1, @Param("timestr") String p2);

	/**
	 * 删除OA首页查询数据
	 */
	@Delete("DELETE FROM `oa_firstpage_query_cache` WHERE `type` = #{type} AND `timestr` = #{timestr}")
	public void deleteFirstPage(@Param("type") int p1, @Param("timestr") String p2);

}
