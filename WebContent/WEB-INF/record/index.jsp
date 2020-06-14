<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>エクササイズ記録　一覧</title>
    </head>
    <body>
        <h2>エクササイズ記録　一覧</h2>
        <table>
            <tbody>
                <tr>
                    <th>日付</th>
                    <th>実施メニュー</th>
                    <th>操作</th>
                </tr>

                <tr>
                    <td><fmt:formatDate value='${record.record_date}' pattern='yyyy-MM-dd' /></td>
                    <td>${record.menu}</td>
                    <td><a href="<c:url value='/record/show?id=${record.id}' />">詳細を見る</a></td>
                </tr>

            </tbody>
        </table>

        <div>
            （全 ${records_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((records_count - 1) / 28) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/record/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/record/new' />">実施メニューの登録</a></p>

    </body>
</html>