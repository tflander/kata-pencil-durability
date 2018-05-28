package todd

import org.junit.Test
import assertk.assert
import assertk.assertions.*

class BddTests {

    private val paper = Paper();
    private val pencil = Pencil();

    @Test
    fun `As a writer, I want to be able use a pencil to write text on a sheet of paper, so that I can better remember my thoughts*`() {
        pencil.write("foo").on(paper)
        assert(paper.message).isEqualTo("foo")
    }
}