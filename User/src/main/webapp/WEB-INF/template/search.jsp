<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--
    action - ссылка для отправки данных с формы. Все прификсы и постфиксы уже указаны
--%>

<c:set var="action">
    ${pageContext.servletContext.contextPath}/<tiles:insertAttribute name="action"/>.do
</c:set>

<div id="fieldSearch">
    <form action="${action}">
        <img id = "iconSearch" src="images/iconSearch.png">
        <div id="searchLine">
            <p class="additionText bigText">поиск <span class="doubleOrange">лекарств</span></p>
            <div class="floatLeft">
                <input class="inputTextSearch" type="text" maxlength="40"
                       placeholder="Введите название лекарства"/>
            </div>
            <input id="searchButton" type="image" src="images/search.png">
            <p class="additionText smallItalicText">например: <span class="doubleOrange">аспирин</span></p>
        </div>
    </form>
</div>