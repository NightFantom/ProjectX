<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%--
status - атрибут отвечает за выбор класса для тега. Элемент может иметь два состояния: active и не active.
link - ссылка, по которой совершается переход при нажатии
imagePath - ссылка на фоновую картинку
text - текст пункта меню--%>

<tiles:importAttribute/>

<c:choose>
    <c:when test="${status} == active">
        <c:set var="st" value="itemActive"/>
    </c:when>
    <c:otherwise>
        <c:set var="st" value="item"/>
    </c:otherwise>
</c:choose>

<td class="${st}">
    <a href="${pageContext.request.contextPath}/${link}">
        <div>
            <img src="${imagePath}">
            <p>${text}</p>
        </div>
    </a>
</td>