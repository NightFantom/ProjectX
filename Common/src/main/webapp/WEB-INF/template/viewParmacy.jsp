<%--
    Created: Денис 
    Date: 16.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:importAttribute/>

<p class="bigText marginBottom30">Аптека <span class="orangeText"><tiles:insertAttribute name="name"/></span></p>
<div class="leftColumn">
    <p class="bigText marginBottom30"><span class="orangeText">Контактная</span> информация</p>
    <p>Адрес: <span class="usualText"><tiles:insertAttribute name="address"/></span></p>
    <p>Время работы: <span class="usualText"><tiles:insertAttribute name="workTime"/></span></p>
    <p>Телефон: <span class="usualText"><tiles:insertAttribute name="phone"/></span></p>
    <p>Доп. информация: <span class="usualText"><tiles:insertAttribute name="additionalInformation"/></span></p>
</div>
<div class="workArea">
    <p class="bigText marginBottom30">Карта</p>
</div>
