# DAM M03 - UF6 - Aplicación "librería" y base de datos con JDBC

## Descripción
Aplicación de consola que permite gestionar una librería. La aplicación permite realizar las siguientes operaciones:

- Restaurar la base de datos a su estado inicial
- Listar todos los autores
- Listar todos los libros
- Modificar un autor
- Eliminar un libro

Al iniciarse la aplicación, se crea la base de datos si no existe y se insertan los datos de prueba en las tablas.

## Estructura de la base de datos
La base de datos está formada por las siguientes tablas:

- `autor`: contiene los datos de los autores
- `libro`: contiene los datos de los libros

## Requisitos
- Java 16
- MySQL 8.0.25

## Instalación
1. Clonar el repositorio
2. Importar el proyecto en NetBeans/Eclipse
3. Compilar y ejecutar el proyecto

## Uso
Al ejecutar el proyecto, se muestra un menú con las opciones disponibles. Para seleccionar una opción, introducir el número correspondiente y pulsar `Enter`.

## Licencia
[MIT](LICENSE.MD)
