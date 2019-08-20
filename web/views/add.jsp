<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <title>Nuevo Curso</title>
</head>
<body>
<h1>Nuevo curso</h1>
<form method="post">
    <label>Activo
        <input type="checkbox" name="active" value="active"/>
    </label>
    <label>Título
        <input type="text" name="title"/>
    </label>
    <label>Profesor
        <select name="professor">
            <option>Profesor 1</option>
            <option>Profesor 2</option>
            <option>Profesor 3</option>
        </select>
    </label>
    <label>Nivel
        <select name="level">
            <option value="EASY">Fácil</option>
            <option value="INTERMEDIATE">Intermedio</option>
            <option value="HARD">Difícil</option>
        </select>
    </label>
    <label>Horas
        <input type="number" min="0" name="hours"/>
    </label>
    <button type="submit">Añadir</button>
</form>
</body>
</html>
