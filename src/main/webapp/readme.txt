tomcat服务器打开时候默认访问资源优先
index.html index.htm index.jsp

访问servlet资源时候请求路径:
是相对于当前项目名 localhost:8080/myWeb (当前项目URL)
servlet路径如:/userAdd  ,可以访问所需要资源

访问webapp中静态资源时候,需要添加项目路径
/myWeb/index.html