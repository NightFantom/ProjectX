<%--
    Created: Денис 
    Date: 02.11.14.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%--
    title - заголовок страницы
    content - контент
--%>
<tiles:importAttribute/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <meta http-equiv="Content-language" content="ru">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<div id="fon">
    <div id="basis">
        <div id="wrapper">
            <header>
                <div id="logo">
                    <a href="${pageContext.servletContext.contextPath}/index.do">
                        <img src="images/logo.png">
                    </a>
                </div>
                <tiles:insertDefinition name="menu"/>
                <div id="selectCityArea">
                    <div>Город:</div>
                    <div id="selectCity"><span class="orangeText">Вологда</span>
                        <div id="popUpSelectCity">
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </header>
            <div id="content">
                ${content}
            </div>
        </div>
    </div>
</div>
</body>
</html>