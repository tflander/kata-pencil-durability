package todd

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class PencilDurabilityTest {

    lateinit var paper: Paper

    @Before
    fun setUp() {
        paper = Paper()
    }

    /*

 When a pencil is created, it can be provided with a value for point durability. The pencil will be able to write only a limited number of characters before it goes dull. After it goes dull, every character it is directed to write will appear as a space. A pencil created with a high point durability will still go dull, but not as fast as one with a lower durability rating.
 Writing spaces and newlines expends no graphite, therefore "writing" these characters should not affect the pencil point.
 Lowercase letters should degrade the pencil point by a value of one, and capital letters should degrade the point by two. Hence when a pencil with a point durability of four is instructed to write the string "text", the paper will contain the entire string. But if a pencil with point durability of four is instructed to write the string "Text", the paper will only show "Tex ".
     */

    @Test
    fun `a pencil with 1 durability can write a single lowercase letter`() {
        val pencil = Pencil(1)
        pencil.write("a")?.on(paper)
        assert(paper.message).isEqualTo("a")
        assert(pencil.durability).isEqualTo(0)
        pencil.write("b")?.on(paper)
        assert(paper.message).isEqualTo("a ")
    }

    @Test
    fun `a pencil will right as many letters of a message as possible before failing`() {
        val pencil = Pencil(3)
        pencil.write("testing")?.on(paper)
        assert(paper.message).isEqualTo("tes    ")
        assert(pencil.durability).isEqualTo(0)
    }

    @Test
    fun `white space does not expend durability`() {
        val pencil = Pencil(3)
        pencil.write("a ")?.on(paper)
        assert(paper.message).isEqualTo("a ")
        assert(pencil.durability).isEqualTo(2)
        pencil.write("""b
c
        """.trimMargin())?.on(paper)
        assert(paper.message).isEqualTo("""a b
c
        """.trimMargin())
    }

    @Test
    fun `Capitol letters expend two durability`() {
        val pencil = Pencil(10)
        pencil.write("Test")?.on(paper)
        assert(paper.message).isEqualTo("Test")
        assert(pencil.durability).isEqualTo(5)
    }
}