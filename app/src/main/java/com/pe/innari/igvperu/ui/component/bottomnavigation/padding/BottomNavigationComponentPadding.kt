package com.pe.innari.igvperu.ui.component.bottomnavigation.padding

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.pe.innari.igvperu.ui.theme.Dimen0
import com.pe.innari.igvperu.ui.theme.Dimen16
import com.pe.innari.igvperu.ui.theme.Dimen24

/**
 * Utilidad para calcular paddings específicos del componente de navegación adaptable.
 * Asegura que los componentes se visualicen correctamente en diferentes dispositivos y orientaciones.
 */
class BottomNavigationComponentPadding {

    /**
     * Proporciona funciones de utilidad para determinar los paddings adecuados según el tipo de dispositivo
     * y las áreas seguras de la pantalla.
     */
    companion object {
        /**
         * Calcula el padding inicial para el Navigation Rail considerando zonas seguras y tipo de dispositivo.
         *
         * @param startSafePadding Padding de zona segura al inicio.
         * @param endSafePadding Padding de zona segura al final.
         * @param isPhoneOrTablet Indica si el dispositivo es un teléfono o tablet para aplicar paddings base.
         * @return El valor máximo entre los insets del sistema y el padding base del dispositivo.
         */
        @Composable
        fun calculateNavigationRailStartPadding(
            startSafePadding: Dp, endSafePadding: Dp, isPhoneOrTablet: Boolean
        ) = maxOf(
            maxHorizontalSafePadding(startSafePadding, endSafePadding),
            deviceBaseStartPadding(isPhoneOrTablet = isPhoneOrTablet)
        )

        /**
         * Retorna el padding superior para el Navigation Rail.
         *
         * @param isPhoneOrTablet Indica si el dispositivo es teléfono/tablet.
         * @return Padding de 0dp para móviles o 16dp para otros dispositivos.
         */
        @Composable
        fun getNavigationRailTopPadding(isPhoneOrTablet: Boolean) = if (isPhoneOrTablet) {
            Dimen0
        } else {
            Dimen16
        }

        /**
         * Retorna el padding inferior para el Navigation Rail.
         *
         * @param isPhoneOrTablet Indica si el dispositivo es teléfono/tablet.
         * @return Padding de 0dp para móviles o 16dp para otros dispositivos.
         */
        @Composable
        fun getNavigationRailBottomPadding(isPhoneOrTablet: Boolean) = if (isPhoneOrTablet) {
            Dimen0
        } else {
            Dimen16
        }

        @Composable
        private fun maxHorizontalSafePadding(
            startPadding: Dp, endPadding: Dp
        ) = maxOf(startPadding, endPadding)

        @Composable
        private fun deviceBaseStartPadding(isPhoneOrTablet: Boolean) = if (isPhoneOrTablet) {
            Dimen0
        } else {
            Dimen24
        }
    }
}
