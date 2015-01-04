<%--
    Создано: Денис 
    Дата: 04.01.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>

<tiles:importAttribute/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <meta http-equiv="Content-language" content="ru">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <title>${title}</title>
</head>
<body>
<div id="fon">
    <div id="basis">
        <div id="wrapper">
            <header>
                <div id="logo">
                    <a href="#">
                        <img src="${path}/images/logo.png">
                    </a>
                </div>
                <div class="clear"></div>
            </header>
            <div id="content">
                <p class="bigText">Личный <span class="doubleOrange">кабинет</span></p>
                <p><span class="doubleOrange">Добро пожаловать, ${helper:getPersonName(pageContext)}!</span></p>
                <div class="twoColumn">
                    <div class="leftColumnAdmin">
                        <a href="#"><p class="leftMenu">Мои аптеки</p></a>
                        <a href="#"><p class="leftMenu">Статистика</p></a>
                    </div>
                    <div class="wrapperAdmin">
                        <div class="workAreaAdmin">
                            <p class="bigText doubleOrange">${contentHeader}</p>
                            ${content}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>