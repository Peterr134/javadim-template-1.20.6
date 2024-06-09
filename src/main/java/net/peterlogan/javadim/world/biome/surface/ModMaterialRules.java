package net.peterlogan.javadim.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.peterlogan.javadim.block.ModBlocks;
import net.peterlogan.javadim.world.biome.ModBiomes;

public class ModMaterialRules {

    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule NEW_STONE = makeStateRule(ModBlocks.COLON_STONE);
    private static final MaterialRules.MaterialRule NEW_GRASS = makeStateRule(ModBlocks.COMMENT_GRASS);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.JAVA_BIOME),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, NEW_STONE)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, NEW_GRASS)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
