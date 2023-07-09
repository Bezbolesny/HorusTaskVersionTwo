package pl.horus;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Block block1 = new Block("Red", "Wood");
        Block block2 = new Block("Blue", "Brick");
        Block block3 = new Block("Green", "Wood");
        Block block4 = new Block("Red", "Stone");

        Wall wall = new Wall();
        wall.addBlock(block1);
        wall.addBlock(block2);
        wall.addBlock(block3);
        wall.addBlock(block4);

        Optional<pl.horus.interfaces.Block> foundBlock = wall.findBlockByColor("Blue");
        if (foundBlock.isPresent()) {
            pl.horus.interfaces.Block block = foundBlock.get();
            System.out.println("Found block by color: " + block.getColor() + " " + block.getMaterial());
        } else {
            System.out.println("Block not found.");
        }

        List<pl.horus.interfaces.Block> blocksByMaterial = wall.findBlocksByMaterial("Wood");
        System.out.println("Blocks by material:");
        for (pl.horus.interfaces.Block block : blocksByMaterial) {
            System.out.println(block.getColor() + " " + block.getMaterial());
        }

        int blockCount = wall.count();
        System.out.println("Block count: " + blockCount);
    }

}
