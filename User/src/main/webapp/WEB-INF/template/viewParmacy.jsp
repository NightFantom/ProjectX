<%--
    Created: Денис 
    Date: 16.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:importAttribute/>

<p>Название: <tiles:insertAttribute name="name"/></p>
<p>Адрес: <tiles:insertAttribute name="address"/></p>
<p>Телефон: <tiles:insertAttribute name="phone"/></p>
