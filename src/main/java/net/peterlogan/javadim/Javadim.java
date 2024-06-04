package net.peterlogan.javadim;

import net.fabricmc.api.ModInitializer;

import net.peterlogan.javadim.block.ModBlocks;
import net.peterlogan.javadim.item.ModItemGroups;
import net.peterlogan.javadim.item.ModItems;
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
	}
}