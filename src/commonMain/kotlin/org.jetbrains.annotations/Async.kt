// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/jetbrains/annotations/Async.java
package org.jetbrains.annotations

/**
 * Helper annotations for asynchronous computation.
 * Used for example in IntelliJ IDEA's debugger for async stacktraces feature.
 *
 * @author egor
 */
object Async {
    /**
     * Indicates that the marked method schedules async computation.
     * Scheduled object is either `this`, or the annotated parameter value.
     */
    @Retention(AnnotationRetention.BINARY)
    @Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER,
        AnnotationTarget.CONSTRUCTOR,
        AnnotationTarget.VALUE_PARAMETER
    )
    annotation class Schedule

    /**
     * Indicates that the marked method executes async computation.
     * Executed object is either `this`, or the annotated parameter value.
     * This object needs to match with the one annotated with [Schedule]
     */
    @Retention(AnnotationRetention.BINARY)
    @Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER,
        AnnotationTarget.CONSTRUCTOR,
        AnnotationTarget.VALUE_PARAMETER
    )
    annotation class Execute
}
