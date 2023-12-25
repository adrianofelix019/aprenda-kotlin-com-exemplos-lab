// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class DifficultyLevel { BASIC, MEDIUM, HARD }

data class User(val name: String)

data class EducationalContent(var title: String, val duration: Int = 60)

data class Course(
    val name: String,
    var contents: List<EducationalContent>,
    val difficultyLevel: DifficultyLevel
) {

    val subscribers = mutableListOf<User>()
    
    fun register(user: User) {
        subscribers.add(user)
    }

    fun registerAll(users: List<User>) {
        users.forEach { subscribers.add(it) }
    }

    fun listContents() {
        println("Contents of $name course.")
        println("Difficulty level: ${this.difficultyLevel}")
        contents.forEach {
            println("${it.title} - Duration ${it.duration}m")
        }
    }

    fun listSubscribers() {
        subscribers.forEachIndexed { index, user ->
            println("${index + 1} - ${user.name}")
        }
    }
}

fun main() {
    val educationalContents1 = listOf(
        EducationalContent("Kotlin", 120),
        EducationalContent("OOP", 90),
        EducationalContent("Tests", 60),
    )

    val educationalContents2 = listOf(
        EducationalContent("Java", 120),
        EducationalContent("SQL", 60),
        EducationalContent("Spring", 120),
    )

    val educationalContents3 = listOf(
        EducationalContent("Elixir", 120),
        EducationalContent("Functional Programming", 120),
        EducationalContent("Phoenix", 180),
    )

    val course1 = Course("Kotlin Course",
        educationalContents1,
        DifficultyLevel.BASIC
    )

    val course2 = Course("Java Course",
        educationalContents2,
        DifficultyLevel.MEDIUM
    )

    val course3 = Course("Elixir Course",
        educationalContents3,
        DifficultyLevel.HARD
    )

    val user1 = User("Adrian")
    val user2 = User("Bob")
    val user3 = User("Ana")
    val user4 = User("John")

    course1.register(user1)
    course1.register(user2)
    course1.register(user3)
    course1.register(user4)

    course1.listContents()
    course1.listSubscribers()

    course2.register(user1)
    course2.register(user2)
    course2.register(user3)
    course2.register(user4)

    course2.listContents()
    course2.listSubscribers()

    course3.registerAll(listOf(
        User("Larry"),
        User("Alex"),
        User("Mike"),
        User("James")
    ))

    course3.listContents()
    course3.listSubscribers()
}
