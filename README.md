README.md
# 🌄 Actividad1_PFG

Aplicación **Spring Boot 3.3.4 (Java 21)** con **Thymeleaf**.  
CRUD simple usando **listas en memoria** (sin base de datos) para la gestión de excursiones.

---

## 🧩 Descripción del proyecto

Este proyecto fue desarrollado como práctica de Spring Boot con vistas Thymeleaf.  
Permite **listar**, **añadir**, **editar** y **eliminar excursiones** de forma dinámica desde la interfaz web.  
No requiere base de datos: los datos se mantienen en listas en memoria.

**Objetivos principales:**
- Aprender arquitectura MVC con Spring Boot.  
- Usar Thymeleaf para renderizar vistas HTML dinámicas.  
- Aplicar buenas prácticas de organización de código.

---

## 🛠️ Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3.3.4**
- **Thymeleaf**
- **Maven**
- **Bootstrap 5** (para el diseño visual)
- **Spring DevTools** (para recarga automática en desarrollo)

---

## 🚀 Cómo ejecutar el proyecto

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/PeterAdans/Actividad1_PFG.git
cd Actividad1_PFG

.\mvnw spring-boot:run
🖼️ Capturas de la aplicación
Menú principal

Excursiones destacadas

Detalle de excursión

Nueva excursión

Actividad1_PFG/
 ├─ src/main/java/               # Código fuente Java
 │   ├─ excursionweb/
 │   │   ├─ controller/          # Controladores MVC
 │   │   ├─ modelo/dao/          # Acceso a datos (repositorios o listas)
 │   │   └─ modelo/javabean/     # Entidades o clases modelo
 │
 ├─ src/main/resources/
 │   ├─ static/                  # Recursos estáticos (CSS, JS, imágenes)
 │   ├─ templates/               # Vistas Thymeleaf (.html)
 │   └─ application.properties   # Configuración de Spring Boot
 │
 ├─ src/test/java/               # Pruebas unitarias
 │
 ├─ docs/                        # 🖼️ Capturas de la aplicación (para GitHub)
 │   ├─ destacados.png
 │   ├─ detalles.png
 │   ├─ menu.png
 │   └─ nuevaExcursion.png
 │
 ├─ pom.xml                      # Configuración de Maven
 ├─ README.md                    # Documentación del proyecto
 ├─ HELP.md
 ├─ mvnw / mvnw.cmd              # Maven Wrapper
 └─ target/                      # Archivos generados al compilar
👤 Autor

Pedro Adán Fuentes Guerrero
💼 Desarrollador Java | Spring Boot | Frontend con Thymeleaf
