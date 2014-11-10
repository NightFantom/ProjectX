<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<form method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/save.do">
    File to upload: <input type="file" name="upfile"><br/>
    Login <input type="text" name="login">
    Password <input type="text" name="password">
    <input type="submit" value="Press"> to upload the file!
</form>