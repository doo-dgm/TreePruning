# Tree Pruning

**Tree Pruning** es un sistema web para la gestión del arbolado urbano del municipio de Rionegro, Antioquia. Permite al municipio registrar y mantener el inventario de árboles georreferenciados, programar y ejecutar podas preventivas y correctivas, gestionar PQR ciudadanas sobre el estado del arbolado, y generar reportes institucionales del estado del arbolado urbano.

El sistema atiende a tres actores: **Administrador del sistema**, **Encargado de cuadrilla** y **Ciudadano**, cada uno con acceso restringido a los módulos correspondientes a su rol mediante control de acceso basado en roles (RBAC).

La arquitectura adoptada es **Layered N-capas** con patrón de componentes independientes en la capa de negocio, complementada con elementos event-driven puntuales para notificaciones y trazabilidad asíncrona. Todas las decisiones tecnológicas están condicionadas por la restricción de presupuesto cero (RN-ECO-001), priorizando herramientas open source y capas gratuitas.

La documentación describe técnicamente lo siguiente:

- **Despliegue:** Componentes adoptados y desarrollados, así como su ubicación en la infraestructura.
- **Componentes:** Módulos lógicos del Backend y Frontend, y sus funciones.
- **Paquetes:** Organización interna bajo capas y dependencias controladas.
- **Secuencias:** Flujos de interacción de casos de uso típicos (UI ↔ API ↔ servicios).

---

## **1. Diagrama de Despliegue**

**Descripción**
El diagrama de despliegue representa la arquitectura física y lógica de Tree Pruning, mostrando los servicios adoptados y desarrollados así como su interacción dentro del entorno. La solución está diseñada bajo un enfoque **cloud-native**, desplegada en una máquina virtual Azure (Standard_B4ms) con contenedores Docker gestionados por Docker Compose, garantizando **disponibilidad en horario laboral**, **seguridad perimetral** y **costo operativo controlado** alineado con RN-ECO-001.

### **1.1 Componentes del Despliegue**

El diagrama organiza los componentes en cinco capas lógicas:

- **Red perimetral:** WAF (filtrado de tráfico malicioso antes de la nube)
- **Integration Layer:** CDN, CI/CD Pipeline, API Gateway, Reverse Proxy (Traefik)
- **Application Layer:** Frontend, Backend, Georeferencing App, Cache
- **Data Layer:** Database SQL, Blob Storage
- **Management Layer:** Identity Provider, Key Vault, Notification Catalog, Message Catalog, Parameter Catalog, Monitoring Platform, Traceability Platform
- **External Services:** Notification Gateway

---

### **1.2 Componentes Principales**

