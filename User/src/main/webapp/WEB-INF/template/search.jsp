<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>

<%--
    action - ссылка для отправки данных с формы. Все прификсы и постфиксы уже указаны
--%>

<tiles:importAttribute/>
<c:set var="url">
    ${pageContext.servletContext.contextPath}/<tiles:getAsString name="action"/>.do
</c:set>

<div id="fieldSearch">
    <html:form action="search" method="post">
        <html:hidden  name="form" property="id"/>
        <img id = "iconSearch" src="images/iconSearch.png">
        <div id="searchLine">
            <p class="additionText bigText">поиск <span class="doubleOrange">лекарств</span></p>
            <div class="floatLeft">
                <html:text name="form" property="fields(searchInput)"  styleClass="inputTextSearch" maxlength="40"/>
            </div>
            <input id="searchButton" type="image" src="images/search.png">
            <p class="additionText smallItalicText">например: <span class="doubleOrange">аспирин</span></p>
        </div>
    </html:form>
</div>