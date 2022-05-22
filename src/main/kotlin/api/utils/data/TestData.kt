package api.utils.data

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class TestData : ArgumentsProvider {
    @Throws(Exception::class)
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments?>? {
        return Stream.of(
            Arguments.of("123456789"),
            Arguments.of("12345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678"),
            Arguments.of("+791102"),
            Arguments.of("              123   "),
            Arguments.of("0"),
            Arguments.of("-5"),
            Arguments.of("0x0F"),
            Arguments.of("!@#$%^&*&^%$#@!@#$%^&^%$#@!@#$%^&&^%$#\""),
            Arguments.of("!@#$%^&*("),
            Arguments.of("ываывdfs№;%:?987654"),
            Arguments.of("миру мир"),
            Arguments.of("    1    "),
            Arguments.of("SDLFHB"),
            Arguments.of("1"),
            Arguments.of("äöüÄÖÜß"),
            Arguments.of("àâçéèêëîïôûùüÿ"),
            Arguments.of("NÑO"),
            Arguments.of("éàòùÀàÁáÈèÉéÌìÍíÒòÓóÙùÚú"),
            Arguments.of("中国的"),
            Arguments.of("ظواهر الملحوظة"),
            Arguments.of("ทดสอบนะจ๊"),
            Arguments.of("क जल्दी भूरी लोमड़ी आलसी कुत्ते पर\""),
            Arguments.of("Iñtërnâtiônàlizætiøn☃\\uD83D\\uDCAA"),
            Arguments.of("☃"),
            Arguments.of("ᴮᴵᴳᴮᴵᴿᴰ"),
            Arguments.of("null"),
            Arguments.of("'-prompt()-'"),
            Arguments.of("0L")
        )
    }
}