// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/jetbrains/annotations/PropertyKey.java
package org.jetbrains.annotations

/**
 * Specifies that a method parameter, local variable, field or a method return value
 * must be a valid property key in a specific resource bundle. When a string literal
 * which is not a property key in the specified bundle is passed as a parameter,
 * static analyzers may highlight it as an error. The annotation is also could be used
 * by IDEs to provide completion in string literals passed as parameters.
 */
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.FIELD,
    AnnotationTarget.CLASS,
    AnnotationTarget.TYPE,
    AnnotationTarget.TYPE_PARAMETER
)
annotation class PropertyKey(
    /**
     * The full-qualified name of the resource bundle in which the property keys must
     * be present. Consists of a full-qualified name of the package corresponding to the
     * directory where the resource bundle is located and the base name of the resource
     * bundle (with no locale specifier or extension), separated with a dot.
     */
    val resourceBundle: @NonNls String,
)
