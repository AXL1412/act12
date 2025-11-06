# 📱 Actividad 12 - App de Notificaciones SMS

## 📋 Descripción

Esta aplicación para Android está diseñada para monitorear los mensajes SMS entrantes y generar notificaciones en la barra de estado. El objetivo principal es aprender a interactuar con los servicios del sistema operativo, como la recepción de broadcasts y la gestión de notificaciones.

## 🎯 Objetivos de aprendizaje

-  🔌 Integración con servicios del dispositivo y APIs del sistema.
-  📡 Implementación de `BroadcastReceivers` para responder a eventos del sistema (SMS entrantes).
-  🔔 Creación y gestión de notificaciones utilizando el `NotificationManager`.
-  ⚡ Manejo eficiente de hilos para operaciones que no deben bloquear el hilo principal.

## 🛠️ Tecnologías utilizadas

-  🤖 Android SDK (API Level 28+)
-  ☕ Java
-  📡 `BroadcastReceiver` para la intercepción de SMS.
-  🔔 `NotificationManager` para la visualización de notificaciones.

## 📱 Funcionalidades

-  **Recepción de SMS:** La aplicación escucha activamente los mensajes SMS entrantes en el dispositivo.
-  **Notificaciones instantáneas:** Al recibir un SMS, se genera una notificación clara y visible en la barra de estado.
-  **Diseño personalizable:** La aplicación cuenta con una paleta de colores y una tipografía definidas para una experiencia de usuario cohesiva.

---

## ❓ Preguntas de reflexión técnica

### 🔄 ¿Qué diferencia hay entre un sensor de movimiento basado en hardware y uno basado en software?

La diferencia fundamental radica en su origen y composición. Un **sensor basado en hardware** es un componente físico integrado en el dispositivo (como un acelerómetro o un giroscopio) que mide directamente magnitudes físicas como la aceleración o la velocidad de rotación. Por otro lado, un **sensor basado en software** (también conocido como sensor virtual o sintético) no es un componente físico. En su lugar, es una abstracción que procesa y combina datos de uno o más sensores de hardware para derivar una nueva magnitud. Por ejemplo, un sensor de "detección de inclinación" puede usar los datos del acelerómetro y el magnetómetro para calcular la orientación del dispositivo.

### 📊 ¿Cómo se puede acceder a los datos del sensor de movimiento en una aplicación Android?

Para acceder a los datos de un sensor en Android, se debe seguir un proceso estándar a través de la API de sensores:
1.  **Obtener el `SensorManager`:** Se obtiene una instancia de `SensorManager` llamando a `context.getSystemService(Context.SENSOR_SERVICE)`.
2.  **Identificar el sensor:** Se obtiene una referencia al sensor deseado (por ejemplo, el acelerómetro) usando `sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)`.
3.  **Implementar `SensorEventListener`:** Se crea una clase que implemente la interfaz `SensorEventListener`. Esta interfaz tiene dos métodos clave: `onAccuracyChanged()` y `onSensorChanged()`.
4.  **Registrar el listener:** Se registra el listener para empezar a recibir datos, llamando a `sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)`.
5.  **Procesar los datos:** Los datos del sensor se reciben en el método `onSensorChanged(SensorEvent event)`, donde se pueden procesar según las necesidades de la aplicación.
6.  **De-registrar el listener:** Es crucial de-registrar el listener en `onPause()` con `sensorManager.unregisterListener(this)` para ahorrar batería cuando la app no está en primer plano.

### 📱 Menciona tres ejemplos de aplicaciones que utilizan el sensor de movimiento.

1.  **Juegos de carreras (Ej: Asphalt 9):** Utilizan el acelerómetro para controlar la dirección del vehículo. Al inclinar el dispositivo, el juego interpreta el cambio en los ejes X/Y como una instrucción para girar a la izquierda o a la derecha.
2.  **Aplicaciones de fitness (Ej: Google Fit, Strava):** Usan el acelerómetro (y a veces el giroscopio) para implementar un podómetro. Detectan los patrones rítmicos de los pasos para contar cuántos ha dado el usuario a lo largo del día.
3.  **Aplicaciones de fotografía (Ej: Google Camera):** Utilizan el giroscopio para la estabilización de imagen. El sensor detecta pequeños temblores de la mano y el software de la cámara los compensa en tiempo real para evitar fotos y videos borrosos.

### 💭 Reflexión personal del tema (mínimo 50 palabras)

La integración con los sensores del dispositivo es una de las características más potentes del desarrollo móvil, ya que permite que el software trascienda la pantalla y reaccione al mundo físico. Comprender la diferencia entre sensores de hardware y software es clave para optimizar el rendimiento y el consumo de batería. La API de sensores de Android, aunque requiere un manejo cuidadoso del ciclo de vida y los permisos, abre un abanico de posibilidades para crear experiencias de usuario verdaderamente interactivas y contextuales, desde juegos inmersivos hasta aplicaciones de salud y bienestar que mejoran la vida de las personas.