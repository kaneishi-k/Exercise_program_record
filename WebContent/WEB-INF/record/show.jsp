<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>エクササイズの記録　詳細ページ</title>
    </head>

    <body>
        <h2>エクササイズ記録　詳細ページ</h2>
            <table>
                <tbody>
                     <tr>
                         <th>日付</th>
                             <td><fmt:formatDate value="${record.record_date}" pattern="yyyy-MM-dd" /></td>
                     </tr>
                     <tr>
                         <th>実施エクササイズメニュー</th>
                         <td>
                             <pre><c:out value="${record.menu}" /></pre>
                         </td>
                     </tr>
                     <tr>
                          <th>コメント</th>
                         <td>
                             <pre><c:out value="${report.content}" /></pre>
                         </td>
                     </tr>
                </tbody>
             </table>

    <p><a href="<c:url value="/record/edit?id=${record.id}" />">この記録を編集する</a></p>
    <p><a href="<c:url value="/record/index" />">一覧に戻る</a></p>

    </body>
</html>