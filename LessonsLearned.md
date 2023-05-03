# Pasos previos

0. En los puntos que he tenido alguna dificultad, o me he atascado he añadido _Nota_ o **Duda**:
1. 
1. Instálate
    1. IntelliJ Community: https://www.jetbrains.com/idea/download
       1. Con este plugin:https://plugins.jetbrains.com/plugin/8527-google-java-format
        _Nota_: Mas configuracion para el formateo de codigo es necesaria:https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config
       2. _Nota_: Plugin para aprender shortcuts mientras se usa Intelij: https://plugins.jetbrains.com/plugin/9792-key-promoter-x
   
   3. Postman: https://www.postman.com/downloads/
    3. Docker: https://docs.docker.com/desktop/previous-versions/3.x-windows/ y falta tambien instalar VSL2 para poder arrancar un linux desde Windows: https://learn.microsoft.com/en-us/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package
   
2. Clónate el repositorio: ```git clone https://github.com/capCCA/training.git```
3. Créate una nueva rama. Sustituir la palabra *apellidoNombre* por tus datos.
    1. Comando: ```git branch apellidoNombre```
   2.  _Nota_: acepta la invitacion al proyecto git donde hay una rama ya creada para cada uno
   3.  _Nota_:  descargate tu rama remota: ```git checkout -b feature/apellidoNombre```
4. Ejecuta el siguiente comando para verificar que el proyecto compila correctamente.
    1. Comando: ```mvn clean install```
5. Realiza un *initial commit*.
    1. Comandos:
        1. ```git add *```
        2. ```git commit -m "Initial commit."```
        3. ```git push ```
       4. _Nota_: ```git push origin feature/appellidosNombre```

# Ejercicio

Vamos a realizar dos microservicios donde desarrollaremos funcionalidades relacionadas con usuarios y pagos.

Cada tarea indica el número de días que invertiremos en el aprendizaje y desarrollo de la funcionalidad.

## Tarea 0: día 1, día 2 y día 3

1. Video de SQL desde cero. Descargar el siguiente programa para seguir el video y realizar los ejercicios que va mostrando el profesor. Anotar todas las dudas que tengáis para preguntarlas en la próxima sesión, si hay alguna que es bloqueante levantar la mano a través del Teams.
    1. https://sqlitebrowser.org/dl/
    2.  <https://www.youtube.com/watch?v=DFg1V-rO6Pg&ab_channel=SoyDalto> (2
        días)
2. Video sobre comandos git, conocimiento durante todo el proyecto.
    1. <https://www.youtube.com/watch?v=3GymExBkKjE&t=10150s&ab_channel=MoureDevbyBraisMoure>
   (1 día)
    2. _Nota_: para ir más rápido no hace falta configurar tu .ssh si usas herramientas gráficas como Github desktop, o  desde Eclipse( usa vista gitstaging) o desde Intelij.
       


## Tarea 1: día 4

1.  Crear la paquetería base haciendo uso de la arquitectura MVC
2.  Crear un controlador dummy tipo GET con nombre ```/hello```
3.  Levantar el microservicio en local
4.  Mediante el uso de Postman lanzar una petición contra el endpoint hello
5. _Nota_: Se pide más tarde no usar @Autowired, hacer lo mismo con Lombok. Aquí ves como
   https://www.dev-util.com/java/spring-framework/inyeccion-de-dependencias-autowired-o-por-constructor-en-spring
6. Ejemplo, donde X es immutable:
`   
   @Autowired X x;
   private final X x; 
   con @RequiredArgsConstructor en la clase..`

## Tarea 2: día 5

1.  Crear la conexión a la base de datos con docker
    1. Comando: ```docker-compose up -d```
2.  Conéctate a través del browser a la base de datos Postgres que has creado en el punto 1: http://localhost:9090/?pgsql=postgres&username=postgres (usuario: *postgres*, contraseña: *password*)
    1. Haz clic en *Crear Base de datos* y pon el nombre `training_db`.
3.  Crear el siguiente modelo dentro de la base de datos que has creado en el punto anterior (utiliza lo aprendido en la *Tarea 0*)

#### User
| Field name                                         | customer_id (primary key) | Document_type | Document_number | Name         | SurName      | LastName     | Country    | Telephone | Creation_date | Update_date |
|----------------------------------------------------|---------------------------|---------------|-----------------|--------------|--------------|--------------|------------|-----------|---------------|-------------|
| Allowed Values                                     |                           | DNI, passport |                 |              |              |              |            |           |               |             |
| Allowed nulls                                      | Not null                  | Not null      | Not null        | Not null     | Not null     |              | Not null   |           | Not null      |             |
| Type (if it empties, it will be your own election) | varchar(10)               | varchar(8)    | varchar(50)     | varchar(100) | varchar(100) | varchar(100) | varchar(3) | integer   | TimeStamp     | TimeStamp   |