| Componente | Tipo de Componente | Descripción | Justificación | ¿Es Bloque de Construcción? | Tipo de Bloque |
|---|---|---|---|---|---|
| **WAF** | Componente Adoptado | Filtra y bloquea tráfico malicioso (SQLi, XSS, CSRF, DDoS) antes de que llegue a la infraestructura del sistema. | Primera línea de defensa perimetral que protege los datos personales de ciudadanos y la disponibilidad del sistema. | Sí | Genérico |
| **CDN** | Componente Adoptado | Entrega el contenido estático del Frontend (JS, CSS, assets del mapa) desde el nodo de red más cercano al usuario. | Reduce la latencia de carga inicial del mapa de árboles y el Frontend sin costo de transferencia. | Sí | Genérico |
| **Reverse Proxy** | Componente Adoptado | Enruta el tráfico HTTPS entrante hacia el contenedor correcto según el subdominio solicitado. Gestiona certificados SSL/TLS automáticamente vía Let's Encrypt con Cloudflare DNS. | Permite que todos los servicios compartan la misma IP pública con dominios independientes y HTTPS sin configuración manual de certificados. | Sí | Genérico |
| **API Gateway** | Componente Adoptado | Punto de entrada único al Backend. Centraliza enrutamiento, autenticación OIDC, rate limiting y políticas de acceso por ruta. | Garantiza que ninguna solicitud llegue al Backend sin validación de identidad y rol. | Sí | Genérico |
| **Frontend Tree Pruning** | Desarrollo Propio | Interfaz web SPA mobile-first para los tres actores. Incluye formularios de inventario, mapa de podas y módulo de PQR ciudadana. | Requiere desarrollo propio por contener la lógica de presentación específica del municipio. | No | Core |
| **Backend Tree Pruning** | Desarrollo Propio | Núcleo de lógica de negocio. Expone servicios REST para los módulos de Administración, Podas, PQR y Reportes. | Centraliza todas las reglas de negocio del municipio, inaccesibles en productos del mercado. | No | Core |
| **Georeferencing App** | Componente Adoptado | Módulo de visualización y selección de ubicaciones geográficas en mapa interactivo integrado al Frontend. | Permite el registro de árboles con GPS y la selección de puntos de incidente en PQR ciudadanas. | Sí | Genérico |
| **Cache** | Componente Adoptado | Almacenamiento en memoria de alta velocidad para puntos georreferenciados del inventario consultados frecuentemente. | Reduce la carga sobre PostgreSQL y garantiza tiempos de carga del mapa dentro de ESC-CAL-REN-0003. | Sí | Genérico |
| **Database SQL** | Componente Adoptado | Persistencia de todos los datos estructurados: árboles, podas, PQR, usuarios, roles y trazabilidad. | Motor relacional con transacciones ACID y soporte geoespacial nativo para el inventario arboreo. | Sí | Genérico |
| **Blob Storage** | Componente Adoptado | Almacenamiento de objetos para fotografías de evidencia de podas, firmas digitales y reportes exportados. | Separa archivos binarios de la base de datos relacional, optimizando el rendimiento de consultas. | Sí | Genérico |
| **Identity Provider** | Componente Adoptado | Gestión centralizada de autenticación y autorización con OIDC, OAuth2 y RBAC para los tres roles del sistema. | Implementa el bloqueo por intentos fallidos y el control de acceso por módulo sin lógica propia. | Sí | Genérico |
| **Key Vault** | Componente Adoptado | Almacenamiento seguro de credenciales, claves de API y secretos del sistema en la nube. Inyecta secretos en tiempo de ejecución tanto en el servidor como en el pipeline CI/CD. | Evita exposición de secretos en código fuente, archivos de configuración o repositorio. Reemplaza soluciones auto-hospedadas eliminando su costo operativo. | Sí | Genérico |
| **Notification Catalog** | Componente Adoptado | Repositorio de plantillas de notificaciones push: alertas de vencimiento PQR, bloqueos de cuenta, confirmaciones de poda. | Centraliza plantillas configurables por el Administrador sin redespliegue del Backend. | Sí | Soporte |
| **Message Catalog** | Componente Adoptado | Repositorio de textos del sistema: mensajes de error, confirmaciones, etiquetas de interfaz y textos de validación. | Garantiza consistencia de mensajes entre Backend y Frontend desde una única fuente de verdad. | Sí | Soporte |
| **Parameter Catalog** | Componente Adoptado | Repositorio de valores configurables: plazos legales PQR, tipos de poda, estados de trámite, umbrales de alertas. | Permite ajustar parámetros operativos del municipio sin intervención del equipo de desarrollo. | Sí | Soporte |
| **Monitoring Platform** | Componente Adoptado | Observabilidad del sistema: health checks periódicos, métricas de rendimiento y alertas de degradación en tiempo real. | Soporta el monitoreo de disponibilidad requerido por ESC-CAL-DIS-0001 (99.5% horario laboral). | Sí | Genérico |
| **Traceability Platform** | Componente Adoptado | Registro de auditoría de acciones de usuarios, intentos de acceso fallidos y cambios de estado con timestamp e IP. | Implementa el historial de trazabilidad requerido por ESC-CAL-TRA-0036 y la Ley 1581. | Sí | Genérico |
| **Notification Gateway** | Componente Adoptado | Envío de notificaciones push en tiempo real hacia navegadores y dispositivos de los actores del sistema. | Canal desacoplado del Backend para alertas críticas sin afectar los módulos base del sistema. | Sí | Soporte |
| **CI/CD Pipeline** | Componente Adoptado | Pipeline de integración y despliegue continuo: compilación, pruebas y despliegue automático ante cada commit hacia la VM de Azure. | Garantiza calidad continua del código y despliegues sin downtime alineado con prácticas DevOps. | Sí | Genérico |

---

### **1.3 Bloques de Construcción Adoptados**

