<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>今日のエクササイズはどうしよう？</title>
    </head>
    <body>
        <h1>今日のエクササイズはどうしよう？</h1>
        <form action="/Exercise_program_record/select" method="POST">
           運動の部位は？
           上肢<input type="radio" name="body_parts" value="0">
           下肢<input type="radio" name="body_parts" value="1">
           体幹<input type="radio" name="body_parts" value="2">
           全身<input type="radio" name="body_parts" value="3"><br><br>

           何分間運動する？
           5分<input type="radio" name="duration" value="0">
           10分<input type="radio" name="duration" value="1">
           15分<input type="radio" name="duration" value="2"><br><br>

           <input type="submit" value="送信" >

        </form>

    </body>
</html>