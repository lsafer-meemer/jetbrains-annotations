// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/jetbrains/annotations/MustBeInvokedByOverriders.java
package org.jetbrains.annotations

/**
 * The annotation should be applied to overridable non-abstract method
 * and indicates that all the overriders must invoke this method via
 * superclass method invocation expression. The static analysis tools
 * may report a warning if overrider fails to invoke this method.
 *
 * @since 20.0.0
 */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.BINARY)
annotation class MustBeInvokedByOverriders
