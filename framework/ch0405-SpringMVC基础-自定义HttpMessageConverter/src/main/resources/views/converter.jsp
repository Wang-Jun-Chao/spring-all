<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HttpMessageConverter Demo</title>
</head>
<body>
<div id="resp"></div>
<input type="button" onclick="req();" value="请求"/>
<script src="assets/assets.js/jquery.assets.js" type="text/javascript"></script>
<script>
    function req() {
        $.ajax({
            url: "convert",
            data: "1-wangjunchao", // 注意这里的数据格式，后台处理按此格式处理，用“-”隔开。
            type: "POST",
            contentType: "application/x-wisely", // contentType 设置的媒体类型是我们自定义的application/x-wisely
            success: function (data) {
                $("#resp").html(data);
            }
        });
    }

</script>
</body>
</html>