<%--
    Created: Денис
    Date: 02.11.14.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="main">
    <tiles:putAttribute name="title" value="Медсправка"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="searchTool">
            <tiles:putAttribute name="actionT" value="next"/>
        </tiles:insertDefinition>
    </tiles:putAttribute>
</tiles:insertDefinition>