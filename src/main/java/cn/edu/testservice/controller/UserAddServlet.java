package cn.edu.testservice.controller; /**
 * @author:liwang
 * @date: 2022/3/15 10:39
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

@WebServlet(name = "UserAddServlet", value = "/userAdd")
public class UserAddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet请求正在执行中……");
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (id != null&&name!=null) {
			UserDao userDao = new UserDao();
			User user = new User(id, name);
			int result = userDao.add(user);
			System.out.println("result：" + result);
			if (result == 1) {
				System.out.println("注册成功");
				pw.print("<font style='color:red;font-size:40'>用户注册成功</font>");
			} else {
				System.out.println("注册失败");
			}
		}else {
//			pw.print("<font style='color:red;font-size:40'>[用户注册失败]用户id或name不得为空</font>");
			response.sendRedirect("/myWeb/index.html");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
