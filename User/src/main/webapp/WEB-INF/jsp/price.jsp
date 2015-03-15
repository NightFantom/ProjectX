<%--
    Created: Денис 
    Date: 02.11.14.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://displaytag.sf.net" prefix="grid" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://helper" prefix="helper" %>

<c:set var="form" value="${helper:getCurrentForm(pageContext)}" scope="request"/>
<c:set var="path" value="${helper:getPath(pageContext)}"/>

<tiles:insertDefinition name="main" flush="true">
    <tiles:putAttribute name="title" value="Аптечная справка"/>
    <tiles:putAttribute name="content">
        <tiles:insertDefinition name="searchLine" flush="false">
            <tiles:putAttribute name="action" value="search"/>
        </tiles:insertDefinition>
        <c:choose>
            <c:when test="${form.length != '0'}">
                <tiles:insertDefinition name="resultTable" flush="false">
                    <tiles:putAttribute name="message">
                        <p class="smallItalicText marginBottom10">Лекарство <span class="doubleOrange"> "<bean:write
                                name="form" property="fields(searchInput)"/>"</span> найдено в ${form.length} аптеках
                        </p>
                    </tiles:putAttribute>
                    <tiles:putAttribute name="grid">
                        <div id="listButton" class="buttonPrice buttonCheck">Список</div>
                        <div id="mapButton" class="buttonPrice buttonNotCheck shiftButton">Карта</div>
                        <grid:table uid="price" name="${form.data}">
                            <grid:column href="${path}/viewPharmacy.do" paramId="id"
                                         paramProperty="pharmacy.id">
                                <div class = "map"></div>
                            </grid:column>
                            <grid:column property="pharmacy.name" title="Название аптеки"
                                         href="${path}/viewPharmacy.do" paramId="id"
                                         paramProperty="pharmacy.id" class="highlightLink"/>
                            <grid:column property="pharmacy.address" title="Адрес"
                                         href="${path}/viewPharmacy.do" paramId="id"
                                         paramProperty="pharmacy.id" class="highlightLink"/>
                            <grid:column property="amount" title="Количество"/>
                            <grid:column property="cost" title="Стоимость"/>
                            <grid:column title="Дата обновления">
                                ${helper:getDateUpdate(price.dateUpdate)}
                            </grid:column>
                        </grid:table>
                        <div id="workArea">
                            <div id="map2"></div>
                        </div>
                        <script type="text/javascript">
                            ymaps.ready(init);
                            var myMap, myPlacemark, myCollection;
                            function init() {
                                myMap = new ymaps.Map("map2", {
                                    center: [59.224058, 39.891808],
                                    zoom: 12
                                });
                                myCollection = new ymaps.GeoObjectCollection({}, {});
                                <c:forEach var="list" items="${form.data}" >
                                myPlacemark = new ymaps.Placemark([${list.getPharmacy().getCoordinates()}], {
                                    balloonContentBody: '<p class="bigText marginBottom30">${list.getCost()} руб. </p>',
                                    balloonContentHeader: '<p class="bigText marginBottom30"><span class="orangeText"><bean:write name="form" property="fields(searchInput)"/></span></p>',
                                    balloonContentFooter: '<p class="smallItalicText">${list.getPharmacy().getName()}</p>',
                                    hintContent: '<p class="smallItalicText">${list.getCost()} руб.</p>'

                                });
                                myCollection.add(myPlacemark);
                                </c:forEach>
                                myMap.geoObjects.add(myCollection);
                            }
                        </script>
                    </tiles:putAttribute>
                </tiles:insertDefinition>
            </c:when>
            <c:otherwise>
                <p class="marginTop30 textAlignCenter fontSize35">По вашему запросу ничего не найдено</p>
            </c:otherwise>
        </c:choose>
    </tiles:putAttribute>
</tiles:insertDefinition>
