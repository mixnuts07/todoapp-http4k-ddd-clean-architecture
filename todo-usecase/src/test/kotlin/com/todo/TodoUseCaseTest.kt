package com.todo

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TodoUseCaseTest {
    @InjectMockKs
    lateinit var target: TodoUseCase
    @MockK
    lateinit var todoPort: TodoPort
    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }
    @Test
    fun `todoを1件取得する`() {
        every { todoPort.getTodoById("1") } returns Todo(Id("1"), mockk(), mockk())
        target.getTodo("1")
        verify { todoPort.getTodoById("1") }
    }
}