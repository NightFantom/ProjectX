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
    <jsp:include page="../../jsp/scripts.jsp"/>
</head>
<body>
<div id="fon">
    <div id="basis">
        <div id="wrapper">
            <header class="headerUser">
                <div id="logo" class="floatLeft">
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
<footer>
    <div id="script">
        <tiles:putAttribute name="script"/>
        <jsp:include page="../../jsp/yandexMetrica.jsp"/>
    </div>
</footer>
</body>
</html>