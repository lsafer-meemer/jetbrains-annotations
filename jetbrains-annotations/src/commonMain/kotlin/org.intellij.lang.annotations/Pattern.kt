// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/intellij/lang/annotations/Pattern.java
package org.intellij.lang.annotations

import org.jetbrains.annotations.NonNls

/**
 * Specifies that an element of the program represents a string that must completely match given regular expression.
 * Code editors may use this annotation to report errors if the literals that assigned to the annotated variables,
 * passed as arguments to the annotated parameters, or returned from the annotated methods, do not match the supplied
 * pattern.
 *
 *
 * This annotation also could be used as a meta-annotation, to define other annotations for convenience.
 * E.g. the following annotation could be defined to annotate the strings that represent UUIDs:
 *
 * <pre>
 * &#64;Pattern("[\\dA-Fa-f]{8}-[\\dA-Fa-f]{4}-[\\dA-Fa-f]{4}-[\\dA-Fa-f]{4}-[\\dA-Fa-f]{12}")
 * &#64;interface UUID {}
</pre> *
 *
 *
 * Note that using the derived annotation as meta-annotation is not supported.
 * Meta-annotation works only one level deep.
 *
 * @see RegExp
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
annotation class Pattern(
    /**
     * A regular expression that matches all the valid string literals that assigned to the annotated variables,
     * passed as arguments to the annotated parameters, or returned from the annotated methods.
     */
    @Language("RegExp")
    val value: @NonNls String,
)
