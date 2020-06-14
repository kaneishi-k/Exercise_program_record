<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>エクササイズ記録　編集ページ</title>
    </head>
    <body>
        <h2>エクササイズ記録　編集ページ</h2>
        <form method="POST" action="<c:url value='/record/update' />">
            <label for="record_date">日付</label><br />
            <input type="date" name="record_date" value="<fmt:formatDate value='${record.record_date}' pattern='yyyy-MM-dd' />" />
            <br /><br />

            <label for="menu">実施メニュー</label><br />
            <input type="text" name="menu" value="${record.menu}" />
            <br /><br />

            <label for="comment">コメント</label><br />
            <textarea name="comment" rows="5" cols="50">${record.comment}</textarea>
            <br /><br />

            <input type="submit" value="投稿">

        </form>

        <p><a href="<c:url value='/record/index' />">一覧に戻る</a></p>

    </body>
</html>