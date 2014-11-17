<%--
    Created: Денис 
    Date: 16.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<c:set var="pharmacy" value="${ViewPharmacyForm.pharmacy}" scope="request"/>

<tiles:insertDefinition name="main">
    <tiles:putAttribute name="title" value="Информация об аптеке"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="viewPharmacy">
            <tiles:putAttribute name="name" value="${pharmacy.name}"/>
            <tiles:putAttribute name="address" value="${pharmacy.address}"/>
            <tiles:putAttribute name="phone" value="${pharmacy.phone}"/>
        </tiles:insertDefinition>
    </tiles:putAttribute>
</tiles:insertDefinition>