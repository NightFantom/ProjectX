<%--
    Created: Денис 
    Date: 04.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://helper" prefix="helper"%>

<c:set var="path" value="${helper:getPath(pageContext)}"/>

<div id="headerMenu">
    <table>
        <tr>
            <tiles:insertDefinition name="menuItem">
                <tiles:putAttribute name="link" value="index.do"/>
                <tiles:putAttribute name="imagePath" value="images/hederMenu/icon1.png"/>
                <tiles:putAttribute name="text" value="поиск лекарств"/>
            </tiles:insertDefinition>
            <tiles:insertDefinition name="menuItem">
                <tiles:putAttribute name="link" value="listPharmacy.do"/>
                <tiles:putAttribute name="imagePath" value="images/hederMenu/icon2.png"/>
                <tiles:putAttribute name="text" value="список аптек"/>
            </tiles:insertDefinition>
            <tiles:insertDefinition name="menuItem">
                <tiles:putAttribute name="link" value="medicalInstitutions.do"/>
                <tiles:putAttribute name="imagePath" value="images/hederMenu/icon4.png"/>
                <tiles:putAttribute name="text" value="мед учреждения"/>
            </tiles:insertDefinition>
            <tiles:insertDefinition name="menuItem">
                <tiles:putAttribute name="link" value="ourContacts.do"/>
                <tiles:putAttribute name="imagePath" value="images/hederMenu/icon3.png"/>
                <tiles:putAttribute name="text" value="наши контакты"/>
            </tiles:insertDefinition>
        </tr>
    </table>
</div>