| Componente | ¿Es de Pago? | Fabricante | Producto | Versión | Protocolo | Justificación | Tipo de Bloque |
|---|---|---|---|---|---|---|---|
| WAF | No | Cloudflare Inc. | Cloudflare WAF | Latest | HTTPS | Entre el análisis de opciones en el mercado, las características de Cloudflare WAF como protección contra OWASP Top 10 (SQLi, XSS, CSRF, DDoS), reglas administradas actualizadas automáticamente y panel de análisis de tráfico, todo en su capa gratuita sin límite de solicitudes, resaltaron siendo así el único que cumple simultáneamente seguridad de nivel enterprise y costo cero; con respecto a características como pago por solicitud de AWS WAF (incompatible con RN-ECO-001) y el hecho de que ModSecurity requiera servidor propio con mantenimiento activo. | Genérico |
| CDN | No | Cloudflare Inc. | Cloudflare CDN | Latest | HTTPS | Cloudflare dispone de más de 300 puntos de presencia globales, caché automático de assets estáticos, compresión Brotli/Gzip y minificación automática de JS/CSS, sin costo por transferencia de datos, lo cual para un sistema municipal garantiza latencias menores a 20 ms sin ningún costo, mientras que alternativas pagas como Fastly y AWS CloudFront superarían el presupuesto desde el primer mes. | Genérico |
| Reverse Proxy | No | Traefik Labs | Traefik | v2.11 | HTTPS / HTTP | Traefik fue seleccionado por su integración nativa con Docker mediante etiquetas de contenedor, certificados SSL automáticos vía Let's Encrypt con DNS challenge de Cloudflare y enrutamiento dinámico sin reinicio del servicio. Nginx fue descartado por requerir configuración manual de certificados y recarga ante cada cambio de rutas. | Genérico |
| API Gateway | No | Kong Inc. | Kong Gateway | 3.x (OSS) | HTTPS | Kong Gateway es el API Gateway open source adoptado pues se despliega como contenedor Docker sobre la VM de Azure y sus plugins nativos para autenticación OIDC, rate limiting, logging y transformación de solicitudes sin costo de licencia lo hacen ideal frente a características como pago por millón de llamadas de AWS API Gateway y pago por unidad de Azure API Management, que requieren tarjeta de crédito y generan costos desde el primer uso, lo cual viola RN-ECO-001. | Genérico |
| Database SQL | No | PostgreSQL Global Dev. Group | PostgreSQL + PostGIS | 16+ | TCP/IP :5432 | Se evaluaron MySQL 8 (descartado por carecer de soporte geoespacial avanzado nativo sin extensiones de pago), MongoDB (descartado por su naturaleza NoSQL incompatible con transacciones ACID requeridas por ESC-CAL-CON-0003) y PostgreSQL 16+ con PostGIS 3.4, seleccionado por ser el motor relacional open source que soporta transacciones ACID completas con rollback automático, incluye PostGIS nativo para consultas geoespaciales del inventario arboreo, no tiene restricciones de almacenamiento en su edición gratuita y se integra nativamente con Spring Data JPA mediante el dialecto Hibernate Spatial. | Genérico |
| Blob Storage | No | MinIO, Inc. | MinIO | Latest | HTTPS / S3 | MinIO fue seleccionado por ser el almacenamiento de objetos open source más completo: implementa la API S3 estándar al 100% garantizando portabilidad, corre como contenedor Docker sin costo de licencia ni almacenamiento. AWS S3 fue descartado por su modelo de cobro por GB y por solicitud; Cloudflare R2 fue descartado por ofrecer gratuidad con límites y por carecer de SDK Java oficial para integración con Spring Boot. | Genérico |
| Identity Provider | No | Red Hat / Community + Microsoft Corporation | Keycloak + Microsoft Entra ID | Keycloak 24+ / Entra ID (SaaS) | HTTPS / OIDC | Se descartaron Auth0 (límite de 7.500 usuarios activos mensuales gratuitos, insostenible para un sistema municipal) y Okta (completamente de pago). Keycloak 24+ fue seleccionado como IDP principal por soportar nativamente OIDC, OAuth2, RBAC granular, MFA y bloqueo automático por intentos fallidos sin costo ni límite de usuarios. Microsoft Entra ID se integra con Keycloak como proveedor externo mediante federación OIDC. | Genérico |
| Key Vault | No | Infisical Inc. | Infisical | Latest (SaaS) | HTTPS | HashiCorp Vault fue descartado por requerir servidor dedicado y operación de unsealing que genera sobrecarga operativa. AWS Secrets Manager y Azure Key Vault fueron descartados por su modelo de cobro por secreto. Infisical fue seleccionado por ser el gestor de secretos SaaS open-core con capa gratuita permanente: CLI que inyecta secretos directamente en Docker Compose y GitHub Actions, Machine Identities con Universal Auth para autenticación sin credenciales estáticas, y panel web accesible al equipo completo sin gestionar infraestructura adicional. | Genérico |
| Monitoring Platform | No | VMware (Broadcom) + Grafana Labs | Spring Actuator + Grafana | Actuator 3.x / Grafana 11+ | HTTP | Datadog fue descartado por su modelo de cobro por host; New Relic fue descartado por su cobro por GB de datos ingeridos, ambos incompatibles con RN-ECO-001. Spring Actuator está embebido nativamente en Spring Boot sin costo ni dependencia adicional, expone métricas de salud, tiempos de respuesta y estado de conexión en formato Prometheus. Grafana consume esas métricas y construye dashboards de disponibilidad en tiempo real configurables sin código. | Genérico |
| Traceability Platform | No | VMware (Broadcom) | Spring Events + Logs | Spring 6.x | HTTP | Jaeger fue descartado por requerir infraestructura adicional de Kafka generando complejidad y costos desproporcionados; Zipkin fue descartado por el exceso de recursos operativos. Spring Events opera dentro del mismo proceso del Backend sin latencia de red, registra cada evento de auditoría de forma atómica con la operación que lo genera y garantiza que si la operación se revierte por fallo (ESC-CAL-CON-0003), el registro de trazabilidad también se revierte. | Genérico |
| Notification Catalog | No | Strapi Inc. | Strapi | 5.x (LTS) | HTTPS / REST | Se evaluaron Contentful (SaaS de pago por usuarios del equipo de contenido), Sanity (pago por proyectos activos) y Strapi. Strapi 5.x fue seleccionado por ser el CMS headless open source de referencia en la industria: se despliega como contenedor Docker sin costo, expone una API REST que el Backend consume para obtener las plantillas de notificaciones push, y su panel de administración permite al Administrador del sistema modificar el contenido de las plantillas sin conocimientos técnicos ni redespliegue del Backend. | Soporte |
| Message Catalog | No | Strapi Inc. | Strapi | 5.x (LTS) | HTTPS / REST | La misma instancia de Strapi utilizada para el Notification Catalog gestiona el Message Catalog mediante un Content Type independiente. Esto elimina la necesidad de desplegar y mantener un servicio adicional, optimizando los recursos de infraestructura disponibles. El Message Catalog centraliza todos los textos del sistema que tanto el Backend como el Frontend consumen vía API REST. | Soporte |
| Parameter Catalog | No | VMware (Broadcom) | Spring Cloud Config | 4.x | HTTPS / HTTP | Se evaluaron Consul (requiere agente en cada nodo cliente), etcd (orientado a orquestación de contenedores, sobrecarga operativa) y Spring Cloud Config. Spring Cloud Config fue seleccionado por integrarse nativamente con Spring Boot sin dependencias adicionales, actuar como servidor de configuración centralizado y permitir actualización de parámetros en caliente mediante el endpoint /actuator/refresh sin reinicio del servicio. | Soporte |
| Notification Gateway | No | Google LLC | Firebase Cloud Messaging (FCM) | Latest (API v1) | HTTPS / Web Push | Se descartó OneSignal por limitar su plan gratuito a 10.000 suscriptores y Pusher Beams por limitar su capa gratuita a 500 dispositivos simultáneos. Se evaluó Twilio como alternativa para notificaciones SMS, pero fue descartado por generar costos por mensaje enviado incompatibles con RN-ECO-001 y porque el alcance de Tree Pruning se limita a notificaciones push en navegador. FCM fue seleccionado por operar sin límite de mensajes en su capa gratuita y proveer SDK Java oficial para integración directa con Spring Boot. | Soporte |
| Georeferencing App | Sí (crédito gratuito) | Google LLC + PostgreSQL Global Dev. Group | Google Maps Platform + PostGIS | Latest / PostGIS 3.4 | HTTPS / JDBC | Se descartó OpenStreetMap + Leaflet por carecer de soporte nativo de Street View y Places API y ofrecer cobertura menos actualizada para Rionegro; Mapbox fue descartado por su modelo de cobro tras 50.000 cargas de mapa mensuales. Google Maps Platform fue seleccionado para la capa de visualización por su cobertura cartográfica completa con capas satelitales de alta resolución sobre Rionegro. PostGIS 3.4 gestiona el almacenamiento y exportación de datos geoespaciales del inventario en GeoJSON. | Genérico |
| Cache | No | Redis Ltd. | Redis | 7.x | RESP / TCP | Memcached fue descartado por soportar únicamente estructuras de tipo clave-valor, insuficiente para consultas geoespaciales del inventario; Hazelcast fue descartado por requerir licencia enterprise para clustering en producción, incompatible con RN-ECO-001. Redis 7.x fue seleccionado por ser el estándar de la industria para caché en memoria y el único que soporta estructuras GeoSet nativas para almacenar y consultar coordenadas de árboles por proximidad geográfica. Se comunica mediante el protocolo RESP garantizando latencias de caché por debajo de 1 ms. | Genérico |
| CI/CD Pipeline | No | GitHub (Microsoft) | GitHub Actions | Latest | HTTPS | GitLab CI/CD fue descartado por requerir instancia self-hosted para uso intensivo; Jenkins fue descartado por requerir servidor dedicado con mantenimiento continuo de plugins. GitHub Actions se integra nativamente con el repositorio sin configuración de infraestructura adicional, ejecuta automáticamente pipelines de compilación, pruebas unitarias, construcción de imagen Docker y despliegue en la VM de Azure ante cada commit, e integra Infisical para inyección segura de secretos en el pipeline. | Genérico |

