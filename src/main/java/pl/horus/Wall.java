package pl.horus;

import pl.horus.interfaces.Block;
import pl.horus.interfaces.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Wall implements Structure {

    List<Block> blocks = new ArrayList<>();

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equalsIgnoreCase(color))
                .findAny();
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equalsIgnoreCase(material))
                .toList();
    }

    @Override
    public int count() {
        return blocks.size();
    }

}
