# PokeBatalla

## Descripción
En este juego, podras combatir en una increible batalla con otra los pokemones contricantes. Podras aplicar habilidad, items y pociones. ¡Quien se quede sin pokemones pierde!

## Requisitos Previos

Asegúrate de cumplir con los siguientes requisitos previos antes de ejecutar este proyecto:

1. **Java Development Kit (JDK):** Asegúrate de tener una versión de Java 17 o superior instalada en tu sistema. Puedes descargarlo desde [el sitio web de Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) o utilizar una distribución OpenJDK.

2. **Maven:** Este proyecto utiliza Apache Maven como sistema de gestión de construcción. Si no tienes Maven instalado, puedes descargarlo desde [la página oficial de Apache Maven](https://maven.apache.org/download.cgi) e instalarlo siguiendo las [instrucciones de instalación](https://maven.apache.org/install.html).

3. **Slf4j (Simple Logging Facade for Java):** Este proyecto utiliza SLF4J para la gestión de registros. No es necesario realizar ninguna configuración adicional, ya que las dependencias se manejan automáticamente a través de Maven.

4. **Googlecode json-simple:** Es necesario para que el parser lea correctamente los archivos JSON.

Una vez que hayas instalado y configurado estos requisitos previos, podrás construir y ejecutar el proyecto sin problemas.

## Instalación

Proporciona instrucciones detalladas sobre cómo instalar el programa. Incluye todos los comandos necesarios y ejemplos.

```bash
git clone https://github.com/Nicomp04/PokeBatalla.git
cd PokeBatalla

```bash
mvn clean install

```bash
cd ../PokeBatalla/target
java -jar PokeBatalla.jar

