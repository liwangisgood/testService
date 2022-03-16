package cn.edu.testservice.controller; /**
 * @author:liwang
 * @date: 2022/3/15 17:17
 * @Description:TODO
 * @Algorithm Design：TODO
 */

import cn.edu.testservice.dao.UserDao;
import cn.edu.testservice.util.JdbcUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserDeleteServlet", value = "/userDelete")
public class UserDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet请求正在执行中……");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
//		1.请求对象获取请求头参数 用户编号
		String id = request.getParameter("id");
		if (id!=null){
//			2.调用Dao将用户编号填充到数据库删行sql命令发送到数据库[Dao类]提供数据类连接操作封装 只需要id传参
			UserDao ud = new UserDao();
			int result = ud.delete(id);

			if (result == 1) {
				pw.print("<font style='color:red;font-size:40'>删除用户成功</font>");
			}else {
				pw.print("<font style='color:red;font-size:40'>删除用用户失败</font>");
			}
//		3.调用响应对象将处理结果以二进制写入响应体，交给浏览器
		}else {
			pw.print("<font style='color:red;font-size:40'>删除用用户失败[id为null]</font>");
		}
//
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
