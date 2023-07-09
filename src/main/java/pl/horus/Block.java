package pl.horus;

import pl.horus.interfaces.CompositeBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Block implements CompositeBlock {

    public String color;
    public String material;
    public final List<Block> blocksList = new ArrayList<>();


    public Block(String color, String material){
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List<pl.horus.interfaces.Block> getBlocks() {
        return new ArrayList<>(List.copyOf(blocksList));
    }

    @Override
    public String toString(){
        return getColor()+ " " + getMaterial();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(color, block.color) && Objects.equals(material, block.material) && Objects.equals(blocksList, block.blocksList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material, blocksList);
    }
}
