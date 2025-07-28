# 🧪 Validación de Clientes con Patrón Pipeline (Java + Spring Boot)

Este repositorio está organizado para ayudarte a comprender y aplicar el **patrón de diseño Pipeline (o Chain of Responsibility)** en un proyecto Java con Spring Boot.

🔹 La carpeta `CONSIGNA` contiene la descripción del ejercicio propuesto.  
🔹 La carpeta `EJERCICIO RESUELTO` incluye la solución implementada usando Spring Boot.  
🔹 El archivo `README.md` (este archivo) explica el funcionamiento del proyecto, cómo ejecutarlo y los conceptos detrás del patrón utilizado.

Este proyecto demuestra cómo aplicar el patrón Pipeline para validar datos de clientes en una API REST.

---

## 🧠 ¿Qué es el patrón Pipeline?

Es un patrón de diseño que permite procesar una secuencia de pasos (validaciones, transformaciones, etc.) de manera desacoplada y extensible. Cada paso en la "cadena" recibe una entrada, realiza una acción y pasa el control al siguiente.

---

## 💡 ¿Qué hace esta app?

Recibe un objeto `Cliente` vía HTTP POST y lo somete a una serie de validaciones:

1. El nombre no debe estar vacío.
2. El email debe tener un formato válido.
3. La edad debe ser mayor o igual a 18.

---

## 📦 Estructura del código

- `Validador.java`: Interfaz que define un paso en el pipeline.
- `NombreValidador`, `EmailValidador`, `EdadValidador`: Implementaciones concretas del pipeline.
- `PipelineService`: Ejecuta la cadena de validadores.
- `ClienteController`: Controlador REST que recibe los datos y ejecuta la lógica.

---

## ▶️ Cómo ejecutar

1. Clona el repositorio.
2. Ejecuta con Maven:

```bash
./mvnw spring-boot:run
```

#### Opciones para probarlo:
🧪 *Opción A*: Usar curl en la terminal

```bash
curl -X POST http://localhost:8080/clientes \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Juan Pérez", "email":"juan@mail.com", "edad":25}'
```
🧪 *Opción B*: Usar Postman o Insomnia
Método: POST

- URL: http://localhost:8080/clientes

- Body: raw JSON (seleccioná tipo application/json)

- Pegá el cuerpo como este:

```json
{
  "nombre": "Juan Pérez",
  "email": "juan@mail.com",
  "edad": 25
}
```

## 📚 ¿Por qué usar este patrón?
- Permite agregar o quitar validaciones fácilmente.

- Cada validador está desacoplado. 

- Mejora la mantenibilidad del código.