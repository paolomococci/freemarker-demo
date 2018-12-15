<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Color list</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
    <h2>Partial color list</h2>
    <hr/>
    <div>
        <form name="color" action="add.html" method="POST">
            <fieldset>
                <legend>adding a specific color</legend>
                <label for="code">code: </label>
                <input type="text" maxlength="7" id="code" name="code"/>
                <br/>
                <label for="name">name: </label>
                <input type="text" maxlength="12" id="name" name="name"/>
                <br/>
                <input type="submit" value="save"/>
            </fieldset>
        </form>
    </div>
    <table>
        <th>code</th>
        <th>name</th>
        <th>sample</th>
        <#list model["colorList"] as color>
        <tr>
            <td><small>${color.code}</small></td>
            <td>${color.name}</td>
            <td><small><span style="color: ${color.code};">${color.code}</span><small></td>
        </tr>
        </#list>
    </table>
    <hr/>
    <a href="index.html">index page</a>
</body>
</html>
