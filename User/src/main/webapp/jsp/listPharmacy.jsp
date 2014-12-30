<%--
    Created: Денис 
    Date: 23.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>

<tiles:insertDefinition name="main">
    <tiles:putAttribute name="title" value="Список аптек"/>
    <tiles:putAttribute name="content">
        <grid:table name="${form.data}">
            <grid:column property="name" title="Название" href="${pageContext.request.contextPath}/viewPharmacy.do" paramId="id" paramProperty="id" class="highlightLink"/>
            <grid:column property="address" title="Адрес" href="${pageContext.request.contextPath}/viewPharmacy.do" paramId="id" paramProperty="id" class="highlightLink"/>
            <grid:column property="phone" title="Телефон"/>
        </grid:table>
    </tiles:putAttribute>
</tiles:insertDefinition>