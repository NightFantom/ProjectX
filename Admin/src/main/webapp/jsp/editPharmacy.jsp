<%--
    Создано: Денис 
    Дата: 08.01.15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://helper" prefix="helper" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>
<c:set var="mapFields" value="${form.fields}"/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>
<c:set var="pharmacy" value="${form.pharmacy}"/>
<c:set var="listCities" value="${helper:getListCities()}"/>

<tiles:insertDefinition name="adminPanel">
    <tiles:putAttribute name="title" value="Админка"/>
    <tiles:putAttribute name="contentHeader" value="Редактирование аптеки"/>
    <tiles:putAttribute name="content">
        <html:form method="POST" action="/private/${not empty pharmacy? 'saveEditPharmacy' : 'savePharmacy'}.do">
            <html:hidden name="form" property="id"/>
            <table>
                <tr>
                    <td class="leftColumnDL">Название:</td>
                    <td><html:text name="form" property="fields(name)"
                                   value="${not empty pharmacy ? pharmacy.name : empty mapFields['name']? '' : mapFields['name']}"
                                   styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Адрес:</td>
                    <td><html:text name="form" property="fields(address)"
                                   value="${not empty pharmacy ? pharmacy.address :  empty mapFields['address']? '' : mapFields['address']}" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Тефелон:</td>
                    <td><html:text name="form" property="fields(phone)"
                                   value="${not empty pharmacy ? pharmacy.phone :  empty mapFields['phone']? '' : mapFields['phone']}" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Город:</td>
                    <td>
                        <html:select name="form" property="fields(city)"
                                     value="${not empty pharmacy ? pharmacy.city.id : '1'}">
                            <html:optionsCollection name="listCities" label="name" value="id"/>
                        </html:select>

                    </td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Код сети:</td>
                    <td><html:text name="form" property="fields(codeNetwork)"
                                   value="${not empty pharmacy ? pharmacy.codeNetwork :  empty mapFields['codeNetwork']? '' : mapFields['codeNetwork']}"
                                   disabled="${not empty pharmacy}" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Логин:</td>
                    <td><html:text name="form" property="fields(login)"
                                   value="${not empty pharmacy ? pharmacy.login :  empty mapFields['login']? '' : mapFields['login']}" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Пароль:</td>
                    <td><html:password name="form" property="fields(password1)" styleClass="inputDL"/></td>
                </tr>
                <tr>
                    <td class="leftColumnDL">Повторите пароль:</td>
                    <td><html:password name="form" property="fields(password2)" styleClass="inputDL"/></td>
                </tr>

                <tr>
                    <td class="leftColumnDL"></td>
                    <td><html:submit styleClass="submitDL" value="Сохранить"/></td>
                </tr>
            </table>
        </html:form>
    </tiles:putAttribute>
</tiles:insertDefinition>