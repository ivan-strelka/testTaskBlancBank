package api.utils

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.internal.platform.Platform
import okhttp3.internal.platform.Platform.Companion.INFO
import okhttp3.internal.platform.Platform.Companion.WARN

import okhttp3.logging.HttpLoggingInterceptor

class PrettyLogger : HttpLoggingInterceptor.Logger {
    override fun log(s: String) {
        val message = s.trim { it <= ' ' }
        val mapper = ObjectMapper()
        if (message.startsWith("{") && message.endsWith("}") || message.startsWith("[") && message.endsWith("]")) {
            try {
                val value = mapper.readValue(message, Any::class.java)
                val prettyView = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value)
                Platform.get().log(prettyView, INFO, null)
            } catch (e: JsonProcessingException) {
                Platform.get().log(message, WARN, e)
            }
        } else {
            Platform.get().log(message, INFO, null)
        }
    }
}