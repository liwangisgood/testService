package cn.edu.testservice.dao;

import cn.edu.testservice.entity.User;
import cn.edu.testservice.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:liwang
 * @date: 2022/3/15 11:03
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class UserDao {

	private JdbcUtil jdbcUtil = new JdbcUtil();

	//	添加用户
	public int add(User user) {
		String sql = null;
		sql = "insert into user(id,name)" + " values(?,?);";
		PreparedStatement ps = jdbcUtil.createStatement(sql);//ps.executeUpdate()执行增删改返回int类型数据
		int result = 0;
		try {
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return result;
	}

	//删除用户
	public int delete(String id) {
		int result = 0;
		String sql = "delete from user where id= " + id;
		PreparedStatement ps = jdbcUtil.createStatement(sql);
		try {
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return result;
	}

	//更新用户信息
	public int update(User user) {
		int result = 0;
		String sql = "update user set name = ? where id = " + user.getId();
		PreparedStatement ps = jdbcUtil.createStatement(sql);
		try {
			ps.setString(1, user.getName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return result;
	}

	//根据id查询用户行信息
	public User query(String id) {

		//这点需要初始化不然会发生请求失败 无法获取的 user不可指向null
		User user=new User("不存在","不存在");
		ResultSet rs = null;
		String sql = "select * from user where id=" + id;
		PreparedStatement ps = jdbcUtil.createStatement(sql);
		try {
			rs = ps.executeQuery();
			if (rs!=null) {
				while (rs.next()) {
					id = rs.getString(1);
					String name = rs.getString("name");
					System.out.println("id:"+id+" name:"+name);
					if (id != null && name != null) {
						user.setId(id);
						user.setName(name);
						System.out.println("user:"+user);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.close(rs);
		}
		return user;
	}
}
