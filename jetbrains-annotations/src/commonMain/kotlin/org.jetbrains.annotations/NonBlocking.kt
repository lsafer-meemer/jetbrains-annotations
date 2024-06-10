// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/jetbrains/annotations/NonBlocking.java
package org.jetbrains.annotations

/**
 * Indicates that the annotated method is inherently non-blocking and can be executed in a non-blocking context.
 *
 *
 * When this annotation is used on a `class`, all the methods declared by the annotated class are considered
 * *non-blocking*.
 *
 *
 * Apart from documentation purposes this annotation is intended to be used by static analysis tools to validate against
 * probable runtime errors and contract violations.
 *
 * @since 22.0.0
 */
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.CLASS
)
annotation class NonBlocking
