package api.utils.data

import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.fakerConfig
import io.qameta.allure.Step
import java.util.*


fun randomizer(): Faker {
    val config = fakerConfig { locale = "en-US" }
    return Faker(config)
}

@Step("Создаём случайный UUID")
fun getRandomUUID(): UUID {
    return UUID.randomUUID()
}

@Step("Создаём случайный Integer")
fun generateRndInt(): String {
    return randomizer().random.nextInt(1..Int.MAX_VALUE).toString()
}

@Step("Создаём случайный percentDiscount")
fun generateRndPercentDiscount(): String {
    return randomizer().random.nextInt(1..100).toString()
}

@Step("Создаём случайный firstName")
fun generateRndFirstName() = randomizer().name.firstName()

@Step("Создаём случайный company name")
fun generateRndCompanyName() = randomizer().company.name()
