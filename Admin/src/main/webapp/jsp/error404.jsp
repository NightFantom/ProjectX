<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 31.01.2015
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>
<c:set var="path" value="${helper:getPath(pageContext)}"/>
<tiles:insertDefinition name="main">
    <tiles:putAttribute name="title" value="Ошибка"/>
    <tiles:putAttribute name="content">
        <div class="errorBlock">
            Страница не найдена.
        </div>
        <a href="${path}/index.do"><p class="submitDL">На главную</p></a>
    </tiles:putAttribute>
</tiles:insertDefinition>
