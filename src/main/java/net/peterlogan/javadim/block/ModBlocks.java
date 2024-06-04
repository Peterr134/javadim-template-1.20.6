package net.peterlogan.javadim.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.mixin.object.builder.AbstractBlockSettingsAccessor;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.HayBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.Javadim;

public class ModBlocks {

    public static final Block COFFEE_BLOCK = registerBlock("coffee_block",
            new Block(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK)));

    public static final Block FALSE_COMMAND_BLOCK = registerBlock("false_command_block",
            new Block(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(Javadim.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Javadim.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Javadim.LOGGER.info("Registering ModBlocks for " + Javadim.MOD_ID);
    }
}
