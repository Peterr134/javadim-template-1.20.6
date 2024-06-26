package net.peterlogan.javadim.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.Javadim;
import net.peterlogan.javadim.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup JAVADIM_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Javadim.MOD_ID,"javadim"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.javadim"))
                    .icon(() -> new ItemStack(ModItems.SOYLENT)).entries(((displayContext, entries) -> {
                        entries.add(ModItems.SOYLENT);
                        entries.add(ModItems.SOY_BEAN);
                        entries.add(ModItems.FALSE_COMMAND_SCRAP);
                        entries.add(ModItems.FABRIC);
                        entries.add(ModItems.MARX);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.JAVACUPINE_SPAWN_EGG);

                        entries.add(ModItems.FALSE_COMMAND_SWORD);
                        entries.add(ModItems.FALSE_COMMAND_SHOVEL);
                        entries.add(ModItems.FALSE_COMMAND_PICKAXE);
                        entries.add(ModItems.FALSE_COMMAND_AXE);
                        entries.add(ModItems.FALSE_COMMAND_HOE);

                        entries.add(ModBlocks.COFFEE_BLOCK);
                        entries.add(ModBlocks.FALSE_COMMAND_BLOCK);
                        entries.add(ModBlocks.SOUND_BLOCK);
                        entries.add(ModBlocks.COLON_STONE);
                        entries.add(ModBlocks.COMMENT_GRASS);

                    })).build());

    public static void registerItemGroups() {
        Javadim.LOGGER.info("Registering Item Groups for " + Javadim.MOD_ID);
    }
}
