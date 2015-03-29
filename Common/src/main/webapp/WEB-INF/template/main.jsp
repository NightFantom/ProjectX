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
<c:set var="status" value="${helper:getCityStatus(pageContext)}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <meta http-equiv="Content-language" content="ru">
    <meta name="description" content="Поиск лекарств в Вологде">
    <meta name="keywords" content="аптечная справка,аптечная справка Вологда, купить лекарства, где купить лекарства, аптеки вологды">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/jquery-ui-1.7.2.custom.css"/>
    <link rel="shortcut icon" href="${path}/favicon.ico" type="image/x-icon"/>
    <title><tiles:getAsString name="title"/></title>
    <script>var path = '${path}'; var status = '${status}'</script>
    <jsp:include page="../jsp/scripts.jsp"/>
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
                    <div id="selectCity"><span class="orangeText">${helper:getCurrentCity(pageContext).getName()}</span>
                        <div id="popUpSelectCity">
                            <table>
                                <c:forEach items="${helper:getListCities()}"  var="city">
                                    <tr>
                                        <td><a href="${path}/changeCity.do?id=${city.getId()}" class="changeCityLink">${city.getName()}</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </header>
            <div id="content">
                ${content}
            </div>
        </div>
        <%--Слова для поисковых систем--%>
        <div class="displayNone">
            <p>Адрес: г.Вологда</p>
            <p>Индекс: 160000</p>
            <p>Аптечная справка</p>
            <p>Аптечная справка Вологда</p>
            <p>Аптечная справка.рф</p>
            <p>Аптечная справка.рф Вологда</p>
            <p>Вологда Аптечная справка</p>
            <p>Вологда</p>
            <p>аптеки вологды</p>
            <p>антей аптека вологда</p>
        </div>
    </div>
</div>
<footer>
    <div id="script">
        <tiles:putAttribute name="script"/>
        <jsp:include page="../jsp/yandexMetrica.jsp"/>
    </div>
</footer>
</body>
</html>