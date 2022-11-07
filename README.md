# MISW4203-Vinilos-Grupo18

Vinyls es una aplicación que permite la visualización y gestión de información relacionada con música, como por ejemplo álbumes, artistas, coleccionistas	, entre otros. Para la versión móvil se usará una API REST que está previamente desarrollada y es muy similar a la API que estamos usando en la versión web de Vinilos.

Puede encontrar más información sobre el proyecto en la wiki https://github.com/manuel-morales-sa/MISW4203-Vinilos/wiki

## Instrucciones para construir la aplicación de forma local

1. Tener instalado Android Studio (Guía https://misovirtual.virtual.uniandes.edu.co/codelabs/android-setup-tutorial/index.html#2)
2. Clonar el repositorio
3. Abrir el proyecto con Android Studio
4. Sincronizar el archivo build.gradle para configurar las versiones de los sistemas de su máquina
5. Ejecutar la aplicación mediante alguna de las siguientes formas:
    1. **Ejecución en un celular:** Descargue el archivo **app-debug.apk** que se encuentra en la raiz del proyecto en su celular e instalelo. Una vez instalado, asegurese de tener conexión a internet para ejecutar la aplicación.
    2. **Ejecución en el emulador de Android Studio:** Puede ejecutar la aplicación desde un emulador Android desde Android Studio, solo debe crearlo, seleccionarlo y ejecutarlo. Para ello puede seguir las intrucciones del siguiente link https://developer.android.com/codelabs/kotlin-android-training-get-started#5
    3. **Emulación de la aplicación en un celular:** Puede usar su dispositivo Android como emulador y ejecutar la aplicación desde su máquina. Para ello siga las instrucciones del siguiente link https://developer.android.com/studio/debug/dev-options
    
## Instrucciones para ejecutar las pruebas E2E en Espresso

1. Desde Android Studio se deben ejecutar los archivos existentes en la carpeta: 'app/src/androidTest/java/com.example.vinilos/album.test/'
Cada archivo de esta ubicación representa un escenario de pruebas 
2. Hacer click derecho en cada archivo de pruebas
3. Hacer click en 'Run "Test in ..."
