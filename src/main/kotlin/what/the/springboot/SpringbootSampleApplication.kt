package what.the.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootSampleApplication

fun main(args: Array<String>) {
    runApplication<SpringbootSampleApplication>(*args)
}
