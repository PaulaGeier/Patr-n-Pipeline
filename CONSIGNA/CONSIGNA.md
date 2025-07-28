# ✅ Consigna: Validación de Clientes con el Patrón Pipeline (Java + Spring Boot)

## 🎯 Objetivo

Implementar una API REST utilizando **Spring Boot** que reciba información de clientes y aplique una serie de validaciones utilizando el **patrón de diseño Pipeline (Chain of Responsibility)**.

## 🧠 ¿Qué es el Patrón Pipeline?

Este patrón permite encadenar una serie de pasos (validaciones, transformaciones, etc.) que se ejecutan uno tras otro. Cada paso decide si continuar la ejecución o detener el flujo. Es ideal para desacoplar reglas de negocio y mejorar la extensibilidad del código.

---

## 🧪 Requisitos funcionales

Tu aplicación debe exponer un **endpoint POST** que reciba un objeto `Cliente` con los siguientes campos:

```json
{
  "nombre": "string",
  "email": "string",
  "edad": number
}
```
Y validar lo siguiente:

✅ El nombre no debe estar vacío ni contener solo espacios.

✅ El email debe tener un formato válido.

✅ La edad debe ser mayor o igual a 18 años.

---
## 🏗 Estructura del proyecto

```css

├── src/
│   ├── main/
│   │   ├── java/com/example/pipeline_validation/
│   │   │   ├── controller/ClienteController.java
│   │   │   ├── model/Cliente.java
│   │   │   ├── pipeline/
│   │   │   │   ├── Validador.java
│   │   │   │   ├── NombreValidador.java
│   │   │   │   ├── EmailValidador.java
│   │   │   │   ├── EdadValidador.java
│   │   │   │   └── PipelineService.java
│   │   │   └── PipelineValidationApplication.java
├── pom.xml
└── README.md

```

---
## 🛠️ Requisitos técnicos
- Usar Java 17+.

- Usar Spring Boot.

- Aplicar el patrón Pipeline para implementar las validaciones.

- Cada validación debe ser una clase independiente que implemente una interfaz común.

- Las validaciones deben ejecutarse en orden, y si alguna falla, detener el flujo y devolver un mensaje de error apropiado.

---

## 📤 Endpoint esperado

POST /clientes

- Content-Type: application/json

- Body:

```json
{
  "nombre": "Juan Pérez",
  "email": "juan@mail.com",
  "edad": 25
}
```
- Respuesta esperada (200 OK):
```json
{
  "mensaje": "Cliente validado correctamente"
}
```
- Si alguna validación falla (Ej: edad < 18), debe responder con 400 Bad Request y un mensaje como:

```json
{
  "error": "El cliente debe ser mayor de 18 años"
}
```
---

## 🧩 Extra (opcional)
- Agregá validaciones adicionales, como que el nombre contenga al menos 3 caracteres o que el email no pertenezca a dominios no permitidos.

- Escribí tests unitarios para los validadores.

---
## ¡Buena suerte! 🚀