package unknownuser2.clairclient.module.modules;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import unknownuser2.clairclient.module.Module;

import java.util.ArrayList;

public class Xray extends Module {
    ArrayList<Block> blocks;
    public Xray() {
        super("Xray", "Makes every block except ores invisable.", "xray");
        blocks = new ArrayList<Block>();
        blocks.add(Blocks.DIAMOND_ORE);
        blocks.add(Blocks.COAL_ORE);
        blocks.add(Blocks.COPPER_ORE);
        blocks.add(Blocks.GOLD_ORE);
        blocks.add(Blocks.IRON_ORE);
        blocks.add(Blocks.EMERALD_ORE);
        blocks.add(Blocks.LAPIS_ORE);
        blocks.add(Blocks.REDSTONE_ORE);
        blocks.add(Blocks.DEEPSLATE_DIAMOND_ORE);
        blocks.add(Blocks.DEEPSLATE_COAL_ORE);
        blocks.add(Blocks.DEEPSLATE_COPPER_ORE);
        blocks.add(Blocks.DEEPSLATE_GOLD_ORE);
        blocks.add(Blocks.DEEPSLATE_IRON_ORE);
        blocks.add(Blocks.DEEPSLATE_EMERALD_ORE);
        blocks.add(Blocks.DEEPSLATE_LAPIS_ORE);
        blocks.add(Blocks.DEEPSLATE_REDSTONE_ORE);
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }
}
