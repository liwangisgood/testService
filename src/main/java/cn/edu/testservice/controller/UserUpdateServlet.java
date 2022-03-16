package cn.edu.testservice.controller; /**
 * @author:liwang
 * @date: 2022/3/15 17:44
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
import java.util.Objects;

@WebServlet(name = "UserUpdateServlet", value = "/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet请求正在执行中……");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
//		1.请求体中获取需要更改的信息包括id 封装成实体对象
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		User user = new User(id, name);

//		false
//		false
		System.out.println(Objects.equals(id, ""));
		System.out.println(Objects.equals(name, ""));

		if (id != null && name != null) {
//			2.调用UserDao将用户实体信息加入搭配update sql语句中操作响应数据库
			UserDao userDao = new UserDao();
			int result = userDao.update(user);
			if (result == 1) {
				pw.print("<font style='color:red;font-size:40'>用户更新成功</font>");
			} else {
				pw.print("<font style='color:red;font-size:40'>用户更新失败</font>");
			}
		} else {
			pw.print("<font style='color:red;font-size:40'>用户更新失败[id或name为空]</font>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