---

### **1.4 Bloques de Construcción Desarrollados**

| Componente | ¿Pago? | Tipo | Fabricante | Producto | Versión | Descripción | Justificación |
|---|---|---|---|---|---|---|---|
| **Frontend Tree Pruning** | No | Framework UI | Evan You / Community | Vue.js | 3.4+ | Framework reactivo progresivo para SPA. Composition API encapsula la lógica de cada módulo (inventario, podas, PQR, reportes) en composables reutilizables con bajo acoplamiento. Incluye Vue Router para navegación por rol y Pinia para gestión de estado de sesión. | Vue.js fue seleccionado sobre React y Angular por su menor curva de aprendizaje para un equipo de tamaño reducido y su integración nativa con Bootstrap para implementar el sistema de diseño requerido por ESC-CAL-USA-0003. |
| **Frontend Tree Pruning** | No | Framework CSS | The Bootstrap Team | Bootstrap | 5.3+ | Framework CSS con sistema de grillas responsive, componentes accesibles por defecto y utilidades de espaciado y tipografía. Permite construir interfaces mobile-first sin configuración adicional de estilos por formulario. | Implementación directa de ESC-CAL-USA-0003: todos los formularios heredan automáticamente los estilos del sistema de diseño garantizando consistencia visual entre todos los módulos. |
| **Frontend Tree Pruning** | No | Cliente HTTP | Matt Zabriskie / Community | Axios | 1.7+ | Cliente HTTP con interceptores de solicitud y respuesta. El interceptor de solicitud agrega automáticamente el token JWT en el header Authorization; el interceptor de respuesta gestiona centralizadamente los errores 401 (token expirado) y 403 (sin permiso). | Centralizar el manejo de autenticación en un único interceptor garantiza que ningún módulo pueda realizar llamadas sin token válido, implementando el principio DRY y soportando ESC-CAL-SEG-0005 desde la capa de presentación. |
| **Frontend Tree Pruning** | No | IDE de desarrollo | Microsoft Corp. | Visual Studio Code | Latest | Editor extensible con soporte nativo de Vue.js (extensión Volar), ESLint para análisis estático, Prettier para formateo automático y depurador integrado para aplicaciones Vue en el navegador. | VS Code con Volar ofrece autocompletado de componentes Vue, detección de errores en plantillas en tiempo real y formateo consistente, alineado con la restricción técnica de Clean Code del proyecto. |
| **Backend Tree Pruning** | No | Lenguaje | OpenJDK (Eclipse Foundation) | Java | 26 | Lenguaje base del Backend. Versión seleccionada por requerimiento del proyecto, con rendimiento mejorado y nuevas características del lenguaje sobre versiones anteriores. Open source bajo OpenJDK, sin costo de licencia. | Java 26 cumple el requerimiento técnico establecido para el proyecto y es compatible con Spring Boot 3.3.x y el ecosistema de dependencias del sistema. |
| **Backend Tree Pruning** | No | Framework principal | VMware (Broadcom) | Spring Boot | 3.3+ | Framework que provee autoconfiguración y módulos integrados para el Backend: Spring Security (autenticación), Spring Data JPA (persistencia), Spring Events (trazabilidad asíncrona), Spring Actuator (monitoreo) y Spring Web (APIs REST). Reduce el código de infraestructura permitiendo que el equipo se concentre en la lógica de negocio específica del municipio. | Spring Boot 3.x con Jakarta EE 10 es el stack más maduro y documentado para sistemas empresariales Java. La integración nativa con Keycloak vía Spring Security OAuth2 Resource Server implementa el RBAC de tres roles requerido por ESC-CAL-SEG-0005 sin código adicional de autenticación. |
| **Backend Tree Pruning** | No | Framework de seguridad | VMware (Broadcom) | Spring Security + OAuth2 | 6.3+ | Gestiona la autenticación y autorización integrada con Keycloak. Valida tokens JWT en cada solicitud HTTP mediante el filtro de seguridad, aplica las restricciones de acceso por módulo y rol antes de que la solicitud llegue al controlador, y delega el bloqueo por intentos fallidos al Identity Provider. | Externalizar la seguridad al filtro de Spring Security garantiza que ninguna solicitud no autenticada llegue a la lógica de negocio, implementando defensa en profundidad y soportando directamente ESC-CAL-SEG-0002 (bloqueo 3 intentos fallidos) y ESC-CAL-SEG-0005 (módulos según rol). |
| **Backend Tree Pruning** | No | Persistencia | VMware (Broadcom) / PostgreSQL Dev. | Spring Data JPA + PostGIS | JPA 3.1 / PostGIS 3.4 | Gestiona el acceso a PostgreSQL mediante repositorios JPA con soporte geoespacial de PostGIS. Permite consultas espaciales como "árboles en un radio de X metros" o "podas programadas en un sector" directamente en JPQL sin transformaciones manuales de coordenadas, y garantiza atomicidad transaccional en operaciones de creación masiva de podas. | El inventario de árboles georreferenciados es el núcleo del sistema. PostGIS sobre JPA permite que las consultas del mapa sean eficientes (ESC-CAL-REN-0003) y que las transacciones de creación masiva de podas sean atómicas y reversibles ante fallos de conexión (ESC-CAL-CON-0003). |
| **Backend Tree Pruning** | No | IDE de desarrollo | Eclipse Foundation | Eclipse IDE | 2024-12 (4.34) | Entorno de desarrollo con soporte nativo de Spring Boot mediante Spring Tools 4 (STS4), integración con Maven, depurador de aplicaciones Java y análisis estático con SonarLint integrado. Completamente gratuito bajo licencia EPL-2.0. | Eclipse IDE con Spring Tools 4 provee el mismo nivel de soporte para Spring Boot sin restricciones de características. Su integración con SonarLint permite detectar code smells en tiempo real dentro del entorno de desarrollo, reforzando la restricción técnica de Clean Code. |
| **Backend Tree Pruning** | No | Calidad de código | SonarSource SA | SonarQube | Community 10.x | Plataforma de inspección continua de calidad y seguridad del código. Detecta code smells, duplicación de código, vulnerabilidades OWASP y cobertura de pruebas en cada ejecución del pipeline de CI/CD integrado con GitHub Actions. | La restricción técnica del proyecto exige Clean Code y prácticas de desarrollo seguro. SonarQube integrado en GitHub Actions garantiza que ningún commit con vulnerabilidades críticas llegue al repositorio principal, protegiendo la integridad del sistema municipal a largo plazo. |

