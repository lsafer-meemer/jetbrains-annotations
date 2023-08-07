// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/jetbrains/annotations/Nullable.java
package org.jetbrains.annotations

/**
 * An element annotated with [Nullable] claims `null` value is perfectly *valid*
 * to return (for methods), pass to (parameters) or hold in (local variables and fields).
 * Apart from documentation purposes this annotation is intended to be used by static analysis tools
 * to validate against probable runtime errors or element contract violations.
 *
 *
 * By convention, this annotation applied only when the value should *always* be checked against `null`
 * because the developer could do nothing to prevent null from happening.
 * Otherwise, too eager [Nullable] usage could lead to too many false positives from static analysis tools.
 *
 *
 * For example, [java.util.Map.get] should *not* be annotated [Nullable] because
 * someone may have put not-null value in the map by this key and is expecting to find this value there ever since.
 *
 *
 * On the other hand, the [java.lang.ref.Reference.get] should be annotated [Nullable] because
 * it returns `null` if object got collected which can happen at any time completely unexpectedly.
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
annotation class Nullable(
    /**
     * @return textual reason when the annotated value could be null, for documentation purposes.
     */
    val value: @NonNls String = "",
)
