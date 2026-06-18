# IGV Perú

<p align="center">
  <img src="img/icon_app_img.png" alt="IGV Perú" width="300"/>
</p>

**IGV Perú** es una aplicación Android diseñada para calcular de forma rápida, sencilla y precisa el
Impuesto General a las Ventas (IGV) en Perú.

La app permite obtener el **monto sin IGV**, el **valor del IGV**, el **total con IGV** y el *
*importe en letras**, facilitando cálculos cotidianos relacionados con compras, ventas,
cotizaciones, boletas, facturas y operaciones comerciales.

---

## Descripción del proyecto

IGV Perú es una calculadora móvil enfocada en brindar una experiencia clara, moderna y práctica para
usuarios que necesitan realizar cálculos de IGV de manera inmediata.

El proyecto incorpora una interfaz basada en **Material 3**, con un sistema visual financiero
moderno, soporte para **tema claro y oscuro**, componentes reutilizables y una navegación simple
mediante cuatro secciones principales:

- Calculadora
- Historial
- Cronograma SUNAT
- Ajustes

La aplicación no requiere cuenta de usuario, login, perfil ni datos personales, manteniendo una
experiencia directa y local.

---

## Funcionalidades principales

### Calculadora de IGV

La pantalla principal permite calcular automáticamente:

- Monto sin IGV
- IGV
- Total con IGV
- Importe en letras

El usuario puede ingresar cualquiera de los tres valores principales y la app calcula los demás
automáticamente.

También incluye:

- Tabs para cálculo con IGV y sin IGV
- Chip dinámico con la tasa de IGV configurada
- Validación de montos
- Formato monetario en soles
- Botones para guardar, compartir y limpiar
- Snackbar de confirmación al guardar

---

### Historial

La sección Historial permite visualizar los cálculos guardados desde la Calculadora.

Cada registro incluye:

- Monto sin IGV
- IGV
- Total con IGV
- Fecha de guardado
- Importe en letras

También permite eliminar cálculos mediante confirmación previa.

---

### Cronograma SUNAT

La pantalla Cronograma SUNAT permite consultar vencimientos de obligaciones mensuales según:

- Período tributario
- Último dígito del RUC
- Buenos Contribuyentes y UESP

El diseño está adaptado a móvil mediante cards por período tributario, evitando tablas horizontales
difíciles de leer.

Fuente oficial:

```text
SUNAT
https://ww3.sunat.gob.pe/cl-ti-itcronobligme/fvS01Alias