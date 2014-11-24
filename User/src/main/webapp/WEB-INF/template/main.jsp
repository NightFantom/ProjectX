<%--
    Created: Денис 
    Date: 02.11.14.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>
<%--
    title - заголовок страницы
    content - контент
--%>
<tiles:importAttribute/>

<c:set var="path" value="${helper:getPath(pageContext)}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <meta http-equiv="Content-language" content="ru">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <title><tiles:getAsString name="title"/></title>
    <script type="text/javascript" src="js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/ajax.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
    <script>contextUrl("${pageContext.servletContext.contextPath}")</script>
</head>
<body>
<div id="fon">
    <div id="basis">
        <div id="wrapper">
            <header>
                <div id="logo">
                    <a href="${path}/index.do">
                        <img src="${path}/images/logo.png">
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