---

### **1.5 El diagrama de despliegue de Tree Pruning es el siguiente:**

![Diagrama de despliegue Tree Pruning](DiagramaDespliegueTreePruning.png)

---

## **2. Diagrama de Componentes**

**Descripción**
El diagrama de componentes representa la estructura interna de Tree Pruning, identificando los módulos que componen la solución en el **Backend** y **Frontend**, así como sus dependencias. Cada componente encapsula una responsabilidad específica siguiendo el principio de responsabilidad única (SOLID), facilitando la mantenibilidad, el testing independiente y la escalabilidad por módulo.

---

### **2.1 Componentes del Backend**

| Componente | Descripción | Motivación / Justificación | Depende / Usa | Tipo de Componente |
|---|---|---|---|---|
| **Backend Tree Pruning** | Núcleo que expone servicios REST para los cuatro módulos del sistema: Administración, Podas, PQR y Reportes. | Centraliza la lógica del dominio municipal y permite la comunicación controlada con todos los demás servicios del sistema. | Spring Boot 3.3+, Java 26, PostgreSQL, Infisical, API Gateway | **Componente a Desarrollar (Core)** |
| **Spring Boot 3.3+** | Framework de desarrollo del Backend con autoconfiguración y módulos integrados. | Reduce el código de infraestructura y permite al equipo concentrarse en la lógica de negocio del municipio. | Java 26 | Framework / Acelerador |
| **Java 26** | Lenguaje y plataforma de ejecución del Backend. | Requerimiento técnico del proyecto con soporte completo en el ecosistema Spring Boot 3.3.x. | OpenJDK | Plataforma Base |
| **Spring Data JPA + PostGIS** | Manejo de persistencia mediante repositorios JPA con soporte geoespacial nativo. | Reduce la complejidad de acceso a datos y garantiza consultas geoespaciales eficientes del inventario. | PostgreSQL + PostGIS | Librería / Conector |
| **Spring Security + OAuth2** | Validación de autenticación y autorización mediante tokens JWT emitidos por Keycloak. | Garantiza que ninguna solicitud no autenticada llegue a la lógica de negocio del sistema. | Keycloak (Identity Provider) | Framework / Acelerador |
| **Spring Web** | Exposición de APIs REST para los cuatro módulos del sistema. | Provee el mecanismo de comunicación HTTP entre Frontend y Backend. | Spring Boot | Framework / Acelerador |
| **Spring Events** | Mecanismo de comunicación asíncrona interna para registro de auditoría y disparo de notificaciones push. | Opera dentro del mismo proceso sin latencia de red, garantizando atomicidad entre operaciones y sus registros de auditoría. | Spring Boot | Framework / Acelerador |
| **Spring Actuator** | Exposición de endpoints de monitoreo: salud del sistema, tiempos de respuesta y estado de conexiones. | Alimenta el Monitoring Platform (Grafana) con métricas en formato Prometheus sin configuración adicional. | Spring Boot | Framework / Acelerador |
| **Infisical SDK / CLI** | Obtención segura de credenciales y secretos del sistema desde el Key Vault en la nube. | Evita la exposición de claves en código fuente o variables de entorno en texto plano. Funciona tanto en el servidor como en el pipeline de CI/CD. | Infisical (SaaS) | Integración / Servicio Externo |
| **FCM SDK (Spring)** | Envío de notificaciones push a navegadores y dispositivos mediante Firebase Cloud Messaging. | Desacopla el envío de notificaciones del flujo principal de negocio para que su indisponibilidad no afecte los módulos base. | Firebase Cloud Messaging | Integración / Servicio Externo |
| **Spring Cloud Config Client** | Consulta de parámetros operativos del municipio desde el Parameter Catalog al iniciar el sistema. | Permite actualizar plazos legales de PQR y parámetros operativos sin reiniciar el Backend. | Spring Cloud Config (Parameter Catalog) | Framework / Acelerador |
| **CrossCutting** | Funciones reutilizables entre módulos: manejo de excepciones, validadores comunes, utilidades de fecha/hora. | Implementa el principio DRY evitando duplicación de lógica transversal entre los cuatro módulos del sistema. | Java 26 | Acelerador Interno |

