<%--
    Создано: Денис 
    Дата: 14.04.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://helper" prefix="helper" %>

<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:importAttribute/>
<a href="${path}/price.do?id=${medicament.id}" class="itemMedicamentLink">
    <div class="itemMedicament ${showBackground ? 'row1' : ''}">
        <div class="itemMedicamentName">
            ${medicament.name}
        </div>
        <div class="itemMedicamentPrice">
            ${countOffer}
        </div>
        <div class="clear"></div>
    </div>
</a>