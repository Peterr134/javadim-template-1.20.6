package net.peterlogan.javadim.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.block.ModBlocks;
import net.peterlogan.javadim.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output){
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COFFEE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FALSE_COMMAND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMMENT_GRASS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COLON_STONE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MARX, Models.GENERATED);
        itemModelGenerator.register(ModItems.FALSE_COMMAND_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOYLENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOY_BEAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.FABRIC, Models.GENERATED);

        itemModelGenerator.register(ModItems.JAVACUPINE_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

    }
}
