import org.gradle.build.event.BuildEventsListenerRegistry
import org.test.TaskListener

// This gets us access to the BuildEventsListenerRegistry in a precompiled script plugin.
// In a regular plugin, simply @Inject it into the plugin class
interface ServiceAccessor {
    @get:Inject
    val registry: BuildEventsListenerRegistry
}

val accessor = objects.newInstance(ServiceAccessor::class)

// Register our build service
val listener = gradle.sharedServices.registerIfAbsent("taskListener", TaskListener::class) { }
// And make sure it gets task completion events
accessor.registry.onTaskCompletion(listener)
