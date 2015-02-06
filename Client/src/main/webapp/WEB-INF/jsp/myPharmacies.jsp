<%--
    Создано: Денис 
    Дата: 05.01.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}"/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:insertDefinition name="clientPanel">
    <tiles:putAttribute name="title" value="Админка"/>
    <tiles:putAttribute name="contentHeader">
        <p class="bigText marginBottom10">Мои <span class="orangeText">аптеки</span></p>
    </tiles:putAttribute>
    <tiles:putAttribute name="content">
        <grid:table name="${form.data}">
            <grid:column property="name" title="Название" href="${path}/private/viewPharmacy.do" paramId="id" paramProperty="id" class="highlightLink"/>
            <grid:column property="address" title="Адрес" href="${path}/private/viewPharmacy.do" paramId="id" paramProperty="id" class="highlightLink"/>
            <grid:column property="city.name" title="Город"/>
            <grid:column property="phone" title="Телефон"/>
        </grid:table>
    </tiles:putAttribute>
</tiles:insertDefinition>