package net.peterlogan.javadim;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.block.ModBlocks;
import net.peterlogan.javadim.entity.ModEntities;
import net.peterlogan.javadim.entity.custom.JavacupineEntity;
import net.peterlogan.javadim.item.ModItemGroups;
import net.peterlogan.javadim.item.ModItems;
import net.peterlogan.javadim.util.ModCustomTrades;
import net.peterlogan.javadim.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Javadim implements ModInitializer {
	public static final String MOD_ID = "javadim";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModCustomTrades.registerCustomTrades();
		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register((ModEntities.JAVACUPINE), JavacupineEntity.createJavacupineAttributes());

		ModWorldGeneration.generateModWorldGen();

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.COFFEE_BLOCK)
				.lightWithItem(ModItems.MARX)
				.destDimID(new Identifier(Javadim.MOD_ID, "javadim"))
				.tintColor(100, 255, 255)
				.registerPortal();

	}
}