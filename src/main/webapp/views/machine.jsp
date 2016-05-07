<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/machine/create" method="post" enctype="multipart/form-data">

	<label>管理用户名:</label>
	<input type="text" name="loginId" value="administrator"/>
	<br/>
	<label>管理员密码:</label>
	<input type="password" name="password" value="7s3*%x.ksyyz9987!!!"/>
	<br/>
	<label>文件:</label>
	<input type="file" name="excel"/>
	<br/>
	<input type="submit" value="上传"/>

</form>

</body>
</html>