package todd

import org.junit.Test
import assertk.assert
import assertk.assertions.*
import org.junit.Before

class BddTests {

    private lateinit var paper: Paper
    private lateinit var pencil: Pencil

    @Before
    fun setUp() {
        paper = Paper()
        pencil = Pencil(10)
    }

    @Test
    fun `As a writer, I want to be able use a pencil to write text on a sheet of paper, so that I can better remember my thoughts*`() {
        pencil.write("foo")?.on(paper)
        assert(paper.message).isEqualTo("foo")
        pencil.write(" bar")?.on(paper)
        assert(paper.message).isEqualTo("foo bar")
    }

    @Test
    fun `As a pencil manufacturer, I want writing to cause a pencil point to go dull, so that I can sell more pencils`() {
        pencil.write("testing...1...2...3...testing")?.on(paper)
        assert(paper.message).isEqualTo("testing...                   ")
    }


    /*




 When a pencil is created, it can be provided with a value for point durability. The pencil will be able to write only a limited number of characters before it goes dull. After it goes dull, every character it is directed to write will appear as a space. A pencil created with a high point durability will still go dull, but not as fast as one with a lower durability rating.
 Writing spaces and newlines expends no graphite, therefore "writing" these characters should not affect the pencil point.
 Lowercase letters should degrade the pencil point by a value of one, and capital letters should degrade the point by two. Hence when a pencil with a point durability of four is instructed to write the string "text", the paper will contain the entire string. But if a pencil with point durability of four is instructed to write the string "Text", the paper will only show "Tex ".
     */
}