---

### **2.2 Componentes del Frontend**

| Componente | Descripción | Motivación / Justificación | Depende / Usa | Tipo de Componente |
|---|---|---|---|---|
| **Frontend Tree Pruning** | Núcleo de la SPA. Gestiona el ensamblaje de módulos, la navegación por rol y el estado global de la sesión del usuario. | Contiene la lógica de presentación específica del municipio que ningún producto del mercado puede proveer. | Vue.js 3.4+, Bootstrap 5.3+, Axios, Vue Router, Pinia | **Componente a Desarrollar (Core)** |
| **Vue.js 3.4+** | Framework reactivo base de la SPA con Composition API para composables por módulo. | Menor curva de aprendizaje que Angular y mejor ecosistema para el equipo del proyecto. | — | Framework UI |
| **Bootstrap 5.3+** | Framework CSS con sistema de grillas responsive y componentes accesibles. | Implementación directa de ESC-CAL-USA-0003 sin configuración adicional de estilos por formulario. | Vue.js | Librería Externa |
| **Vue Router** | Gestión de rutas de la SPA con guards de navegación por rol. | Garantiza que rutas no autorizadas nunca se rendericen en el navegador del usuario. | Vue.js, Pinia | Librería Externa |
| **Pinia** | Gestión del estado global de la sesión: token JWT, rol del usuario y módulos habilitados. | Centraliza el estado de autenticación para que todos los componentes accedan al rol activo sin prop drilling. | Vue.js | Librería Externa |
| **Axios** | Cliente HTTP con interceptores para manejo centralizado de JWT y errores de autorización. | Implementa el principio DRY para autenticación HTTP y soporta ESC-CAL-SEG-0005 desde la capa de presentación. | API Gateway | Librería Externa |
| **Google Maps SDK (JS)** | Renderización del mapa interactivo y selección de puntos geográficos en formularios de inventario y PQR. | Provee la capa cartográfica de alta resolución de Rionegro con familiaridad para los Encargados de Cuadrilla. | Google Maps Platform | Librería Externa |

