// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/intellij/lang/annotations/Language.java
package org.intellij.lang.annotations

import org.jetbrains.annotations.NonNls

/**
 * Specifies that an element of the program represents a string that is a source code on a specified language.
 * Code editors may use this annotation to enable syntax highlighting, code completion and other features
 * inside the literals that assigned to the annotated variables, passed as arguments to the annotated parameters,
 * or returned from the annotated methods.
 *
 *
 * This annotation also could be used as a meta-annotation, to define derived annotations for convenience.
 * E.g. the following annotation could be defined to annotate the strings that represent Java methods:
 *
 * <pre>
 * &#64;Language(value = "JAVA", prefix = "class X{", suffix = "}")
 * &#64;interface JavaMethod {}
</pre> *
 *
 *
 * Note that using the derived annotation as meta-annotation is not supported.
 * Meta-annotation works only one level deep.
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
    AnnotationTarget.ANNOTATION_CLASS,
    //
    AnnotationTarget.CLASS,
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FIELD,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.TYPE,
    // AnnotationTarget.EXPRESSION,
    AnnotationTarget.FILE,
    AnnotationTarget.TYPEALIAS,
)
annotation class Language(
    /**
     * Language name like "JAVA", "HTML", "XML", "RegExp", etc.
     * The complete list of supported languages is not specified. However, at least the following languages should be
     * recognized:
     *
     *  * "JAVA" - Java programming language
     *  * "HTML" - HTML
     *  * "XML" - XML
     *  * "RegExp" - Regular expression supported by Java [java.util.regex.Pattern]
     *
     */
    val value: @NonNls String,
    /**
     * A constant prefix that is assumed to be implicitly added before the literal.
     * This helps to apply proper highlighting when the program element represents only a part of the valid program.
     * E.g. if the method parameter accepts a Java method, it could be annotated as
     * `void methodProcessor(@Language(value="JAVA", prefix="class X {", suffix="}")`.
     */
    val prefix: @NonNls String = "",
    /**
     * A constant suffix that is assumed to be implicitly added after the literal. See [.prefix] for details.
     */
    val suffix: @NonNls String = "",
)
