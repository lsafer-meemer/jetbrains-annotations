// https://github.com/JetBrains/java-annotations/blob/784429a1111930d51904cf8dcf4259f077d6bc7f/common/src/main/java/org/intellij/lang/annotations/Flow.java
package org.intellij.lang.annotations

/**
 * This annotation assists the 'Data flow to this' feature by describing data flow
 * from the method parameter to the corresponding container (e.g. `ArrayList.add(item)`)
 * or from the container to the method return value (e.g. `Set.toArray()`)
 * or between method parameters (e.g. `System.arraycopy(array1, 0, array2, length)`)
 */
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class Flow(
    /**
     * Denotes the source of the data flow.<br></br>
     * Allowed values are:<br></br>
     *
     *
     *  * `THIS_SOURCE` - Means that the data flows from this container.<br></br>
     * E.g. annotation for java.util.List method get(index) means the method reads contents of list and returns it.<br></br>
     * `@Flow(source = THIS_SOURCE) T get(int index);`<br></br>
     *
     *  *
     * `this.`Field name - means that the data flows from this container some (synthetic) field.<br></br>
     * E.g. annotation for java.util.Map.keySet() method here means that it returns data from the map from the field named "keys".<br></br>
     * `@Flow(source = "this.keys") Set<K> keySet();`
     *
     *
     * By default, the source() value is:<br></br>
     *
     *  *
     * [.THIS_SOURCE] if the method was annotated, e.g.<br></br>
     * `@Flow(sourceIsContainer=true, targetIsContainer=true) Object[] Collection.toArray()`<br></br>
     * Here the annotation tells us that java.util.Collection.toArray() method<br></br>
     * reads the contents of this collection (source=THIS_SOURCE by default) and passes it outside.
     *
     *  *
     * Corresponding argument if the method parameter was annotated, e.g.<br></br>
     * `void List.add(@Flow(targetIsContainer=true) E item)`<br></br>
     * Here the annotation tells us that java.util.List.add(E item) method<br></br>
     * takes the argument (source="item" by default) and passes it to this collection.
     *
     *
     */
    val source: String = DEFAULT_SOURCE,
    /**
     * true if the data source is container and we should track not the expression but its contents.<br></br>
     * E.g. the java.util.ArrayList constructor takes the collection and stores its contents:<br></br>
     * ArrayList(<pre>`@Flow(sourceIsContainer=true, targetIsContainer=true) Collection<? extends E> collection `</pre>) <br></br>
     * By default it's false.
     */
    val sourceIsContainer: Boolean = false,
    /**
     * Denotes the destination of the data flow.<br></br>
     * Allowed values are:<br></br>
     *
     *
     *  * `THIS_TARGET` - Means that the data flows inside this container (of the class the annotated method belongs to).<br></br>
     * E.g. annotation for java.util.List method add(element) means the method takes the argument and passes it to this collection.<br></br>
     * `boolean add(@Flow(target=THIS_TARGET, targetIsContainer=true) E element);`<br></br>
     *
     *  *
     * Parameter name - means the data flows to this parameter.<br></br>
     * E.g.<br></br>
     * `void arraycopy(@Flow(sourceIsContainer=true, target="dest", targetIsContainer=true) Object src, int srcPos, Object dest, int destPos, int length)`<br></br>
     * means that java.lang.System.arraycopy() method takes its first argument and passes it to the "dest" parameter.
     *
     *  *
     * `this.`Field name - means that the data flows to this container in some (synthetic) field.<br></br>
     * E.g. annotation for java.util.Map.put(key, value) method here means that it takes the argument 'key' and stores the data in some (hidden) field named "keys".<br></br>
     * `V put(@Flow(target = "this.keys", targetIsContainer=true) K key, V value);`
     *
     *
     * By default, the target() value is:<br></br>
     *
     *  *
     * [.THIS_TARGET] if the parameter was annotated, e.g.<br></br>
     * `void List.set(int index, @Flow(targetIsContainer=true) E element)`<br></br>
     * Here the annotation tells us that java.util.List.set(index, element) method<br></br>
     * reads its second argument 'element' and passes it to this collection (target=THIS_TARGET by default).
     *
     *  *
     * [.RETURN_METHOD_TARGET] if the method was annotated, e.g.:<br></br>
     * `@Flow(sourceIsContainer=true) E List.remove(int index)`<br></br>
     * Here the annotation tells us that java.util.List.remove(int index) method<br></br>
     * returns the data from its collection (target=RETURN_METHOD_TARGET by default).
     *
     *
     */
    val target: String = DEFAULT_TARGET,
    /**
     * true if the data target is container and we should track not the expression but its contents.<br></br>
     * E.g. the java.lang.System.arraycopy() method parameter 'dest' is actually an array:<br></br>
     * `void arraycopy(@Flow(sourceIsContainer=true, target="dest", targetIsContainer=true) Object src, int srcPos, Object dest, int destPos, int length)`<br></br>
     * By default it's false.
     */
    val targetIsContainer: Boolean = false,
) {
    companion object {
        const val DEFAULT_SOURCE =
            "The method argument (if parameter was annotated) or this container (if instance method was annotated)"
        const val THIS_SOURCE = "this"
        const val DEFAULT_TARGET =
            "This container (if the parameter was annotated) or the return value (if instance method was annotated)"
        const val RETURN_METHOD_TARGET = "The return value of this method"
        const val THIS_TARGET = "this"
    }
}
