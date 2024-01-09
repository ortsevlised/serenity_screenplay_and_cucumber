import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Interaction
import org.slf4j.LoggerFactory

class Log(private val message: String) : Interaction {
    private val logger = LoggerFactory.getLogger(Log::class.java)

    override fun <T : Actor> performAs(actor: T) {
        logger.info(message)
    }

    companion object {
        fun info(message: String) = Log(message)
    }
}
