<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="form" value="${ResultSetForm}"/>

<tiles:insertDefinition name="main">
    <tiles:putAttribute name="title" value="Медсправка"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="search">
            <tiles:putAttribute name="action" value="go"/>
        </tiles:insertDefinition>
        <tiles:insertDefinition name="resultTable">
            <tiles:putAttribute name="medicament" value="Мезим"/>
            <tiles:putAttribute name="count" value="${form.length}"/>
            <tiles:putAttribute name="grid">
               <grid:table name="${form.data}">
                   <grid:column property="number" title="Номер"/>
                   <grid:column property="message" title="Сообщение"/>
                   <grid:column property="date" title="Дата"/>
               </grid:table>
            </tiles:putAttribute>
        </tiles:insertDefinition>
    </tiles:putAttribute>
</tiles:insertDefinition>