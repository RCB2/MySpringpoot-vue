<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书列表</title>
</head>
<body>
<table>
    <tr border="1">
        <td></td>
        <td></td>
        <td></td>
    </tr>
    ${books}
    <#--<#if books ??&&(books?size>0)>-->
    <#--<#list books as book>-->
    <#--<tr>-->
        <#--<td>${book.id}</td>-->
        <#--<td>${book.name}</td>-->
        <#--<td>${book.author}</td>-->
    <#--</tr>-->
    <#--</#list>-->
    <#--</#if>-->
</table>
${books}
</body>
</html>