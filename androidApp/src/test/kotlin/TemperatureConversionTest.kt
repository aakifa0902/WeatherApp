import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TemperatureConversionTest {

    private val delta = 0.01

    @Test
    fun celsiusToFahrenheit_freezingPoint() {
        assertEquals(32.0, WeatherReport.celsiusToFahrenheit(0.0), delta)
    }

    @Test
    fun celsiusToFahrenheit_boilingPoint() {
        assertEquals(212.0, WeatherReport.celsiusToFahrenheit(100.0), delta)
    }

    @Test
    fun celsiusToFahrenheit_negativeValue() {
        assertEquals(-40.0, WeatherReport.celsiusToFahrenheit(-40.0), delta)
    }

    @Test
    fun fahrenheitToCelsius_freezingPoint() {
        assertEquals(0.0, WeatherReport.fahrenheitToCelsius(32.0), delta)
    }

    @Test
    fun fahrenheitToCelsius_bodyTemperature() {
        assertEquals(37.0, WeatherReport.fahrenheitToCelsius(98.6), delta)
    }

    @Test
    fun roundTrip_returnsOriginalValue() {
        val original = 25.0
        val converted = WeatherReport.fahrenheitToCelsius(
            WeatherReport.celsiusToFahrenheit(original)
        )
        assertEquals(original, converted, delta)
    }
}