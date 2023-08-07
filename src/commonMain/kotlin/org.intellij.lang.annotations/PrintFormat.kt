// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/intellij/lang/annotations/PrintFormat.java
@file:Suppress("RegExpUnnecessaryNonCapturingGroup")

package org.intellij.lang.annotations

/**
 * Specifies that the method parameter is a printf-style print format pattern,
 * as described in [java.util.Formatter].
 *
 *
 * Code editors that support [Pattern] annotation will check
 * the syntax of this value automatically. It could also be especially recognized to
 * check whether the subsequent var-arg arguments match the expected arguments
 * mentioned in the pattern. E. g., consider that the following method is annotated:
 * <pre>`
 * void myprintf(&#64;PrintFormat String format, Object... args) {...}
`</pre> *
 *
 *
 * In this case, code editors might recognize that the following call is erroneous,
 * and issue a warning:
 * <pre>`
 * myprintf("%d\n", "hello"); // warning: a number expected instead of "hello"
`</pre> *
 *
 * @see Pattern
 */
@MustBeDocumented
@Pattern(PRINT_FORMAT)
annotation class PrintFormat

// %[argument_index$][flags][width][.precision]conversion
// Expression is taken from java.util.Formatter.fsPattern
@Language("RegExp")
private const val ARG_INDEX = "(?:\\d+\\$)?"

@Language("RegExp")
private const val FLAGS = "(?:[-#+ 0,(<]*)?"

@Language("RegExp")
private const val WIDTH = "(?:\\d+)?"

@Language("RegExp")
private const val PRECISION = "(?:\\.\\d+)?"

@Language("RegExp")
private const val CONVERSION = "(?:[tT])?(?:[a-zA-Z%])"

@Language("RegExp")
private const val TEXT = "[^%]|%%"

@Language("RegExp")
private const val PRINT_FORMAT = "(?:" + TEXT + "|" +
        "(?:%" +
        ARG_INDEX +
        FLAGS +
        WIDTH +
        PRECISION +
        CONVERSION + ")" +
        ")*"
