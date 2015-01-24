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
    <jsp:include page="../../jsp/scriptsProtected.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <title>${title}</title>
</head>
<body>
<div id="fon">
    <div id="basis">
        <div id="wrapper">
            <header class="headerAdmin">
                <div id="logo">
                    <a href="${path}/private/welcomePage.do">
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
                        <a href="${path}/private/myPharmacies.do"><p class="leftMenu">Мои аптеки</p></a>
                        <a href="${path}/private/pharmaciesStatistic.do"><p class="leftMenu">Статистика</p></a>
                        <a href="${path}/private/exit.do"><p class="leftMenu">Выход</p></a>
                    </div>
                    <div class="wrapperAdmin">
                        <div class="workAreaAdmin">
                            ${contentHeader}
                            ${content}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div id="script">
        <tiles:putAttribute name="script"/>
    </div>
</footer>
</body>
</html>