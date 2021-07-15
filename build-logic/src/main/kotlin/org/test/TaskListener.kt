package org.test

import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters
import org.gradle.tooling.events.FinishEvent
import org.gradle.tooling.events.OperationCompletionListener

abstract class TaskListener: BuildService<BuildServiceParameters.None>, AutoCloseable, OperationCompletionListener {
    override fun close() {
        // In this method, perform the end of build action
        println("Service has been closed!")
    }

    override fun onFinish(event: FinishEvent?) {
        // Collect task state
        println("Received event $event")
    }
}