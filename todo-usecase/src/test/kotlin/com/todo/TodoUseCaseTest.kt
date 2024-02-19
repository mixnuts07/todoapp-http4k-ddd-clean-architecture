package com.todo

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class TodoUseCaseTest {
    @Test
    fun `todoを1件取得する`() {
        val target = mockk<TodoUseCase>()
        val actual = true
        val expected = false
        every { target.getTodo("1") } returns Todo(Id("1"), Title("これはIDが1のタイトル"))
        assertEquals(actual, expected)
    }
}