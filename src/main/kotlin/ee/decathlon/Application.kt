package ee.decathlon

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@EnableConfigurationProperties
@PropertySource("classpath:version.properties")
open class Application {

    init {

        println("App started")

    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
