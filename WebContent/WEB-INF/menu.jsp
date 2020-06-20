<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>今日のメニュー</title>
    </head>
    <body>
        <h1>今日のメニュー</h1><br >
        <ul><c:out value="${menu.ex_name}" />
        </ul>
        です。

        <p><a href="<c:url value='record/new' />">今日のエクササイズを記録</a></p>

    </body>
</html>