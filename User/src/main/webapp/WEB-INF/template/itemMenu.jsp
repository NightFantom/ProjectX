<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

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
    <a href="${link}">
        <div>
            <img src="${imagePath}">
            <p>${text}</p>
        </div>
    </a>
</td>