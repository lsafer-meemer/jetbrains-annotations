// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/jetbrains/annotations/NotNull.java
package org.jetbrains.annotations

import kotlin.reflect.KClass

/**
 * An element annotated with NotNull claims `null` value is *forbidden*
 * to return (for methods), pass to (parameters) and hold (local variables and fields).
 * Apart from documentation purposes this annotation is intended to be used by static analysis tools
 * to validate against probable runtime errors and element contract violations.
 */
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.CLASS,
    AnnotationTarget.TYPE,
    AnnotationTarget.TYPE_PARAMETER
)
annotation class NotNull(
    /**
     * @return Custom exception message
     */
    val value: String = "",
    /**
     * @return Custom exception type that should be thrown when not-nullity contract is violated.
     * The exception class should have a constructor with one String argument (message).
     *
     * By default, [IllegalArgumentException] is thrown on null method arguments and
     * [IllegalStateException]  on null return value.
     */
    val exception: KClass<out Exception> = Exception::class,
)
