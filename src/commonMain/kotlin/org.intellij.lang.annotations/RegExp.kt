// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/intellij/lang/annotations/RegExp.java
package org.intellij.lang.annotations

import org.jetbrains.annotations.NonNls

/**
 * Specifies that an element of the program represents a string that is a regular expression text supported
 * by [java.util.regex.Pattern].
 * Code editors may use this annotation to enable syntax highlighting, code completion and other features
 * inside the literals that assigned to the annotated variables, passed as arguments to the annotated parameters,
 * or returned from the annotated methods.
 *
 * @see Language
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
    AnnotationTarget.ANNOTATION_CLASS
)
@Language("RegExp")
annotation class RegExp(
    /**
     * A constant prefix that is assumed to be implicitly added before the regular expression.
     */
    val prefix: @NonNls String = "",
    /**
     * A constant suffix that is assumed to be implicitly added after the regular expression.
     */
    val suffix: @NonNls String = "",
)
