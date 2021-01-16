# Tabla de contenidos
1. [Información General](#Información-general)
2. [Tecnologías](#tecnologias)
3. [Instalación](#instalación)
4. [Ejecución](#ejecución)


## 1. Información General
Proyecto basado en un challenge de Veritran, con el propósito de realizar una pequeña automatización sobre la página 
de "Amazon.com".

Versión de automatización: v0.1 

## 2. Tecnologías
***
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
***
#### Pre-Requisitos
* Tener instalado el OpenJDK en nuestra PC. Para nuestro caso que trabajamos en ubuntu, se uso la versión JDK v1.8 y 
el archivo se guardó la carpeta /opt de nuestro equipo.
* Crear la variable de entorno JAVA_HOME y configurar el PATH, añadiendo el directorio bin de java a la variable de
entorno JAVA_HOME.
* Tener un IDE instalado para abrir el proyecto y ejecutar los test. En nuestro caso usamos IntelliJ, podes usar el
IDE con el que te sientas más familiarizado.
* Tener instalado Git para la administración del versionado y/o clonación del repositorio remoto.

#### Levantando nuestro proyecto
  * ![Reportes](https://github.com/jotamvillegas/ChallengeVeritran/src/main/resources/readmeImages/results.png)

#### SetUp
* Descargar el [ChromeDriver](https://chromedriver.chromium.org/) según la versión del navegador que tengas. 
* Una vez descargado y extraido del archivo .zip/.rar, copiar la carpeta contenedora en el siguiente path del proyecto:
```
/home/Jotam/Automation/ChallengeVeritran/src/main/resources
```
* Ingresar a la clase "_General_" del package "_Helper_" y modificar la variable "_pathChromeDriver_" con el path del 
chromeDriver que hay en la carpeta contenedora. Ej:
```
Chrome driver 87.0.4280.88/chromedriver_linux64/chromedriver
```

## 4. Ejecución
***
