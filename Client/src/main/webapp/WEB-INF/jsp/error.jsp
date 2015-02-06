<%--
    Создано: Денис 
    Дата: 04.01.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>
<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:insertDefinition name="onlyFon">
    <tiles:putAttribute name="title" value="Ошибка"/>
    <tiles:putAttribute name="content">
        <div class="errorBlock">
            К сожалению, произошла ошибка. Повторите попытку позже.
        </div>
        <a href="${path}/index.do"><p class="submitDL">На главную</p></a>
    </tiles:putAttribute>
</tiles:insertDefinition>