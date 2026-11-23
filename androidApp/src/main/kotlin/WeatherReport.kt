import java.util.Locale

enum class TemperatureUnit { CELSIUS, FAHRENHEIT }

open class WeatherReport(
    val city: String,
    val temperatureCelsius: Double,
    val condition: String,      // e.g., "Sunny", "Rainy"
    val updatedAt: String       // e.g., "3:45 PM"
) {
    companion object {
        fun celsiusToFahrenheit(celsius: Double): Double =
            celsius * 9 / 5 + 32
        fun fahrenheitToCelsius(fahrenheit: Double): Double =
            (fahrenheit - 32) * 5 / 9
    }

    open fun formatTemperature(unit: TemperatureUnit): String = when (unit) {
        TemperatureUnit.CELSIUS ->
            String.format(Locale.US, "%.1f°C", temperatureCelsius)
        TemperatureUnit.FAHRENHEIT ->
            String.format(
                Locale.US, "%.1f°F", celsiusToFahrenheit(temperatureCelsius)
            )
    }

    fun getSummary(unit: TemperatureUnit): String =
        "$city: ${formatTemperature(unit)}, $condition (updated $updatedAt)"
}

class HourlyWeatherReport(
    city: String,
    temperatureCelsius: Double,
    condition: String,
    updatedAt: String,
    val forecastHour: String    // e.g., "5 PM"
) : WeatherReport(city, temperatureCelsius, condition, updatedAt) {

    override fun formatTemperature(unit: TemperatureUnit): String =
        "$forecastHour: ${super.formatTemperature(unit)}"
}