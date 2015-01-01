<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://displaytag.sf.net" prefix="grid"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>

<tiles:insertDefinition name="main">
    <tiles:putAttribute name="title" value="Медсправка"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="searchLine" flush="false">
            <tiles:putAttribute name="action" value="search"/>
        </tiles:insertDefinition>
        <tiles:insertDefinition name="resultTable" flush="false">
            <tiles:putAttribute name="message">
                <p class="smallItalicText marginBottom10">Лекарство <span class="doubleOrange"> "<bean:write name="form" property="fields(searchInput)"/>"</span> найдено в ${form.length} аптеках</p>
            </tiles:putAttribute>
            <tiles:putAttribute name="grid">
               <grid:table uid="price" name="${form.data}">
                   <grid:column property="pharmacy.name" title="Название аптеки" href="${pageContext.request.contextPath}/viewPharmacy.do" paramId="id" paramProperty="pharmacy.id" class="highlightLink"/>
                   <grid:column property="pharmacy.address" title="Адрес" href="${pageContext.request.contextPath}/viewPharmacy.do" paramId="id" paramProperty="pharmacy.id" class="highlightLink"/>
                   <grid:column property="amount" title="Количество"/>
                   <grid:column property="cost" title="Стоимость"/>
                   <grid:column  title="Дата обновления">
                        ${helper:getDateUpdate(price.dateUpdate)}
                   </grid:column>
               </grid:table>
            </tiles:putAttribute>
        </tiles:insertDefinition>
    </tiles:putAttribute>
</tiles:insertDefinition>