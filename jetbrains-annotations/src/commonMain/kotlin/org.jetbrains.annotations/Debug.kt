// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/jetbrains/annotations/Debug.java
package org.jetbrains.annotations

import org.intellij.lang.annotations.Language

/**
 * @since 18.0.0
 */
object Debug {
    /**
     * Allows to change the presentation of an object in debuggers
     */
    @Target(AnnotationTarget.CLASS)
    @Retention(AnnotationRetention.BINARY)
    annotation class Renderer(
        /**
         * Expression to be evaluated and used as the textual representation of the object.<br></br>
         * `this` refers to the class instance being presented
         */
        @Language(
            value = "JAVA",
            prefix = "class Renderer{String \$text(){return ",
            suffix = ";}}"
        )
        val text: @NonNls String = "",
        /**
         * Expression to be evaluated to obtain an array of object's children.<br></br>
         * Usually the result is an array of elements in a collection, or an array of entries in a map.<br></br>
         * `this` refers to the class instance being presented
         */
        @Language(
            value = "JAVA",
            prefix = "class Renderer{Object[] \$childrenArray(){return ",
            suffix = ";}}"
        )
        val childrenArray: @NonNls String = "",
        /**
         * Expression to be evaluated to check if the object has any children at all.<br></br>
         * This should work faster than [.childrenArray] and return boolean.<br></br>
         * `this` refers to the class instance being presented
         */
        @Language(
            value = "JAVA",
            prefix = "class Renderer{boolean \$hasChildren(){return ",
            suffix = ";}}"
        )
        val hasChildren: @NonNls String = "",
    )
}
