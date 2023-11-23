package com.github.jinlee0.rusult.util

import org.junit.jupiter.api.Assertions
import com.github.jinlee0.rusult.Rusult

object AssertionExt {
    infix fun <T, E> Rusult<T, E>.assertEquals(other: Rusult<T, E>): Unit = Assertions.assertEquals(this, other)
    infix fun Any?.assertEquals(other: Any?): Unit = Assertions.assertEquals(this, other)
}
