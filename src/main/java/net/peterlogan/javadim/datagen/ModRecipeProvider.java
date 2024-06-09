package net.peterlogan.javadim.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.block.ModBlocks;
import net.peterlogan.javadim.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Items.COCOA_BEANS,RecipeCategory.DECORATIONS, ModBlocks.COFFEE_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOYLENT, 1)
                .pattern("X")
                .pattern("#")
                .input('X', ModItems.SOY_BEAN)
                .input('#', Items.GLASS_BOTTLE)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(ModItems.SOY_BEAN), conditionsFromItem(ModItems.SOY_BEAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOYLENT)));

        //region Fabric Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FALSE_COMMAND_HELMET, 1)
                .pattern("XXX")
                .pattern("X X")
                .input('X', ModItems.FALSE_COMMAND_SCRAP)
                .criterion(hasItem(ModItems.FALSE_COMMAND_SCRAP), conditionsFromItem(ModItems.FALSE_COMMAND_SCRAP))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FALSE_COMMAND_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FALSE_COMMAND_CHESTPLATE, 1)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModItems.FALSE_COMMAND_SCRAP)
                .criterion(hasItem(ModItems.FALSE_COMMAND_SCRAP), conditionsFromItem(ModItems.FALSE_COMMAND_SCRAP))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FALSE_COMMAND_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FALSE_COMMAND_LEGGINGS, 1)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.FALSE_COMMAND_SCRAP)
                .criterion(hasItem(ModItems.FALSE_COMMAND_SCRAP), conditionsFromItem(ModItems.FALSE_COMMAND_SCRAP))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FALSE_COMMAND_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FALSE_COMMAND_BOOTS, 1)
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.FALSE_COMMAND_SCRAP)
                .criterion(hasItem(ModItems.FALSE_COMMAND_SCRAP), conditionsFromItem(ModItems.FALSE_COMMAND_SCRAP))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FALSE_COMMAND_BOOTS)));
        //endregion
    }
}