---

## **3. Diagrama de Paquetes**

**Descripción**
El diagrama de paquetes describe cómo se divide y estructura el código fuente de Tree Pruning tanto en el Backend como en el Frontend, siguiendo los principios de **Clean Architecture**. Las dependencias fluyen desde capas externas hacia capas internas, protegiendo el dominio del negocio contra detalles tecnológicos y garantizando que cada capa pueda evolucionar independientemente.

---

### **3.1 Paquetes — Backend**

| Paquete | Paquete Padre | Descripción | Usa / Importa |
|---|---|---|---|
| **co** | — | Paquete raíz de la aplicación. | — |
| **treepruning** | co | Representa el Backend de Tree Pruning y contiene su estructura interna. | — |
| **application** | treepruning | Gestiona los casos de uso del sistema y la lógica de negocio. | crosscutting |
| **config** | application | Configuraciones e inicialización de la aplicación (Spring Cloud Config, seguridad). | — |
| **interactor** | application | Gestión y orquestación de los flujos transaccionales entre capas. | — |
| **usecase** | interactor | Contratos de los casos de uso que expone cada módulo. | — |
| **domain** | treepruning | Modelo de dominio con entidades de negocio y objetos de valor del municipio. | — |
| **infrastructure** | treepruning | Implementación técnica: controladores, persistencia e integraciones externas. | application, domain |
| **primary** | infrastructure | Adaptadores de entrada para los módulos del sistema. | — |
| **controller** | primary | Controladores REST expuestos por los cuatro módulos (Administración, Podas, PQR, Reportes). | application.interactor.dto, application.interactor |
| **exception** | primary | Manejo centralizado de excepciones para los controladores. | crosscutting |
| **security** | infrastructure | Componentes de autenticación JWT y autorización RBAC mediante Spring Security. | application, crosscutting |
| **secondary** | infrastructure | Adaptadores de salida hacia servicios externos. | — |
| **adapters** | secondary | Implementaciones para integraciones externas (FCM, Infisical, Strapi, Spring Cloud Config). | secondary.ports |
| **notifications** | adapters | Adaptador de envío de notificaciones push vía Firebase Cloud Messaging. | ports.repository.notifications |
| **catalog** | adapters | Adaptador de consulta de plantillas y mensajes del sistema vía API REST de Strapi. | ports.repository.catalog |
| **parameters** | adapters | Adaptador de consulta de parámetros operativos vía Spring Cloud Config. | ports.repository.parameters |
| **repository** | adapters | Implementación de persistencia de información en PostgreSQL. | ports.repository |
| **entity** | repository | Entidades de persistencia JPA con tipos geoespaciales de PostGIS. | domain |
| **ports** | secondary | Contratos de los adaptadores de salida. | — |
| **crosscutting** | treepruning | Recursos reutilizables entre todos los módulos. | — |
| **exception** | crosscutting | Excepciones compartidas y validadas entre capas. | — |
| **helpers** | crosscutting | Utilidades genéricas: formateo de fechas, cálculo de plazos legales, conversión de coordenadas. | — |

---

### **3.2 Paquetes — Frontend**

| Paquete | Paquete Padre | Descripción | Usa / Importa |
|---|---|---|---|
| **src** | — | Raíz del proyecto Frontend con toda la estructura de la SPA. | — |
| **assets** | src | Recursos estáticos del proyecto: imágenes, íconos, fuentes y estilos globales. | — |
| **utils** | src | Funciones puras reutilizables: formateo de fechas, cálculo de plazos PQR, conversión de coordenadas GPS. | — |
| **pages** | src | Pantallas principales de la aplicación por módulo: Inventario, Podas, PQR, Reportes, Administración. | components, composables, services, utils, assets |
| **components** | src | Componentes reutilizables de UI: formularios, tablas de datos, mapa interactivo, modales de confirmación. | composables, utils, assets |
| **router** | src | Definición de rutas de navegación con guards que verifican el rol activo antes de renderizar cada página. | pages, store |
| **store** | src | Estado global de la sesión mediante Pinia: token JWT, rol del usuario, módulos habilitados y estado del mapa. | services, utils |
| **services** | src | Lógica de comunicación HTTPS con el API Gateway mediante Axios con interceptores de JWT. | utils |
| **composables** | src | Lógica reactiva reutilizable por módulo: validación de formularios, manejo del mapa (Google Maps SDK). | services, utils |

---

## **4. Diagrama de Secuencia**

**Descripción**
Los diagramas de secuencia muestran el flujo de interacción entre los elementos del sistema durante la ejecución de un caso de uso, siguiendo los principios de Clean Architecture. El **diagrama Backend** representa la ejecución transaccional completa desde la petición hasta la persistencia. El **diagrama Frontend** refleja el flujo desde la UI hasta el Backend, incluyendo autenticación, validación y manejo de respuestas.

---

### **4.1 Diagrama de Secuencia — Backend (Transacción general)**

