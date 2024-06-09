package net.peterlogan.javadim.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.peterlogan.javadim.block.ModBlocks;
import net.peterlogan.javadim.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture){
        super(dataOutput, completableFuture);
    }

    @Override
    public void generate(){
        addDrop(ModBlocks.COFFEE_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);
        addDrop(ModBlocks.COMMENT_GRASS);
        addDrop(ModBlocks.COLON_STONE);

        addDrop(ModBlocks.FALSE_COMMAND_BLOCK, oreDrops(ModBlocks.FALSE_COMMAND_BLOCK, ModItems.FALSE_COMMAND_SCRAP));
    }
}
