<%--
    Created: Денис 
    Date: 02.11.14.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:importAttribute/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <meta http-equiv="Content-language" content="ru">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<div id="fon">
    <div id="basis">
        <div id="wrapper">
            <header>
                <div id="logo">
                    <a href="#">
                        <img src="images/logo.png">
                    </a>
                </div>
                <div id="headerMenu">
                    <table>
                        <tr>
                            <tiles:definition name="menuItem">
                                <tiles:putAttribute name="link" value=""/>
                                <tiles:putAttribute name="imagePath" value="images/hederMenu/icon1.png"/>
                                <tiles:putAttribute name="text" value="поиск лекарств"/>
                            </tiles:definition>
                            <tiles:definition name="menuItem">
                                <tiles:putAttribute name="link" value=""/>
                                <tiles:putAttribute name="imagePath" value="images/hederMenu/icon2.png"/>
                                <tiles:putAttribute name="text" value="список аптек"/>
                            </tiles:definition>
                            <tiles:definition name="menuItem">
                                <tiles:putAttribute name="link" value=""/>
                                <tiles:putAttribute name="imagePath" value="images/hederMenu/icon3.png"/>
                                <tiles:putAttribute name="text" value="наши контакты"/>
                            </tiles:definition>
                        </tr>
                    </table>
                </div>
                <div id="selectCityArea">
                    <div>Город:</div>
                    <div id="selectCity"><span class="orangeText">Вологда</span>
                        <div id="popUpSelectCity">
                            <table>
                                <tr>
                                    <td><a href="#" class="highlightLink">Череповец</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#" class="highlightLink">Архангельск</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#" class="highlightLink">Киров</a></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </header>
            <div id="content">

            </div>
        </div>
    </div>
</div>
</body>
</html>