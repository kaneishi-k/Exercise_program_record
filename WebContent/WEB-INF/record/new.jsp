<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<h2>今日のメニュー記録ページ</h2>

<form action="/record/create" method="get">
    <label for="record_date">日付</label><br />
    <input type="date" name="record_date" value="<fmt:formatDate value='${record.record_date}' pattern='yyyy-MM-dd' />" />
    <br /><br />

    <label for="menu">実施メニュー</label><br />
    <input type="text" name="menu" value="${record.menu}" />
    <br /><br />

    <label for="comment">コメント</label><br />
    <textarea name="comment" rows="5" cols="50">${record.comment}</textarea>
    <br /><br />

    <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">投稿</button>

</form>

<p><a href="<c:url value='/record/index' />">一覧に戻る</a></p>

