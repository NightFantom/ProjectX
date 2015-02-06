<%--
    Created: Денис 
    Date: 30.12.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://displaytag.sf.net" prefix="grid" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://helper" prefix="helper" %>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>

<tiles:insertDefinition name="main">
    <tiles:putAttribute name="title" value="Медсправка"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="searchLine" flush="false">
            <tiles:putAttribute name="action" value="search"/>
        </tiles:insertDefinition>
        <c:choose>
            <c:when test="${form.length != '0'}">
                <tiles:insertDefinition name="resultTable" flush="false">
                    <tiles:putAttribute name="message">
                        <p class="smallItalicText marginBottom10">Уточните лекарство</p>
                    </tiles:putAttribute>
                    <tiles:putAttribute name="grid">
                        <grid:table uid="medicaments" name="${form.data}">
                            <grid:column property="name" title="Название лекарства"
                                         href="${pageContext.request.contextPath}/search.do" paramId="id"
                                         paramProperty="id"
                                         class="highlightLink"/>
                        </grid:table>
                    </tiles:putAttribute>
                </tiles:insertDefinition>
            </c:when>
            <c:otherwise>
                <p class="marginTop30 textAlignCenter fontSize35">По вашему запросу ничего не найдено</p>
            </c:otherwise>
        </c:choose>
    </tiles:putAttribute>
</tiles:insertDefinition>