// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/jetbrains/annotations/Nls.java
package org.jetbrains.annotations

/**
 * Specifies that an element of the program is an user-visible string which needs to be localized.
 * This annotation is intended to be used by localization tools for
 * detecting strings which should be reported as requiring localization.
 *
 *
 *
 * This annotation also could be used as a meta-annotation, to define derived annotations for convenience.
 * E.g. the following annotation could be defined to annotate the strings that represent dialog titles:
 *
 * <pre>
 * &#64;Nls(capitalization = Capitalization.Title)
 * &#64;interface DialogTitle {}
</pre> *
 *
 *
 * Note that using the derived annotation as meta-annotation is not supported.
 * Meta-annotation works only one level deep.
 *
 * @see NonNls
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
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.FILE
)
annotation class Nls(val capitalization: Capitalization = Capitalization.NotSpecified) {
    enum class Capitalization {
        NotSpecified,

        /**
         * e.g. This Is a Title
         */
        Title,

        /**
         * e.g. This is a sentence
         */
        Sentence
    }
}