#### Payment
| Field name                                         | Payment_id  (primary key) | Customer_id        | Beneficiary_id            | Payment_type    | Amount   | Creation_date | Update_date |
|----------------------------------------------------|---------------------------|--------------------|---------------------------|-----------------|----------|---------------|-------------|
| Allowed Values                                     |                           | Must be a User row | Must be a Beneficiary row | bizum, transfer |          |               |             |
| Allowed nulls                                      | Not null                  | Not null           | Not null                  | Not null        | Not null | Not null      |             |
| Type (if it empties, it will be your own election) | BigSerial                 | varchar(10)        | varchar(10)               | varchar(10)     | decimal  | TimeStamp     | TimeStamp   |

#### Beneficiary
| Field name                                         | Beneficiary_id  (primary key) | Creation_date | Update_date |
|----------------------------------------------------|-------------------------------|---------------|-------------|
| Allowed Values                                     |                               |               |             |
| Allowed nulls                                      | Not null                      | Not null      |             |
| Type (if it empties, it will be your own election) | varchar(10)                   | TimeStamp     | TimeStamp   |

1. La columna Customer_id de la tabla payment se relaciona con la columna Customer_id de la tabla customer.   <br>
2. La columna Beneficiary_id de la tabla payment se relaciona con la columna Beneficiary_id de la tabla beneficiary.

**El campo customerId damos por supuesto que va a tener una longitud de 10 dígitos numéricos. (No hace falta controlarlo en el código ni a nivel de base de datos).**

## Tarea 3: día 6

1. Crear los siguientes controladores haciendo uso de Lombok. 
   1. Obtener información de un usuario. Método GET, como parámetro de entrada en la URL el {customerId}. Devuelve un objeto Customer. 
   2. Creación de un usuario. Método POST, como body de entrada un objeto Customer (Mismo objeto que devuelve el punto a). 
   3. Actualización de un usuario. Método PUT, como body de entrada un objeto Customer. 
   4. Borrado de un usuario. Método Delete, como parámetro de entrada en la URL el {customerId}.
2. Crear tantos servicios como controladores tenemos en el punto 1 (usa lombok para la inyección de dependencias).

**Nota**: Utilizar interfaces solamente para la definición de los repositorios. No usar interfaces para la definición de controladores ni de servicios.

## Tarea 4: día 7 (dudas)

1.  Crear un repositorio que accede a la base de datos `training_db` con los métodos necesarios para dar servicio a la lógica de negocio. Hacer uso de JPA para la creación de repositorios.
2.  Crear los mappers para separar las entidades de los repositorios para desacoplar el código de nuestra aplicación.

**Nota1**: Utilizar interfaces solamente para la definición de los repositorios. No usar interfaces para la definición de 
controladores ni de servicios. <br>
**Nota2**: No usar mapStruct, sino mappers custom.<br>
**Nota3**: Siempre que tengamos que iterar sobre algo usar streams (programación funcional). No usar for, while, dowhile, etc.

3._Duda_ 1: No se cual es la url para conectar a BBDD prostgres desde la aplicacion.
desde el browser nos conectamos con http://localhost:9090/?pgsql=postgres&username=postgres&db=training_db
Muestro application.properties

```#Load database that is not embedded
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:9090/training_db
#spring.datasource.url=jdbc:postgresql://localhost:9090/?pgsql=postgres&username=postgres&db=training_db
spring.datasource.username=postgres
spring.datasource.password=password`
```
4. _Duda_ 2: Si no se usa un numero para el ID de las entities sino un String,como es el caso para Beneficiary y User, 
>el JPARepository como se usa si el ID es String
> 
>ya que no se puede usar @GeneratedValue que haga el autoincrement y se hace manualmente?


## Tarea 5: día 8 y día 9

1.  Realizar todos los tests unitarios de todas las clases.

**Nota**: Mockear todas las dependencias a la clase que se quiere testear.

## Tarea 6: dia 10 y dia 11

1. Crear un nuevo microservicio para toda la funcionalidad de payments (arquitectura MVC).
    1. Listado de todos los pagos de un cliente.
    2. Update de un pago.
    3. Inserción de un nuevo pago.

## Tarea 7: día 12

1.  Creación de los test de la tarea 6 usando jUnit y Mockito.

## Tarea 8: día 13

1. Teoría de la arquitectura DDD (Domain Driver Desing).
    1. Buscar todos los videos necesarios donde expliquen esto. 
       1. DDD en 20 min:
          1. https://www.youtube.com/watch?v=dH5aSQLXtKg&t=24s&ab_channel=CodelyTV-Redescubrelaprogramaci%C3%B3n
       2. Rigor Talks en Php pero son conceptos básicos:
          1. https://www.youtube.com/watch?v=dH5aSQLXtKg&t=24s&ab_channel=CodelyTV-Redescubrelaprogramaci%C3%B3n
       3. Qué es la arquitectura hexagona y cómo aplicarla:
          1. https://www.youtube.com/watch?v=dH5aSQLXtKg&t=24s&ab_channel=CodelyTV-Redescubrelaprogramaci%C3%B3n
       4. Clean architecure:
          1. https://www.youtube.com/watch?v=dH5aSQLXtKg&t=24s&ab_channel=CodelyTV-Redescubrelaprogramaci%C3%B3n

**Repo de referencia:** https://github.com/sandokandias/spring-boot-ddd 

## Tarea 9: día 14 y día 15

1. Criterio del formador para refactorizar la arquitectura DDD o repasar temas que crea que no están suficientemente preparados. *Improvisar*
