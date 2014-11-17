<%--
    Created: Денис
    Date: 02.11.14.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="form" value="${StandardSearchForm}" scope="request"/>
<tiles:insertDefinition name="main">
    <tiles:putAttribute name="title" value="Медсправка"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="searchTool" flush="false">
            <tiles:putAttribute name="action" value="search"/>
        </tiles:insertDefinition>
    </tiles:putAttribute>
</tiles:insertDefinition>