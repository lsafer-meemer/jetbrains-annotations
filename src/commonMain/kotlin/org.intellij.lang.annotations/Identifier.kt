// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/intellij/lang/annotations/Identifier.java
package org.intellij.lang.annotations

@Pattern("\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*")
annotation class Identifier
