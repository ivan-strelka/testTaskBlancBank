package api.utils.data

import api.dto.AddCategoryRequest
import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.fakerConfig
import io.qameta.allure.Step
import java.util.*


fun randomizer(): Faker {
    val config = fakerConfig { locale = "en-US" }
    return Faker(config)
}

@Step("Создаём body случайную категорию со всеми полями с isVisible = true")
fun createRandomCategory(): AddCategoryRequest {
    return AddCategoryRequest(randomizer().name.firstName(), true, randomizer().company.name())
}

@Step("Создаём body случайную категорию со всеми полями с isVisible = true")
fun createRandomCategory2(): AddCategoryRequest {
    return AddCategoryRequest(randomizer().name.firstName(), true, randomizer().company.name())
}

@Step("Создаём случайный UUID")
fun getRandomUUID(): UUID {
    return UUID.randomUUID()
}

@Step("Создаём случайный Integer")
fun generateRndInt(): String {
    return randomizer().random.nextInt(Int.MIN_VALUE..Int.MAX_VALUE).toString()
}

