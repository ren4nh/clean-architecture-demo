package br.com.hartwig.commons.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AppLogger {

    companion object Factory {
        val logger: Logger = LoggerFactory.getLogger(AppLogger::javaClass.name)
    }
}
