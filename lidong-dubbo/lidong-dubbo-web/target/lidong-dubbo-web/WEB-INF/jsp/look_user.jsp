<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
用户信息<br/>
 用户名 :<label>${user.name}</label><br/>
 密&nbsp;&nbsp;&nbsp;码： <label>${user.password}</label><br/>
年&nbsp;&nbsp;&nbsp;龄： <label>${user.age}</label><br/>
  </body>  
</html>
