# 📱 Actividad 12 - App de Sensores

## 📋 Descripción

Esta aplicación para Android está diseñada para interactuar con los sensores del dispositivo. El objetivo principal es aprender a detectar y responder a los datos proporcionados por los sensores de movimiento, aplicando los conocimientos del tema "Sensor" para crear una experiencia de usuario interactiva.

## 🎯 Objetivos de aprendizaje

- 🔌 Integración con los servicios de sensores del dispositivo.
- 👂 Implementación de `SensorEventListener` para recibir y procesar datos de sensores en tiempo real.
- ⚡ Manejo eficiente de los recursos del sistema, registrando y de-registrando los listeners de sensores en los momentos adecuados del ciclo de vida de la Activity.

## 🛠️ Tecnologías utilizadas

- 🤖 Android SDK (API Level 28+)
- ☕ Java
- 🏃 `SensorManager` y `SensorEventListener` para la gestión de sensores.

## 📱 Funcionalidades

- **Detección de Sensores:** La aplicación identifica y utiliza el acelerómetro del dispositivo.
- **Visualización de Datos:** Los datos del sensor (ejes X, Y y Z) se muestran en la interfaz de usuario en tiempo real.
- **Diseño Personalizado:** La app cuenta con una paleta de colores y una tipografía definidas para una experiencia de usuario cohesiva.

---

## ❓ Preguntas de reflexión técnica

### 🔄 ¿Qué diferencia hay entre un sensor de movimiento basado en hardware y uno basado en software?

La diferencia fundamental radica en su origen y composición. Un **sensor basado en hardware** es un componente físico integrado en el dispositivo (como un acelerómetro o un giroscopio) que mide directamente magnitudes físicas como la aceleración o la velocidad de rotación. Por otro lado, un **sensor basado en software** (también conocido como sensor virtual o sintético) no es un componente físico. En su lugar, es una abstracción que procesa y combina datos de uno o más sensores de hardware para derivar una nueva magnitud. Por ejemplo, un sensor de "vector de rotación" puede usar los datos del acelerómetro y el giroscopio para calcular la orientación del dispositivo de forma más precisa que cada sensor por separado.

### 📊 ¿Cómo se puede acceder a los datos del sensor de movimiento en una aplicación Android?

Para acceder a los datos de un sensor en Android, se debe seguir un proceso estándar a través de la API de sensores:
1.  **Obtener el `SensorManager`:** Se obtiene una instancia de `SensorManager` llamando a `context.getSystemService(Context.SENSOR_SERVICE)`.
2.  **Identificar el sensor:** Se obtiene una referencia al sensor deseado (por ejemplo, el acelerómetro) usando `sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)`.
3.  **Implementar `SensorEventListener`:** Se crea una clase que implemente la interfaz `SensorEventListener`. Esta interfaz tiene dos métodos clave: `onAccuracyChanged()` y `onSensorChanged()`.
4.  **Registrar el listener:** Se registra el listener para empezar a recibir datos, llamando a `sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)`. Esto se hace típicamente en el método `onResume()` de la Activity.
5.  **Procesar los datos:** Los datos del sensor se reciben en el método `onSensorChanged(SensorEvent event)`, donde se pueden procesar según las necesidades de la aplicación.
6.  **De-registrar el listener:** Es crucial de-registrar el listener en `onPause()` con `sensorManager.unregisterListener(this)` para ahorrar batería cuando la app no está en primer plano.

### 📱 Menciona tres ejemplos de aplicaciones que utilizan el sensor de movimiento.

1.  **Juegos de carreras (Ej: Asphalt 9, Real Racing 3):** Utilizan el acelerómetro para controlar la dirección del vehículo. Al inclinar el dispositivo, el juego interpreta el cambio en los ejes X/Y como una instrucción para girar, creando una experiencia de conducción inmersiva.
2.  **Aplicaciones de fitness (Ej: Google Fit, Strava):** Usan el acelerómetro de bajo consumo para implementar un podómetro. El sensor detecta los patrones rítmicos de los pasos para contar la actividad física del usuario a lo largo del día, incluso cuando la aplicación está en segundo plano.
3.  **Aplicaciones de brújula y mapas (Ej: Google Maps):** Utilizan el magnetómetro en combinación con el acelerómetro para determinar la orientación del dispositivo (norte, sur, este, oeste). Esto permite que el mapa gire automáticamente para coincidir con la dirección en la que el usuario está mirando.

### 💭 Reflexión personal del tema (mínimo 50 palabras)

La integración con los sensores del dispositivo es una de las características más potentes del desarrollo móvil, ya que permite que el software trascienda la pantalla y reaccione al mundo físico. Comprender la diferencia entre sensores de hardware y software es clave para optimizar el rendimiento y el consumo de batería. La API de sensores de Android, aunque requiere un manejo cuidadoso del ciclo de vida para evitar fugas de recursos, abre un abanico de posibilidades para crear experiencias de usuario verdaderamente interactivas y contextuales, desde juegos inmersivos hasta aplicaciones de salud que mejoran la vida de las personas.