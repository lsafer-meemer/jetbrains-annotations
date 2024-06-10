// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/jetbrains/annotations/VisibleForTesting.java
package org.jetbrains.annotations

/**
 * A member or type annotated with VisibleForTesting claims that its visibility is higher than necessary,
 * only for testing purposes. In particular:
 *
 *  * If public or protected member/type is annotated with VisibleForTesting,
 * it's assumed that package-private access is enough for production code.
 *  * If package-private member/type is annotated with VisibleForTesting,
 * it's assumed that private access is enough for production code.
 *  * It's illegal to annotate private member/type as VisibleForTesting.
 *
 *
 *
 * This annotation means that the annotated element exposes internal data and breaks encapsulation
 * of the containing class; the annotation won't prevent its use from production code, developers
 * even won't see warnings if their IDE doesn't support the annotation. It's better to provide
 * proper API which can be used in production as well as in tests.
 *
 * @since 20.0.0
 */
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.FIELD,
    AnnotationTarget.CLASS
)
annotation class VisibleForTesting
