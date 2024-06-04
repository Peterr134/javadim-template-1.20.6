package net.peterlogan.javadim.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peterlogan.javadim.Javadim;

public class ModItems {
    public static final Item SOYLENT = registerItem("soylent", new Item(new Item.Settings()));
    public static final Item SOY_BEAN = registerItem("soy_bean", new Item(new Item.Settings()));
    public static final Item MARX = registerItem("marx", new Item(new Item.Settings()));
    public static final Item FALSE_COMMAND_SCRAP = registerItem("false_command_scrap", new Item(new Item.Settings()));
    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries){
    }

    private static void addItemsToWeaponItemGroup(FabricItemGroupEntries entries){
        entries.add(MARX);
    }
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Javadim.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Javadim.LOGGER.info("Registering Mod Items for " + Javadim.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToWeaponItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
