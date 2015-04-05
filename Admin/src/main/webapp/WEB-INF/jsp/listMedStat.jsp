<%--
    Создано: Денис 
    Дата: 05.04.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>

<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <table>
        <tr>
            <td>Название</td>
            <td>Количество запросов</td>
        </tr>
        <c:forEach var="medStat" items="${form.data}">
            <tr>
                <td>${medStat.name}</td>
                <td>${medStat.countRequest}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>