| Participante | Descripción |
|---|---|
| **Frontend** | Cliente que envía la petición HTTP al API Gateway. |
| **Controller** | Adaptador primario REST que recibe la petición validada por Spring Security y gestiona el flujo inicial. |
| **DTO** | Objeto de transferencia de datos para entrada y salida del API. |
| **Interactor** | Orquesta el flujo hacia el caso de uso y valida el mapeo entre DTO y dominio. |
| **Domain** | Modelo de dominio con las entidades y reglas de negocio del municipio. |
| **Use Case** | Gestiona la lógica transaccional específica de cada módulo. |
| **Validator** | Aplica las reglas de negocio antes de persistir. |
| **Entity** | Representación de persistencia JPA con tipos PostGIS para datos geoespaciales. |
| **Repository** | Puerto de acceso a la base de datos PostgreSQL con Spring Data JPA. |

| Acción | Origen | Destino | Descripción |
|---|---|---|---|
| InteraccionUsuario | Frontend | Controller | El cliente envía la solicitud HTTP con token JWT. Spring Security valida el token antes de que llegue al controlador. |
| mapeoDTO | Controller | DTO | Se valida y transforma la entrada a un DTO estándar con las reglas de validación de Spring Validation. |
| DTOdeRetorno | DTO | Controller | Se retorna el DTO validado para continuar el flujo. |
| ejecutarDTO | Controller | Interactor | Se invoca el interactor con el DTO validado. |
| mapeoDomain | Interactor | Domain | Se convierte el DTO a un objeto de dominio aplicando las reglas de negocio municipales. |
| DomaindeRetorno | Domain | Interactor | Se retorna el objeto de dominio preparado para el caso de uso. |
| ejecutarDomain | Interactor | Use Case | Se invoca el caso de uso transaccional con el objeto de dominio. |
| ValidarDatos | Use Case | Validator | Se validan las reglas de negocio específicas del módulo (plazos, estados, permisos por rol). |
| confirmacion/denegado | Validator | Use Case | Confirmación de validación o lanzamiento de excepción si no cumple las reglas de negocio. |
| mapeoEntity | Use Case | Entity | Se convierte el dominio en una entidad JPA persistente con tipos geoespaciales PostGIS. |
| EntitydeRetorno | Entity | Use Case | Se retorna la entidad validada y lista para su persistencia. |
| ejecutarCRUD | Use Case | Repository | Se ejecuta la operación de acceso a datos dentro de la transacción activa de Spring. |
| eventoAuditoria | Use Case | Spring Events | Se publica un evento de auditoría de forma asíncrona para registro en la Traceability Platform. |
| ResultadoTransaccion | Repository | Use Case | Se recibe el resultado validado de la operación CRUD. |
| RespuestaDTO | Use Case | Controller | Se mapea el resultado al DTO de respuesta y se retorna al controlador. |
| RespuestaHTTP | Controller | Frontend | Se retorna la respuesta HTTP con el resultado de la operación. |

---

### **4.2 Diagrama de Secuencia — Frontend (Transacción general)**

| Participante | Descripción |
|---|---|
| **Usuario (UI)** | Actor del sistema que interactúa con la interfaz. |
| **Router** | Gestiona la navegación y verifica el rol del usuario antes de renderizar cada página. |
| **Pages** | Pantallas principales que combinan componentes, composables y llamadas a servicios. |
| **Components** | Componentes reutilizables de UI (formularios, tablas, mapa interactivo). |
| **Composables** | Lógica reactiva reutilizable: validación y manejo del mapa. |
| **Store (Pinia)** | Estado global de la sesión: token JWT, rol activo y módulos habilitados. |
| **Services (Axios)** | Comunicación HTTPS con el API Gateway con interceptores JWT. |
| **API Gateway** | Punto de entrada del Backend que valida el token y enruta la solicitud. |

| Acción | Origen | Destino | Descripción |
|---|---|---|---|
| navegarRuta | Usuario (UI) | Router | El usuario navega a una ruta del sistema. El Router verifica el rol activo en el Store antes de renderizar. |
| renderizarPagina | Router | Pages | El Router autoriza la navegación y renderiza la página correspondiente al módulo. |
| renderizarComponentes | Pages | Components | La página ensambla los componentes del formulario o tabla del módulo. |
| inicializarComposables | Pages | Composables | La página inicializa la lógica de validación y los handlers del formulario mediante composables. |
| ingresoDatos | Usuario (UI) | Components | El usuario interactúa con el formulario ingresando datos en los campos. |
| validarCampo | Components | Composables | Cada cambio de campo activa la validación reactiva con mensajes de error inline. |
| prepararEnvio | Composables | Services | Al enviar el formulario, el composable invoca el servicio Axios con los datos validados. |
| agregarJWT | Services | Store | El interceptor de Axios obtiene el token JWT del Store y lo agrega al header Authorization. |
| llamadaHTTP | Services | API Gateway | Axios envía la solicitud HTTPS al API Gateway con el token JWT en el header. |
| respuestaAPI | API Gateway | Services | El API Gateway retorna la respuesta del Backend (éxito, error de validación o error de autorización). |
| procesarRespuesta | Services | Composables | El composable recibe el resultado y actualiza el estado reactivo del formulario. |
| mostrarResultado | Composables | Components | Se muestra notificación con el resultado de la operación al usuario. |
| actualizarVista | Components | Pages | Los componentes informan a la página para actualizar la lista o tabla del módulo con los datos más recientes. |
