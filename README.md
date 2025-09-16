# Java PLATZI PLAY 🎬

¡Bienvenido a **PLATZI PLAY**! Este es un proyecto de consola en Java donde puedes gestionar un catálogo de películas, documentales y libros (de ejemplo), inspirado en plataformas de streaming. Fue creado como repaso y práctica de conceptos de Java, manejo de archivos, enums, records, herencia, excepciones personalizadas y menús interactivos.

## Características principales

- **Agregar películas** al catálogo con título, género, duración, calificación e idioma.
- **Agregar documentales** con narrador, género, duración, calificación e idioma.
- **Mostrar películas** en el catálogo de forma ordenada.
- **Buscar películas** por título, género o idioma.
- **Eliminar películas** del catálogo.
- **Reproducir películas** (simulado por consola).
- **Persistencia automática:** Las películas y documentales se guardan y cargan desde el archivo `contenido.txt`.
- **Soporte para libros:** Ejemplo de lectura de libros desde archivo plano.
- **Manejo de excepciones personalizadas** (por ejemplo, película duplicada).
- **Colores y emojis** en el menú para una experiencia más divertida.

## Estructura del proyecto

```
JavaRepaso/
├── src/
│   ├── javarepaso/
│   │   ├── JavaRepaso.java         # Main con menú y lógica principal
│   │   └── util/
│   │       ├── FileUtils.java     # Utilidades para leer/escribir archivos
│   │       └── ScannerUtils.java  # Utilidades para capturar datos por consola
│   │   └── plataforma/
│   │       └── Plataforma.java    # Lógica de catálogo
│   │   └── contenido/
│   │       ├── Pelicula.java      # Clase Pelicula
│   │       ├── Documental.java    # Clase Documental (hereda de Subdiviccion)
│   │       ├── Genero.java        # Enum de géneros
│   │       ├── Idioma.java        # Enum de idiomas
│   │       ├── ResumenContenido.java # Record resumen
│   │       └── Libro.java         # Clase de ejemplo para libros
│   └── contenido.txt              # Archivo plano de películas/libros
```

## Ejemplo de uso

1. **Al iniciar:** Se cargan las películas desde `contenido.txt`.
2. **Agregar:** Puedes agregar películas desde el menú y se guardan automáticamente.
3. **Eliminar:** Al eliminar una película, el archivo se actualiza.
4. **Buscar:** Puedes buscar por título, género o idioma.
5. **Persistencia:** Todo lo que agregues o elimines se mantiene para la próxima ejecución.

## Ejemplo de formato de archivo `contenido.txt`

```
El Señor de los Anillos|FANTASIA|120|4.8|ESPANOL
Avatar|ACCION|162|4.5|ESPANOL
Titanic|DRAMA|194|4.1|INGLES
Interestelar|ACCION|169|4.6|INGLES
Matrix|ACCION|136|4.7|INGLES
```

## ¿Qué aprendiste/practicaste aquí?
- Organización de proyectos Java por paquetes.
- Uso de enums, records y herencia.
- Manejo de excepciones personalizadas.
- Lectura y escritura de archivos de texto.
- Menús interactivos en consola.
- Persistencia simple de datos.
- Buenas prácticas de código y comentarios.
- Implementación de clases hijas como Documental y su interfaz Promocionable.

---

¡Disfruta tu plataforma de películas en consola! Siéntete libre de expandirla con series, documentales, usuarios o lo que imagines 🚀
