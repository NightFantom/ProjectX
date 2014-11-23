<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://helper" prefix="helper"%>

<tiles:insertDefinition name="main">
    <tiles:putAttribute name="title" value="Загрузка файла"/>
    <tiles:putAttribute name="content">
        <div id="formDL">
            <form method="POST" enctype="multipart/form-data" action="${helper:getPath(pageContext)}/save.do">
                <table class="tableDL">
                    <tr>
                        <td class="leftColumnDL">Логин:</td>
                        <td><input type="text" name="login" class="inputDL"/></td>
                    </tr>
                    <tr>
                        <td class="leftColumnDL">Пароль:</td>
                        <td><input type="password" name="password" class="inputDL"/></td>
                    </tr>
                    <tr>
                        <td class="leftColumnDL">Файл для загрузки:</td>
                        <td><input type="file" name="upfile"/></td>
                    </tr>
                    <tr>
                        <td class="leftColumnDL"></td>
                        <td><input type="submit" class="submitDL" value="Отправить файл"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>