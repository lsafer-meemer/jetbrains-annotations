// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/intellij/lang/annotations/Subst.java
package org.intellij.lang.annotations

/**
 * Specifies the replacement value for non-constant variables and method return values.
 * This may help static analyzers to properly parse the concatenation of several values
 * which is used in @[Language] or [Pattern] context.
 *
 *
 * Example:
 * <pre>
 * &#64;Subst("Tahoma")
 * final String font = new JLabel().getFont().getName();
 *
 * &#64;Language("HTML")
 * String message = "&lt;html&gt;&lt;span style='font: " + font + "; font-size:smaller'&gt;"
 * + ... + "&lt;/span&gt;&lt;/html&gt;";
</pre> *
 *
 *
 * Here the parser assumes that when `font` appears in the concatenation its value is `"Tahoma"`,
 * so it can continue parsing the concatenation.
 *
 *
 * @see Language
 *
 * @see Pattern
 */
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.FIELD,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.VALUE_PARAMETER
)
annotation class Subst(val value: String)
