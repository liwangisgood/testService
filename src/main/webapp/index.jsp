<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<a href="hello-servlet">Hello Servlet</a><br/>
<form action="/login" method="get">
    <table border="2">
        <tr>
            <td>登录名</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
            <td><input type="reset"/></td>
        </tr>
    </table>

</form>
</body>
</html>