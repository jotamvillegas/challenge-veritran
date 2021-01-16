# Tabla de contenidos
1. [Información General](#Información-general)
2. [Tecnologías](#tecnologias)
3. [Instalación](#instalación)
4. [Ejecución](#ejecución)
5. [Reportes](#reportes)

## 1. Información General
Proyecto basado en un challenge de Veritran, con el propósito de realizar una pequeña automatización sobre la página 
de "Amazon.com".

Versión de automatización: v0.1 

## 2. Tecnologías
Lista de tecnologías usadas en este proyecto:
* [Apache Maven](https://maven.apache.org/): Es una herramienta de gestión y comprensión de proyectos de software. 
  Basado en el concepto de un modelo de objetos de proyecto (POM).

* [Maven Repository](https://mvnrepository.com/): Es el repositorio central de Maven que contiene librerías
  constantemente actualizadas. En Maven es necesario definir todas las dependencias del proyecto 
  (librerías externas utilizadas) en un fichero propio de todo proyecto Maven, llamado POM (Project Object Model). 
  Cuando definimos las dependencias de Maven, éste se encargará de ubicar las librerías que deseamos utilizar. 
  Maven permite incluso buscar versiones más recientes o más antiguas de un código dado y agregarlas a nuestro 
  proyecto. Todo se hará de forma automática sin que el usuario tenga que hacer nada más que definir las dependencias.

* [Selenium Webdriver](https://www.selenium.dev/): Es un entorno de pruebas que se utiliza para comprobar si 
  el software que se está desarrollando funciona correctamente. Esta herramienta permite: grabar, editar y depurar casos 
  de pruebas que se pueden automatizar.

* [TestNG](https://testng.org/doc/): Es una herramienta inspirada en jUnit y nUnit, pero que agrega algunas 
  funcionalidades interesantes para controlar nuestras pruebas. Cabe destacar que testng no es exclusivo de Selenium, 
  de hecho entre sí no tienen nada que ver, aunque se usen mucho juntos, sino que lo podemos utilizar para pruebas 
  unitarias con java, para appium o cualquier otro framework basado en java.

* [Log4J](https://logging.apache.org/log4j/2.x/): Es una biblioteca open source desarrollada en Java por Apache 
  Software Foundation que permite a los desarrolladores de software escribir mensajes de registro, cuyo propósito es 
  dejar constancia de una determinada acción/transacción en tiempo de ejecución.

* [Java](https://www.java.com/es/): Es un Lenguaje programación orientado a objetos, basado en la modularización del 
  código. Tiene 4 conceptos teorico-prácticos como principales bases que son: Herencia, Abstracción, Polimorfismo y 
  Encapsulación.

* [GitHub](https://github.com/): Es un servicio en la nube que sirve para almacenar y administrar nuestro código, 
  al igual que llevar un control de versionado. Una Versión de Control ayuda a los desarrolladores llevar un registro 
  y administrar cualquier cambio en el código del proyecto de software.

## 3. Instalación

#### Pre-Requisitos
* Tener instalado el OpenJDK en nuestra PC. Para nuestro caso (trabajando en ubuntu), se uso la versión JDK v1.8 y 
el archivo se guardó la carpeta /opt de nuestro equipo con permisos de lectura y escritura.
* Crear la variable de entorno JAVA_HOME y configurar el PATH, añadiendo el directorio bin de java a la variable de
entorno JAVA_HOME.
* Tener un IDE instalado para clonar, abrir el proyecto y ejecutar los test. En nuestro caso usamos IntelliJ, podes 
  usar el IDE con el que te sientas más familiarizado.
* Tener instalado Git para la administración del versionado y/o clonación del repositorio remoto.

#### Clonando nuestro proyecto desde GitHub
* Creamos una carpeta donde vamos a clonar nuestro proyecto.
* Ingresamos a la dirección de git que contiene nuestro proyecto: 
``` 
https://github.com/jotamvillegas/challenge-veritran.git 
```
* Copiamos la URL para la clonación, como se visualiza en la imágen:

![clonProjectGithub](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/cloneProject.png)
  
* Abrimos nuestro IDE y en la terminal nos posicionamos en la ubicación de nuestra carpeta creada para poder clonar 
  nuestro proyecto: 
  
![locationProject](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/locationProject.png)
  
* Escribimos o copiamos el siguiente comando, y presionamos "Enter".
``` 
git clone https://github.com/jotamvillegas/challenge-veritran.git
```
* Nuestro proyecto se clonara en nuestra carpeta contendora creada anteriormente.

#### Configurando el SetUp
* Descargar el [ChromeDriver](https://chromedriver.chromium.org/) según la versión del navegador que tenemos. Para 
  nuestro caso utilizamos el navegador chrome versión 87.0.4280.141. 
  
  **NOTA:** 
  * Si tenés el mismo navegador con distinta versión, verifica que la descarga sea apta para el mismo. 
  * Si tenes otro navegador, descarga el driver correspondiente.
  
* Una vez descargado y extraido del archivo .zip/.rar, reemplaza la carpeta contenedora en la siguiente ruta de nuestro
  proyecto:
  
```
/home/Jotam/Automation/ChallengeVeritran/src/main/resources
```

![pathDriverLocation](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/pathDriver.png)

* Teniendo abierto el proyecto en nuestro IDE, ingresar a la clase "_General_" del package "_Helper_" y modificar la 
  variable "_pathChromeDriver_" con el path del chromeDriver que hay en la carpeta contenedora. Ej:
```
Chrome driver 87.0.4280.88/chromedriver_linux64/chromedriver
```

![pathDriverLocation](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/pathDriverClassGeneral.png)

* Si llegaste hasta aca, **_Felicidades!!_** ... vamos bien!

## 4. Ejecución
Para ejecutar nuestra suite de test, seguiremos los siguientes pasos:
* Estando en nuestro proyecto, nos aseguramos que:
  * Las dependencias del archivo pom.xml se hayan descargado correctamente.

![pathDriverLocation](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/dependencies.png)
  
  * Verificar que el la configuración de ejecución sea la correcta. Como las imagenes siguientes lo muestran

![pathDriverLocation](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/runConfig01.png)
![pathDriverLocation](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/runConfig02.png)

* Ahora si ejecutamos nuestra  suite de test. Para eso ubicamos en nuestra raiz de proyecto el archivo "_SuiteGeneral.xml_", 
damos click derecho y luego click en "_Run_"

![pathDriverLocation](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/runSuite.png)
  
* Si todo se ha configurado correctamente, veremos que empieza la automatización de nuestra suite de tests.

## 5. Reportes
Para la visualización de reportes de nuestros test, seguimos los siguientes pasos:
* Nos dirijimos a la carpeta contenedora de nuestro archivo e ingresamos a la carpeta "_TestOutput_".

![pathDriverLocation](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/report01.png)

* Damos click en el archivo "_emailable-report.html_". Se nos abrira el reporte de las test en nuestro navegador.

![pathDriverLocation](https://github.com/jotamvillegas/challenge-veritran/blob/master/src/main/resources/readmeImages/report02.png)

* Con esto habremos culminado la automatización!

### Muchas Gracias!!