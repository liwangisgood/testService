package cn.edu.testservice.controller; /**
 * @author:liwang
 * @date: 2022/3/15 21:26
 * @Description:TODO
 * @Algorithm Design：TODO
 */

import cn.edu.testservice.dao.UserDao;
import cn.edu.testservice.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserQueryServlet", value = "/userQuery")
public class UserQueryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		1.获取查询用户id
		String id = request.getParameter("id");

//		2.将用户id加入到sql语句连接数据库执行
		UserDao userDao = new UserDao();
		User user=null;
		user=userDao.query(id);
		System.out.println("user:"+user);

//		3.查看结果在控制台上或浏览器上
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (user == null) {
			pw.print("<font style='color:red;font-size:40'>未查找到指定id或者处理异常</font>");
		}else {
			String a="id:"+user.getId()+" "+"name:"+user.getName();

			pw.print("<font style='color:red;font-size:40'>"+a+"</font>");
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
