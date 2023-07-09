package pl.horus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private Wall wall;

    @BeforeEach
    public void initializeList() {
        wall = new Wall();
        wall.addBlock(new Block("Red", "Wood"));
        wall.addBlock(new Block("Blue", "Brick"));
        wall.addBlock(new Block("Green", "Wood"));
        wall.addBlock(new Block("Red", "Stone"));
    }

    @Test
    public void findBlockByColorHappyPath() {
        // when
        Optional<pl.horus.interfaces.Block> foundBlock = wall.findBlockByColor("Blue");

        // then
        assertEquals("Blue", foundBlock.get().getColor());
    }

    @Test
    public void foundBlockByColorExist() {
        // when
        Optional<pl.horus.interfaces.Block> foundBlock = wall.findBlockByColor("Blue");

        // then
        assertTrue(foundBlock.isPresent());
    }

    @Test
    public void findBlockByColorNotFound() {
        // when
        Optional<pl.horus.interfaces.Block> foundBlock = wall.findBlockByColor("Yellow");

        // then
        assertFalse(foundBlock.isPresent());
    }

    @Test
    public void findBlocksByMaterialHappyPath() {
        // when
        List<pl.horus.interfaces.Block> blocksByMaterial = wall.findBlocksByMaterial("Wood");

        // then
        assertEquals(2, blocksByMaterial.size());
        for (pl.horus.interfaces.Block block : blocksByMaterial) {
            assertEquals("Wood", block.getMaterial());
        }
    }

    @Test
    public void findBlocksByMaterialNotFound() {
        // when
        List<pl.horus.interfaces.Block> blocksByMaterial = wall.findBlocksByMaterial("Metal");

        // then
        assertTrue(blocksByMaterial.isEmpty());
    }

    @Test
    public void testCount() {
        // when
        int blockCount = wall.count();

        // then
        assertEquals(4, blockCount);
    }

    @Test
    public void referencesToTheSameObjectShouldNotBeEqual() {
        // given
        Block blockOne = new Block("Red", "Wood");
        Block blockTwo = new Block("Yellow", "Wood");

        // then
        assertNotSame(blockOne, blockTwo);

    }

    @Test
    public void twoBlocksShouldBeEqualWhenColorAndMaterialAreTheSame() {
        // given
        Block blockOne = new Block("Red", "Wood");
        Block blockTwo = new Block("Red", "Wood");

        // then
        assertEquals(blockOne, blockTwo);

    }


}