<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <title>Nuevo Curso</title>
</head>
<body>
<h1>Nuevo curso</h1>
<form>
    <label id="active">Activo
        <input type="checkbox"/>
    </label>
    <label>Profesor
        <select>
            <option>Profesor 1</option>
            <option>Profesor 2</option>
            <option>Profesor 3</option>
        </select>
    </label>
    <label>Título
        <input type="text"/>
    </label>
    <label>Nivel
        <select>
            <option>Fácil</option>
            <option>Intermedio</option>
            <option>Difícil</option>
        </select>
    </label>
    <label>Horas
        <input type="number" min="0"/>
    </label>
</form>
</body>
</html>
