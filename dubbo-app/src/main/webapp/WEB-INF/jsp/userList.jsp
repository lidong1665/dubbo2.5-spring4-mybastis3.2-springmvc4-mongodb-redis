<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML>  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'showUser.jsp' starting page</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
  
  </head>  
    
  <body>  
     
      <table width="100%">
        <tr><th width="15%">id</th><th width="15%">用户名</th><th width="15%">密码</th><th width="15%">年龄</th><th width="40%">操作</th></tr>
        <c:forEach var="user"   items="${users}" step="1">
        <tr><td width="15%" style="text-align: center;">${user.id}</td><td style="text-align: center;" width="15%">${user.name}</td><td style="text-align: center;" width="15%">${user.password}</td><td style="text-align: center;" width="15%">${user.age}</td><td style="text-align: center;" width="40%"><a href="${path}/SpringMVC_MyBatis/user/getUserInfo?id=${user.id}" width="15%">查看</a><a href="${path}/SpringMVC_MyBatis/user/getUser?id=${user.id}" width="15%">修改</a><a href="${path}/SpringMVC_MyBatis/user/delUser?id=${user.id}" width="15%">删除</a></td></tr>
        </c:forEach>
     </table>
  </body>  
</html>