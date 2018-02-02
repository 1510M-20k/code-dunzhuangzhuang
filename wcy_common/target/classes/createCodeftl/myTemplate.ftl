<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${rootPath}.dao.${packageName}.${objectName}Dao">
	
	
	<!-- 新增-->
	<insert id="insert" parameterType="${rootPath}.model.${objectName}.${objectName}">
		insert into ${tablename}(
			<#list fieldList as var>
				<#if var_has_next>
					${var[0]},	
				<#else>
				    ${var[0]}
				</#if>
			</#list>
		) values (
			<#list fieldList as var>
				<#if var_has_next>
					${r"#{"}${var[0]}${r"}"},	
				<#else>
				    ${r"#{"}${var[0]}${r"}"}
				</#if>
			</#list>
		)
	</insert>
	
	
	<!-- 删除-->
	<delete id="delete" parameterType="String">
		delete from wcy_${objectName} where  id = #{id}
	</delete>
	
	
	<!-- 修改 -->
	<update id="update" parameterType="${rootPath}.model.${objectName}.${objectName}">
		update  wcy_${objectName}
	    	 <set> 
				<if test="id != null and id != '' ">
					id = #{id},
				</if>
				<if test="name != null and name != '' ">
					name = #{name},
				</if>
				<if test="type_id != null and type_id != '' ">
					type_id = #{type_id},
				</if>
				<if test="price != null and price != '' ">
					price = #{price},
				</if>
				<if test="proxy_price != null and proxy_price != '' ">
					proxy_price = #{proxy_price},
				</if>
				<if test="unite != null and unite != '' ">
					unite = #{unite},
				</if>
				<if test="num != null and num != '' ">
					num = #{num},
				</if>
				<if test="tag != null and tag != '' ">
					tag = #{tag},
				</if>
				<if test="is_wm != null and is_wm != '' ">
					is_wm = #{is_wm},
				</if>
				<if test="is_sj != null and is_sj != '' ">
					is_sj = #{is_sj},
				</if>
				<if test="is_yhj != null and is_yhj != '' ">
					is_yhj = #{is_yhj},
				</if>
				<if test="is_hyk != null and is_hyk != '' ">
					is_hyk = #{is_hyk},
				</if>
				<if test="img != null and img != '' ">
					img = #{img},
				</if>
				<if test="content != null and content != '' ">
					content = #{content},
				</if>
				<if test="creater != null and creater != '' ">
					creater = #{creater},
				</if>
				<if test="updater != null and updater != '' ">
					updater = #{updater},
				</if>
				<if test="update_time != null and update_time != '' ">
					update_time = #{update_time},
				</if>
			</set>
		where  id = #{id}
	</update>
	
	
	<!-- 通过ID获取数据 -->
	<select id="getById" resultType="${rootPath}.model.${objectName}.${objectName}" parameterType="String">
		select 
			a.id,	
			a.name,	
			a.type_id,	
			a.price,	
			a.proxy_price,	
			a.unite,	
			a.num,	
			a.tag,	
			a.is_wm,	
			a.is_sj,	
			a.is_yhj,	
			a.is_hyk,	
			a.img,	
			a.content,	
			a.create_time,	
			a.update_time,	
			a.creater,	
		    a.updater
		from  wcy_${objectName} a where id = #{id}
	</select>
	
	<!-- 列表(分页) -->
	<select id="getList" resultType="${rootPath}.model.${objectName}.${objectName}" parameterType="${rootPath}.model.${objectName}.${objectName}">
		select
			   a.id,
			   a.name,
			   a.type_id,
			   a.price,
			   a.proxy_price,
			   a.unite,
			   a.num,
			   a.tag,
			   a.is_wm,
			   a.is_sj,
			   a.is_yhj,
			   a.is_hyk,
			   a.img,
			   a.content,
			   DATE_FORMAT( a.create_time,'%Y-%m-%d %H:%i:%s')  create_time,
			   DATE_FORMAT( a.update_time,'%Y-%m-%d %H:%i:%s')  update_time,
			   a.creater,
			   a.updater
		from 
				wcy_${objectName} a
		<where>
			<if test="keyword != null and keyword !=''">
				and a.name like '%${keyword}%'
			</if>
			<if test="beginTime != null and beginTime != '' ">
				and a.create_time <![CDATA[>=]]> #{beginTime}
			</if>
			<if test="endTime != null and endTime != '' ">
				and a.create_time <![CDATA[<=]]> #{endTime}
			</if>
		</where>
		order by id desc limit #{startPos},#{pageSize}
	</select>
	
	<!-- 分页查询数量-->
	<select id="getCount" resultType="int" parameterType="${rootPath}.model.${objectName}.${objectName}">
		select count(1) from wcy_${objectName} where 1=1
	</select>
</mapper>