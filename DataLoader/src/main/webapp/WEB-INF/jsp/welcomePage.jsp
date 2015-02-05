<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 24.01.2015
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>

<tiles:insertDefinition name="loaderPanel">
    <tiles:putAttribute name="title" value="Админка"/>
    <tiles:putAttribute name="contentHeader">
        <p class="bigText marginBottom10">Главная <span class="orangeText">страница</span></p>
    </tiles:putAttribute>
    <tiles:putAttribute name="content">
        <p>Рады приветствовать Вас на нашем сайте!</p>
    </tiles:putAttribute>
</tiles:insertDefinition>