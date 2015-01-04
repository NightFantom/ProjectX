<%--
    Создано: Денис 
    Дата: 31.12.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>

<tiles:insertDefinition name="onlyFon">
    <tiles:putAttribute name="title" value="Ошибка"/>
    <tiles:putAttribute name="content">
        <div class="errorBlock">
            К сожалению, произошла ошибка. Повторите попытку позже.
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>